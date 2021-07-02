---
title:  "Skill Tree of Quant"
description: "The skill tree of Quant"
hidden: true
date: 2019-04-08 15:04:23
categories: [Tech, Mindmap]
tags: [Quant]
---

# 基础知识

## Python 和相关库

### TA-Lib

```
ta.get_functions()
ta.get_function_groups()
```

#### Overlap Studies(重叠指标)

##### MA 移动平均线

```
ta.MA(close,timeperiod=30,matype=0)

```

* SMA 简单移动平均线
* EMA 指数移动平均线
* WMA 加权移动平均线
* DEMA 双移动平均线
* TEMA 三重指数移动平均线
* TRIMA 三角移动平均线
* KAMA 考夫曼自适应移动平均线
* MAMA MESA自适应移动平均线
* T3 三重指数移动平均线

#### Momentum Indicators(动量指标)

#### Volume Indicators(交易量指标)

#### Cycle Indicators(周期指标)

#### Price Transform(价格变换)

#### Volatility Indicators(波动率指标)

#### Pattern Recognition(模式识别)

#### Statistic Functions(统计函数)

#### Math Transform(数学变换)

#### Math Operators(数学运算)

## 金融知识

## 技术指标

### 常用

#### 均线型

* EMA10: 10日移动指数平均
* MA120: 120日的移动平均
* BBI: 多空指数
* TEMA10: 10日三重指数移动平均线

#### 超买超卖

* 布林带: 下穿布林线上边界做空，上穿布林线下边界做多
* KDJ: 随机指数
* RVI: 相对离散指数
* DBCD: 异同离差乖离率

#### 能量型

* CR
* Mass Index: 梅斯线
* Elder: 艾达透视指标

#### 趋势型

* ASI: 累计振动升降指标
* EMV: 简易波动指标
* MACD: 平滑异同异动平均线
* SwingIndex: 振动升降指标

### 动量类

* ARC: 变化率指数均值
* APBMA: 绝对偏差移动平均
* CCI10: 10日顺势指标
* REVS5M20: 5日动量和20日动量的差

### 情绪类

* AR: 人气指标
* BR: 意愿指标

  TODO

* Psy: 心理线指标
* JDQS: 阶段强势指标

### 收益风险类

* Variance: 收益方差
* Kurtosis: 个股收益峰度
* Alpha20: 20日 alpha 值
* Beta20: 20日 beta 值

## 量化交易框架

### Platform

* Big Quant
* 优矿
* 米筐

### Open Source

* vnpy
* easyquant

# 量化策略开发

## 模型

### 策略研发

* 进出场规则
* 风险控制规则
* 资金管理规则
* 流程

  * 制定交易策略
  * 编写交易模型
  * 历史数据回测
  * 模拟交易
  * 修正模型
  * 实战应用

### 风险控制模型

* 常用判断指标

  * 交易次数
  * 胜率
  * 盈亏比
  * 夏普率
  * 回撤
  * 其他

* 同时不可能同时满足

  * 收益高
  * 风险低
  * 频率高  
  * 其他

### 交易成本模型

* 人力成本
* 手续费
* 滑点
* 故障

### 投资组合构建模型

* 监控策略、行情
* 观察

  * 策略运行与市场特征匹配情况
  * 策略调度、资金配比变化
  * 风险测试、头寸规模控制
  * 策略进化、升级与淘汰

### 执行模型

## 策略

### 【A股】ARBR

# 大数据与人工智能
