package smarthome.server;

import SmartHome.*;
import com.zeroc.Ice.Current;

import java.util.Random;

public class SmartRGBBulbI extends SmartBulbI implements SmartRGBBulb {

    public SmartRGBBulbI(Mode mode, Brightness brightness, RGB rgb) {
        super(mode, brightness);
        BulbStatus status = getStatus();
        status.setRgb(rgb);
    }

    private boolean exceedsRGBValue(short value) {
        return value < 0 || value > 255;
    }

    @Override
    public void setRGB(RGB rgb, Current current) throws BulbRGBValuesExceeded {
        BulbStatus status = getStatus();
        if (exceedsRGBValue(rgb.R) || exceedsRGBValue(rgb.G) || exceedsRGBValue(rgb.B)) {
            throw new BulbRGBValuesExceeded();
        }
        System.out.println("[" + current.id.name + "] Set RGB to " + rgb);
        status.setRgb(rgb);
    }
}
