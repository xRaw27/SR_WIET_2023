package smarthome.server;

import SmartHome.*;
import com.zeroc.Ice.Current;

import java.util.Random;

public class BulbulatorI implements Bulbulator {
    @Override
    public String bulbul(Current current) throws BulbulatorIsJammed {
        Random random = new Random();
        int n = random.nextInt(4);
        if (n == 0) {
            System.out.println("[" + current.id.name + "] Bul... ^&^*&$#");
            throw new BulbulatorIsJammed();
        }
        String res = "Bul" + " bul".repeat(n - 1);
        System.out.println("[" + current.id.name + "] " + res);
        return res;
    }
}
