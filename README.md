# 后端开发知识点简单实战
## 项目结构
```
simple_practice
----`common`: 常用工具
----`csbase`: cs基础: 数据结构与算法等
----`jbase`: java基础: 一些简单练习
----`jvm`: jvm学习
----`netty`: IO编程
----`partterns`:设计模式
----`paxos`:paxos实例实现
```

## 设计模式
> `xyz.banjuer.parttern`

我想说的:
* 以前设计模式学了一次又一次，总是不得精髓学完就忘。而这次学习却是非常的顺利，那么原因就是因为: **代码量**。
当有足够的代码量后，足够的经验积累，设计模式会让你豁然开朗，，并没有那么难，相反它是以尽可能简单的方式(增加代码复用度,面向对象编程特性)解决问题。

### 实现
* 适配器模式: `xyz.banjuer.parttern.adapter`
* 创建者模式: `xyz.banjuer.parttern.builder`
* 命令模式: `xyz.banjuer.parttern.command`
* 装饰器模式: `xyz.banjuer.parttern.decorator`
* 外观模式: `xyz.banjuer.parttern.facade`
* 工厂模式: `xyz.banjuer.parttern.factory`
* 迭代器模式: `xyz.banjuer.parttern.iterator`
* 观察者模式: `xyz.banjuer.parttern.observer`
* 单例模式: `xyz.banjuer.parttern.singleton`
* 状态模式: `xyz.banjuer.parttern.state`
* 策略模式: `xyz.banjuer.parttern.strategy`
* 模版模式: `xyz.banjuer.parttern.template`

## 算法

### 基础算法
**排序**
> `xyz.banjuer.common.utils.SortUtils`
* 归并排序(递归: 自顶向下)
* 归并排序(遍历: 自底向上)
* 三路快排

**查找**

### leetcode
**双指针与循环不变量练习**
> `xyz.banjuer.csbase.leetcode`
* 26 删除排序数组中的重复项
* 27 移除元素
* 80 删除排序数组中的重复项 II
* 283 移动零
**排序衍生**
* 75 颜色分类(快排partition||计数)
* 88 合并两个有序数组(归并排序合并有序数组)
* 215 数组中的第K个最大元素(快排partition)

### Paxos算法实现
> 基于springboot作为服务实例, http作为RPC调用, sqlite3数据持久化。
* 每一个启动的应用实例既是一个**Proposer**同时又承担了**Acceptor**角色
* `application.yml`中定义`acceptor`实例地址
* 关于**Paxos**原理详解,[参考](https://github.com/turingcell/paxos-made-easy)

## 网络编程与Netty
TODO