package xyz.banjuer.parttern.strategy;

import xyz.banjuer.parttern.singleton.SingleConfig;

public class ConfigLazyUnsafe implements IConfig {
    @Override
    public SingleConfig getInstance() {
        return SingleConfig.getInstanceLazyUnsafe();
    }
}
