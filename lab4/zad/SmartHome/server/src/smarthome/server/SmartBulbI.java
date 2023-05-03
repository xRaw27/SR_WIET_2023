package smarthome.server;

import SmartHome.*;
import com.zeroc.Ice.Current;

import java.util.Random;

public class SmartBulbI extends BulbI implements SmartBulb {

    public SmartBulbI(Mode mode, Brightness brightness) {
        super();
        BulbStatus status = getStatus();
        status.setMode(mode);
        status.setBrightness(brightness);
    }

    @Override
    public void setMode(Mode mode, Current current) {
        BulbStatus status = getStatus();
        System.out.println("[" + current.id.name + "] Set mode to " + mode);
        status.setMode(mode);
    }

    @Override
    public void setBrightness(Brightness brightness, Current current) throws BulbCannotSetBrightnessInAutoMode {
        BulbStatus status = getStatus();
        if (status.getMode() == Mode.Auto) {
            throw new BulbCannotSetBrightnessInAutoMode();
        }
        System.out.println("[" + current.id.name + "] Set brightness to " + brightness);
        status.setBrightness(brightness);
    }

    @Override
    public BulbStatus getStatus(Current current) {
        System.out.println("[" + current.id.name + "] Get status");
        BulbStatus status = getStatus();
        if (status.getMode() == Mode.Auto) {
            Random random = new Random();
            Brightness newBrightness = Brightness.values()[random.nextInt(Brightness.values().length)];
            status.setBrightness(newBrightness);
        }
        return status;
    }

}
