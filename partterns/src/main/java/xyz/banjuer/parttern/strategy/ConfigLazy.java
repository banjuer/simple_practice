package xyz.banjuer.parttern.strategy;

import xyz.banjuer.parttern.singleton.SingleConfig;

public class ConfigLazy implements IConfig {
    @Override
    public SingleConfig getInstance() {
        return SingleConfig.getInstanceLazy();
    }
}
