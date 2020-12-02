package xyz.banjuer.parttern.strategy;

import xyz.banjuer.parttern.singleton.SingleConfig;

public class ConfigHunger implements IConfig {
    @Override
    public SingleConfig getInstance() {
        return SingleConfig.getInstanceHunger();
    }
}
