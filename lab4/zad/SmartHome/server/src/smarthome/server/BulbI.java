package smarthome.server;

import SmartHome.Bulb;
import SmartHome.BulbStatus;
import SmartHome.RefrigeratorParams;
import com.zeroc.Ice.Current;

public class BulbI implements Bulb {

    private final BulbStatus status;

    public BulbI() {
        status = new BulbStatus(false);
    }

    public BulbStatus getStatus() {
        return status;
    }

    @Override
    public boolean switchLight(Current current) {
        status.isSwitchedOn = !status.isSwitchedOn;
        System.out.println("[" + current.id.name + "] Switch light");
        return status.isSwitchedOn;
    }

    @Override
    public BulbStatus getStatus(Current current) {
        System.out.println("[" + current.id.name + "] Get status");
        return status;
    }
}
