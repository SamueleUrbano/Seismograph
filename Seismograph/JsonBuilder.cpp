/**
 * "JsonBuilder.h" implementation.
 */

#include "Arduino.h";
#include "JsonBuilder.h";

JsonBuilder::JsonBuilder() {
  this -> json = "";
}

void JsonBuilder::header(String apiKey) {
  this -> json.concat("{\"apiKey\": \"" + apiKey + "\", \"seismographData\": [");
}

void JsonBuilder::body(String xAxis, String yAxis, String zAxis, String date) {
  this -> json.concat("{\"xAxis\": " + xAxis + ",");
  this -> json.concat(" \"yAxis\": " + yAxis + ",");
  this -> json.concat(" \"zAxis\": " + zAxis + ",");
  this -> json.concat(" \"date\": \"" + date + "\"}, ");
}

void JsonBuilder::footer() {
  // Removes "\s" and "," from the last object of the json string
  this -> json = this -> json.substring(0, this -> json.length() - 2);
  this -> json.concat("]}");
}

void JsonBuilder::destroy() {
  this -> json = "";
}

String JsonBuilder::toString() {
  return this -> json;
}
