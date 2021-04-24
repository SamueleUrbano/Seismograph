#include <Wire.h>
#include <WiFi.h>
#include <HTTPClient.h>
#include "JsonBuilder.h"
 
const int MPU = 0x68;
int16_t xAxis, yAxis, zAxis;

const char* NET_SSID = "ssid";
const char* NET_PASSWORD = "password";
const char* API_SERVER = "api_link";
const char* API_KEY = "api_key"; // Not used now

const unsigned long TTW = 20000;
unsigned long passedTime = 0;

boolean isCold = true;

String request;

HTTPClient httpClient;

// Custom json builder
JsonBuilder jsonBuilderObject;
JsonBuilder *jsonBuilder = &jsonBuilderObject;

TaskHandle_t sendToServerTask;

void setup() {
  WiFi.begin(NET_SSID, NET_PASSWORD);
  delay(500);
  
  Wire.begin();
  Wire.beginTransmission(MPU);
  Wire.write(0x6B);
  Wire.write(0);
  Wire.endTransmission(true);
  delay(500);

  passedTime = millis();
  Serial.begin(9600);
}
 
void loop() {
  Wire.beginTransmission(MPU);
  Wire.write(0x3B);
  Wire.endTransmission(false);
  Wire.requestFrom(MPU, 14, 1);
  
  // Read data from the MPU module
  xAxis = Wire.read() << 8 | Wire.read();
  yAxis = Wire.read() << 8 | Wire.read();
  zAxis = Wire.read() << 8 | Wire.read(); 

  // Check if 20 seconds have passed or if it is the first power up
  if ((millis() - passedTime) >= TTW || isCold) {
    if (isCold) {
      isCold = !isCold;
      // Start building the json
      jsonBuilder -> header(API_KEY);
    } else {
      jsonBuilder -> footer();
      request = jsonBuilder -> toString();
      xTaskCreate(
        sendToServer,
        "",
        10000,
        NULL,
        1,
        &sendToServerTask
      );
    }
    delay(50);
    jsonBuilder -> destroy();
    jsonBuilder -> header(API_KEY);
    passedTime = millis();
  }
  jsonBuilder -> body(String(xAxis, DEC), String(yAxis, DEC), String(zAxis, DEC), "0000-12-25T00:00:00.000");
  
  delay(50);
}

/**
 * Thread method to send data at Server.
 * @param *argument - Thread parameters (now using a global variable).
 */
void sendToServer(void *argument) {
  int responseCode;
  
  httpClient.begin(API_SERVER);
  httpClient.addHeader("Content-Type", "application/json");
  Serial.println("Request");
  responseCode = httpClient.POST(request);
  Serial.println(responseCode);
  httpClient.end();

  vTaskDelete(NULL);
}
