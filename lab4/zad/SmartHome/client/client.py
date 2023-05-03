import sys
import Ice

Ice.loadSlice('../server/slice/smart_home.ice')
import SmartHome


def print_object(obj, keys: list[str]):
    print("{")
    for key in keys:
        string = f"{getattr(obj, key)}".replace("\n", "\n    ")
        print(f"    {key}: {string}")
    print("}")


def main():
    available_devices = {
        "refrigerator1": ("refrigerator", "Refrigerator1.Proxy"),
        "refrigerator2": ("refrigerator", "Refrigerator2.Proxy"),
        "freezerRefrigerator1": ("freezerRefrigerator", "FreezerRefrigerator1.Proxy"),
        "freezerRefrigerator2": ("freezerRefrigerator", "FreezerRefrigerator2.Proxy"),
        "bulb1": ("bulb", "Bulb1.Proxy"),
        "bulb2": ("bulb", "Bulb2.Proxy"),
        "smartBulb1": ("smartBulb", "SmartBulb1.Proxy"),
        "smartBulb2": ("smartBulb", "SmartBulb2.Proxy"),
        "smartRGBBulb1": ("smartRGBBulb", "SmartRGBBulb1.Proxy"),
        "smartRGBBulb2": ("smartRGBBulb", "SmartRGBBulb2.Proxy"),
        "bulbulator1": ("bulbulator", "Bulbulator1.Proxy"),
        "bulbulator2": ("bulbulator", "Bulbulator2.Proxy"),
        "bulbulator3": ("bulbulator", "Bulbulator3.Proxy"),
    }

    connected_devices = {}

    with Ice.initialize(['--Ice.Config=config.client'] + sys.argv) as communicator:
        selected_device = None

        while True:
            try:
                user_input = input(f"{selected_device if selected_device else ''}# ")
            except KeyboardInterrupt:
                break

            if user_input == "exit":
                if selected_device:
                    selected_device = None
                    continue
                else:
                    break

            if selected_device:
                device_type, _ = available_devices[selected_device]
                device = connected_devices[selected_device]
                try:
                    if device_type in ("refrigerator", "freezerRefrigerator"):
                        match user_input:
                            case "power on":
                                device.powerOn()
                                print(f"[{selected_device}] Refrigerator turned on")
                                continue

                            case "power off":
                                device.powerOff()
                                print(f"[{selected_device}] Refrigerator turned off")
                                continue

                            case "get params":
                                r = device.getParams()
                                print(f"[{selected_device}] Params:")
                                if device_type == "refrigerator":
                                    print_object(r, ["minRefrigeratorTemperature", "maxRefrigeratorTemperature"])
                                elif device_type == "freezerRefrigerator":
                                    print_object(r, ["minRefrigeratorTemperature", "maxRefrigeratorTemperature",
                                                     "minFreezerTemperature", "maxFreezerTemperature"])
                                continue

                            case "get settings":
                                r = device.getSettings()
                                print(f"[{selected_device}] Settings:")
                                if device_type == "refrigerator":
                                    print_object(r, ["refrigeratorTargetTemperature"])
                                elif device_type == "freezerRefrigerator":
                                    print_object(r, ["refrigeratorTargetTemperature", "freezerTargetTemperature"])
                                continue

                            case "get sensors":
                                r = device.getSensorValues()
                                print(f"[{selected_device}] Sensors:")
                                if device_type == "refrigerator":
                                    for s in r:
                                        print_object(s, ["timestamp", "refrigeratorTemperature"])
                                elif device_type == "freezerRefrigerator":
                                    for s in r:
                                        print_object(s, ["timestamp", "refrigeratorTemperature", "freezerTemperature"])
                                continue

                            case "set refrigerator temperature":
                                try:
                                    tmp = float(input("Refrigerator target temperature: "))
                                    device.setRefrigeratorTargetTemperature(tmp)
                                except ValueError as e:
                                    print(e)
                                continue

                    if device_type == "freezerRefrigerator":
                        match user_input:
                            case "set freezer temperature":
                                try:
                                    tmp = float(input("Freezer target temperature: "))
                                    device.setFreezerTargetTemperature(tmp)
                                except ValueError as e:
                                    print(e)
                                continue

                except SmartHome.RefrigeratorIsAlreadyOn:
                    print(f"[{selected_device}] Refrigerator is already on")
                    continue
                except SmartHome.RefrigeratorIsSwitchedOff:
                    print(f"[{selected_device}] Refrigerator is switched off")
                    continue
                except SmartHome.RefrigeratorTargetTemperatureOutOffRange:
                    print(f"[{selected_device}] Refrigerator target temperature out off range")
                    continue
                except SmartHome.FreezerTargetTemperatureOutOffRange:
                    print(f"[{selected_device}] Freezer target temperature out off range")
                    continue

                try:
                    if device_type in ("bulb", "smartBulb", "smartRGBBulb"):
                        match user_input:
                            case "switch":
                                r = device.switchLight()
                                if r:
                                    print(f"[{selected_device}] Light on")
                                else:
                                    print(f"[{selected_device}] Light off")
                                continue

                            case "get status":
                                r = device.getStatus()
                                print(f"[{selected_device}] Status:")
                                if device_type == "bulb":
                                    print_object(r, ["isSwitchedOn"])
                                elif device_type == "smartBulb":
                                    print_object(r, ["isSwitchedOn", "mode", "brightness"])
                                elif device_type == "smartRGBBulb":
                                    print_object(r, ["isSwitchedOn", "mode", "brightness", "rgb"])
                                continue

                    if device_type in ("smartBulb", "smartRGBBulb"):
                        match user_input:
                            case "set mode auto":
                                device.setMode(SmartHome.Mode.Auto)
                                print(f"[{selected_device}] Mode set to auto")
                                continue
                            case "set mode manual":
                                device.setMode(SmartHome.Mode.Manual)
                                print(f"[{selected_device}] Mode set to manual")
                                continue
                            case "set brightness low":
                                device.setBrightness(SmartHome.Brightness.Low)
                                print(f"[{selected_device}] Brightness set to low")
                                continue
                            case "set brightness medium":
                                device.setBrightness(SmartHome.Brightness.Medium)
                                print(f"[{selected_device}] Brightness set to medium")
                                continue
                            case "set brightness high":
                                device.setBrightness(SmartHome.Brightness.High)
                                print(f"[{selected_device}] Brightness set to high")
                                continue

                    if device_type == "smartRGBBulb":
                        match user_input:
                            case "set rgb":
                                try:
                                    r = int(input("R: "))
                                    g = int(input("G: "))
                                    b = int(input("B: "))
                                    rgb = SmartHome.RGB(r, g, b)
                                    device.setRGB(rgb)
                                    print(f"[{selected_device}] RGB set to (R = {r}, G = {g}, B = {b})")
                                except ValueError as e:
                                    print(e)
                                continue

                except SmartHome.BulbCannotSetBrightnessInAutoMode:
                    print(f"[{selected_device}] Cannot set brightness in Auto mode")
                    continue
                except SmartHome.BulbRGBValuesExceeded:
                    print(f"[{selected_device}] RGB values exceeded")
                    continue

                try:
                    if device_type == "bulbulator":
                        match user_input:
                            case "bulbul":
                                r = device.bulbul()
                                print(f"[{selected_device}] {r}")
                                continue

                except SmartHome.BulbulatorIsJammed:
                    print(f"[{selected_device}] Bulbulator is jammed")
                    continue

                print(f"Unknown {device_type} command: {user_input}")
                continue

            if user_input in available_devices:
                device = user_input
                if device not in connected_devices:
                    print(f"Connecting device [{device}]...")
                    device_type, proxy = available_devices[device]
                    base = communicator.propertyToProxy(proxy)

                    match device_type:
                        case "refrigerator":
                            refrigerator = SmartHome.RefrigeratorPrx.checkedCast(base)
                            if not refrigerator:
                                raise RuntimeError('Invalid proxy')
                            connected_devices[device] = refrigerator

                        case "freezerRefrigerator":
                            freezer_refrigerator = SmartHome.FreezerRefrigeratorPrx.checkedCast(base)
                            if not freezer_refrigerator:
                                raise RuntimeError('Invalid proxy')
                            connected_devices[device] = freezer_refrigerator

                        case "bulb":
                            bulb = SmartHome.BulbPrx.checkedCast(base)
                            if not bulb:
                                raise RuntimeError('Invalid proxy')
                            connected_devices[device] = bulb

                        case "smartBulb":
                            smart_bulb = SmartHome.SmartBulbPrx.checkedCast(base)
                            if not smart_bulb:
                                raise RuntimeError('Invalid proxy')
                            connected_devices[device] = smart_bulb

                        case "smartRGBBulb":
                            smart_rgb_bulb = SmartHome.SmartRGBBulbPrx.checkedCast(base)
                            if not smart_rgb_bulb:
                                raise RuntimeError('Invalid proxy')
                            connected_devices[device] = smart_rgb_bulb

                        case "bulbulator":
                            bulbulator = SmartHome.BulbulatorPrx.checkedCast(base)
                            if not bulbulator:
                                raise RuntimeError('Invalid proxy')
                            connected_devices[device] = bulbulator

                selected_device = device

            else:
                print(f"Unknown device: {user_input}")


if __name__ == '__main__':
    main()
