package booking.framework.enviroment;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:global.properties"
})
public interface Enviroment extends Config {
    @Key("execute.saucelabs")
    boolean executeSaucelabs();

    @Key("local.device.default")
    String localDeviceDefault();

    @Key("cloud.device.defaul")
    String cloudDeviceDefaul();
}