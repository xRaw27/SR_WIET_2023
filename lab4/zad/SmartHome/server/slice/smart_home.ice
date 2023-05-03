#ifndef SMARTHOME_ICE
#define SMARTHOME_ICE

module SmartHome
{

  // Refrigerator
  exception RefrigeratorIsAlreadyOn {};
  exception RefrigeratorIsSwitchedOff {};
  exception RefrigeratorTargetTemperatureOutOffRange {};
  exception FreezerTargetTemperatureOutOffRange {};

  class RefrigeratorParams
  {
    float minRefrigeratorTemperature;
    float maxRefrigeratorTemperature;
    optional(1) float minFreezerTemperature;
    optional(2) float maxFreezerTemperature;
  };

  class RefrigeratorSettings
  {
    float refrigeratorTargetTemperature;
    optional(1) float freezerTargetTemperature;
  };

  class RefrigeratorSensors
  {
    long timestamp;
    float refrigeratorTemperature;
    optional(1) float freezerTemperature;
  };

  sequence<RefrigeratorSensors> RefrigeratorSensorsSequence;

  interface Refrigerator
  {
    idempotent void powerOn() throws RefrigeratorIsAlreadyOn;
    idempotent void powerOff() throws RefrigeratorIsSwitchedOff;
    idempotent RefrigeratorParams getParams();
    idempotent RefrigeratorSettings getSettings();
    idempotent RefrigeratorSensorsSequence getSensorValues() throws RefrigeratorIsSwitchedOff;
    idempotent void setRefrigeratorTargetTemperature(float tmp) throws RefrigeratorIsSwitchedOff, RefrigeratorTargetTemperatureOutOffRange;
  };

  interface FreezerRefrigerator extends Refrigerator
  {
    idempotent void setFreezerTargetTemperature(float tmp) throws RefrigeratorIsSwitchedOff, FreezerTargetTemperatureOutOffRange;
  };

  // Bulb
  exception BulbCannotSetBrightnessInAutoMode {};
  exception BulbRGBValuesExceeded {};

  enum Mode { Auto, Manual };
  enum Brightness { Low, Medium, High };
  struct RGB
  {
    short R;
    short G;
    short B;
  };

  class BulbStatus
  {
    bool isSwitchedOn;
    optional(1) Mode mode;
    optional(2) Brightness brightness;
    optional(3) RGB rgb;
  };

  interface Bulb
  {
    bool switchLight();
    idempotent BulbStatus getStatus();
  };

  interface SmartBulb extends Bulb
  {
    idempotent void setMode(Mode mode);
    idempotent void setBrightness(Brightness brightness) throws BulbCannotSetBrightnessInAutoMode;
  };

  interface SmartRGBBulb extends SmartBulb
  {
    idempotent void setRGB(RGB rgb) throws BulbRGBValuesExceeded;
  };

  // Bulbulator
  exception BulbulatorIsJammed {};

  interface Bulbulator
  {
    string bulbul() throws BulbulatorIsJammed;
  };

};

#endif
