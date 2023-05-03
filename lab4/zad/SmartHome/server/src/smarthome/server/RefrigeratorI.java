package smarthome.server;

import SmartHome.*;
import com.zeroc.Ice.Current;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RefrigeratorI implements Refrigerator {
    private boolean isTurnedOn = false;
    private final RefrigeratorParams params;
    private final RefrigeratorSettings settings;
    private final List<RefrigeratorSensors> sensors;

    public RefrigeratorI(RefrigeratorParams params, RefrigeratorSettings settings) {
        this.params = params;
        this.settings = settings;
        this.sensors = Collections.synchronizedList(new LinkedList<>());
    }

    public boolean getIsTurnedOn() {
        return isTurnedOn;
    }

    public RefrigeratorParams getParams() {
        return params;
    }

    public RefrigeratorSettings getSettings() {
        return settings;
    }

    public List<RefrigeratorSensors> getSensors() {
        return sensors;
    }

    public void readSensors() {
        Thread sensorsReader = new Thread(() -> {
            try {
                while (isTurnedOn) {
                    Random random = new Random();
                    System.out.println(sensors);
                    RefrigeratorSensors s =  new RefrigeratorSensors(
                            System.currentTimeMillis(),
                            settings.refrigeratorTargetTemperature - 1 + 2 * random.nextFloat()
                    );
                    sensors.add(s);
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        sensorsReader.start();
    }

    @Override
    public void powerOn(Current current) throws RefrigeratorIsAlreadyOn {
        if (isTurnedOn) {
            throw new RefrigeratorIsAlreadyOn();
        }
        System.out.println("[" + current.id.name + "] Power on");
        isTurnedOn = true;
        readSensors();
    }

    @Override
    public void powerOff(Current current) throws RefrigeratorIsSwitchedOff {
        if (!isTurnedOn) {
            throw new RefrigeratorIsSwitchedOff();
        }
        System.out.println("[" + current.id.name + "] Power off");
        isTurnedOn = false;
        sensors.clear();
    }

    @Override
    public RefrigeratorParams getParams(Current current) {
        System.out.println("[" + current.id.name + "] Get params");
        return params;
    }

    @Override
    public RefrigeratorSettings getSettings(Current current) {
        System.out.println("[" + current.id.name + "] Get settings");
        return settings;
    }

    @Override
    public RefrigeratorSensors[] getSensorValues(Current current) throws RefrigeratorIsSwitchedOff {
        if (!isTurnedOn) {
            throw new RefrigeratorIsSwitchedOff();
        }
        System.out.println("[" + current.id.name + "] Get sensor values");
        return sensors.toArray(new RefrigeratorSensors[0]);
    }

    @Override
    public void setRefrigeratorTargetTemperature(float tmp, Current current) throws RefrigeratorTargetTemperatureOutOffRange, RefrigeratorIsSwitchedOff {
        if (!isTurnedOn) {
            throw new RefrigeratorIsSwitchedOff();
        }
        if (tmp > params.maxRefrigeratorTemperature || tmp < params.minRefrigeratorTemperature) {
            throw new RefrigeratorTargetTemperatureOutOffRange();
        }
        System.out.println("[" + current.id.name + "] Set refrigerator target temperature to " + tmp);
        settings.refrigeratorTargetTemperature = tmp;
    }
}

