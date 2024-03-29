# 后端开发知识点简单实战

* [后端开发知识点简单实战](#后端开发知识点简单实战)
  * [项目结构](#项目结构)
  * [实践](#实践)
    * [Paxos算法简单实现](#paxos算法简单实现)
    * [计算π](#计算π)
  * [设计模式](#设计模式)
    * [实现](#实现)
  * [算法](#算法)
    * [基础算法](#基础算法)
    * [leetcode](#leetcode)
      * [线性结构-数组](#线性结构-数组)
    * [剑指offer](#剑指offer)
    * [<a href="https://codetop.cc/home" rel="nofollow">高频题</a>](#高频题)
  * [网络编程与Netty](#网络编程与netty)


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

## 实践

### Paxos算法简单实现
> 基于springboot作为服务实例, http作为RPC调用, sqlite3数据持久化。
* 每一个启动的应用实例既是一个**Proposer**同时又承担了**Acceptor**角色
* `application.yml`中定义`acceptor`实例地址
* 关于**Paxos**原理详解,[参考](https://github.com/turingcell/paxos-made-easy)

### 计算π
>`xyz.banjuer.csbase.interview.GetPI`

**原理:蒙特卡洛简单实现**

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

### 我的leetcode进度
[![4GOBes.png](https://z3.ax1x.com/2021/09/20/4GOBes.png)](https://imgtu.com/i/4GOBes)

### 基础算法
**排序**

> `xyz.banjuer.common.utils.SortUtils`
* 归并排序(递归: 自顶向下)
* 归并排序(遍历: 自底向上)
* 三路快排

**查找**

### leetcode

#### 线性结构-数组
> `xyz.banjuer.csbase.array.leetcode`

**双指针练习**
* 对撞指针`SolutionCollisionPointers`
    * 11 盛最多水的容器
    * 125 验证回文串
    * 167 两数之和 II - 输入有序数组
    * 344 反转字符串
    * 345 反转字符串中的元音字母
* 滑动窗口 `SolutionSlidingWindow`
    * 76 最小覆盖子串 **TODO**
    * 209 长度最小的子数组

**循环不变量练习**`SolutionSinglePointer`
* 26 删除排序数组中的重复项
* 27 移除元素
* 80 删除排序数组中的重复项 II
* 283 移动零

**排序衍生**
* 75 颜色分类(快排partition||计数)
* 88 合并两个有序数组(归并排序合并有序数组)
* 215 数组中的第K个最大元素(快排partition)

**查找表**
* 451 根据字符出现频率排序
* 205 同构字符串
* 290 单词规律
* 202 快乐数
* 242 有效的字母异位词
* 349 两个数组的交集
* 350 两个数组的交集 II

### 剑指offer
>`xyz.banjuer.csbase.offer`

### [高频题](https://codetop.cc/home)
感谢[@LeetcodeTop](https://github.com/afatcoder/LeetcodeTop)
> `xyz.banjuer.csbase.interview.top`



## 网络编程与Netty
TODO
