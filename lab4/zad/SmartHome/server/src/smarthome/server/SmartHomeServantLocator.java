package smarthome.server;

import SmartHome.*;
import com.zeroc.Ice.*;

import java.util.HashMap;
import java.util.Map;

public class SmartHomeServantLocator implements ServantLocator {
    private final Map<String, com.zeroc.Ice.Object> servants = new HashMap<>();

    synchronized public ServantLocator.LocateResult locate(Current c) {
        ServantLocator.LocateResult r = new ServantLocator.LocateResult();

        // Check if we have instantiated a servant already.
        com.zeroc.Ice.Object servant = c.adapter.find(c.id);

        if (servant == null) {
            String name = c.id.name;

            switch (name) {
                case "refrigerator1" -> {
                    servant = new RefrigeratorI(
                            new RefrigeratorParams(2, 10),
                            new RefrigeratorSettings(6)
                    );
                    // Add the servant to the ASM.
                    c.adapter.add(servant, new Identity(name, "refrigerator"));
                }
                case "refrigerator2" -> {
                    servant = new RefrigeratorI(
                            new RefrigeratorParams(1, 11),
                            new RefrigeratorSettings(7)
                    );
                    c.adapter.add(servant, new Identity(name, "refrigerator"));
                }
                case "freezerRefrigerator1" -> {
                    servant = new FreezerRefrigeratorI(
                            new RefrigeratorParams(1, 11, -10, -2),
                            new RefrigeratorSettings(5, -5)
                    );
                    c.adapter.add(servant, new Identity(name, "freezerRefrigerator"));
                }
                case "freezerRefrigerator2" -> {
                    servant = new FreezerRefrigeratorI(
                            new RefrigeratorParams(3, 9, -20, -4),
                            new RefrigeratorSettings(4, -12)
                    );
                    c.adapter.add(servant, new Identity(name, "freezerRefrigerator"));
                }
                case "bulb1", "bulb2" -> {
                    servant = new BulbI();
                    c.adapter.add(servant, new Identity(name, "bulb"));
                }
                case "smartBulb1" -> {
                    servant = new SmartBulbI(Mode.Auto, Brightness.Medium);
                    c.adapter.add(servant, new Identity(name, "smartBulb"));
                }
                case "smartBulb2" -> {
                    servant = new SmartBulbI(Mode.Manual, Brightness.High);
                    c.adapter.add(servant, new Identity(name, "smartBulb"));
                }
                case "smartRGBBulb1" -> {
                    servant = new SmartRGBBulbI(Mode.Auto, Brightness.Medium, new RGB((short) 255, (short) 255, (short) 255));
                    c.adapter.add(servant, new Identity(name, "smartRGBBulb"));
                }
                case "smartRGBBulb2" -> {
                    servant = new SmartRGBBulbI(Mode.Manual, Brightness.High, new RGB((short) 255, (short) 255, (short) 255));
                    c.adapter.add(servant, new Identity(name, "smartRGBBulb"));
                }
                case "bulbulator1", "bulbulator2", "bulbulator3" -> {
                    servant = new BulbulatorI();
                    c.adapter.add(servant, new Identity(name, "bulbulator"));
                }
            }
        }

        servants.put(c.id.name, servant);
        printServants();

        r.returnValue = servant;
        return r;
    }

    public void finished(Current current, com.zeroc.Ice.Object servant, java.lang.Object cookie) {
    }

    public void deactivate(String category) {
    }

    public void printServants() {
        System.out.println("List of servants = [");
        for (Map.Entry<String, com.zeroc.Ice.Object> servant : servants.entrySet()) {
            System.out.println("  " + servant.getKey() + ": " + servant.getValue() + ",");
        }
        System.out.println("]");
    }


}
