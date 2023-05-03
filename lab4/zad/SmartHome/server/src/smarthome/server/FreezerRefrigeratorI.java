package smarthome.server;

import SmartHome.*;
import com.zeroc.Ice.Current;

import java.util.Random;

public class FreezerRefrigeratorI extends RefrigeratorI implements FreezerRefrigerator {


    public FreezerRefrigeratorI(RefrigeratorParams params, RefrigeratorSettings settings) {
        super(params, settings);
    }

    @Override
    public void readSensors() {
        Thread sensorsReader = new Thread(() -> {
            try {
                while (getIsTurnedOn()) {
                    Random random = new Random();
                    System.out.println(getSensors());
                    RefrigeratorSensors s =  new RefrigeratorSensors(
                            System.currentTimeMillis(),
                            getSettings().refrigeratorTargetTemperature - 1 + 2 * random.nextFloat(),
                            getSettings().getFreezerTargetTemperature() - 1 + 2 * random.nextFloat()
                    );
                    getSensors().add(s);
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        sensorsReader.start();
    }

    @Override
    public void setFreezerTargetTemperature(float tmp, Current current) throws FreezerTargetTemperatureOutOffRange, RefrigeratorIsSwitchedOff {
        boolean isTurnedOn = getIsTurnedOn();
        RefrigeratorParams params = getParams();
        RefrigeratorSettings settings = getSettings();

        if (!isTurnedOn) {
            throw new RefrigeratorIsSwitchedOff();
        }
        if (tmp > params.getMaxFreezerTemperature() || tmp < params.getMinFreezerTemperature()) {
            throw new FreezerTargetTemperatureOutOffRange();
        }
        System.out.println("[" + current.id.name + "] Set freezer target temperature to " + tmp);
        settings.setFreezerTargetTemperature(tmp);
    }
}
