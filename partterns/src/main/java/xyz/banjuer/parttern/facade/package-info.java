/**
 * 外观模式: 对客户端提供单一接口。内部封装一系列子动作
 * 例: web服务停机
 * 对外暴露唯一接口:shutdown
 * 内部封装子服务:
 * 1. 拒绝新服务
 * 2. 停止后台线程
 * 2. 释放资源
 * 3. 停机
 */
package xyz.banjuer.parttern.facade;