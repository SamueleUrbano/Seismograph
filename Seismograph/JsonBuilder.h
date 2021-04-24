/*
 * Json Builder library, used to build the json for api.
 * Request: "application/json"
 * Pattern: 
 *          {
 *            "apiKey": "XXX-XXXXXXXXX#XX",
 *            "seismograph_data": [
 *              {
 *                "xAxis": 0.0,
 *                "yAxis": 0.0,
 *                "zAxis": 0.0,
 *                "date": "2021-04-20T00:00:00"
 *              }
 *            ]
 *          }
 * 
 * @author Urbano Samuele
 * @version - 1.0
 */

#ifndef JsonBuilder_h
#define JsonBuilder_h

#include "Arduino.h"

class JsonBuilder {
    
  public:
    JsonBuilder();
    
    void header(String apiKey);
    void body(String xAxis, String yAxis, String zAxis, String date);
    void footer();
    void destroy();
    
    String toString();

  private:
    String json;
};

#endif
