package xyz.banjuer.parttern.strategy;

import xyz.banjuer.parttern.singleton.SingleConfig;

/**
 * 策略模式: 把对象行为封装成对象，不同行为对象任意组合成新对象
 */
public interface IConfig {

    SingleConfig getInstance();

}
