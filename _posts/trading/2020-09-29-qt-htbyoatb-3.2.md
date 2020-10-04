---
title:  "手动拆解《Quantitative Trading - How to Build Your Own Algorithmic Trading Business》（三）(上)"
description: "手动拆解《Quantitative Trading - How to Build Your Own Algorithmic Trading Business》（三）（上）"
date: 2020-09-29 15:04:23
hidden: true
categories: [Trading]
tags: [backtrader, quantitative, trading]
---

> * Author: [Damon Yuan](https://www.damonyuan.com)
> * Date: 2020-09-29

![第三章]({{site.url}}/images/2020-09-28-qt-htbyoatb-3.1/c3.png "第三章")

第三章的基本结构如上。

这部分内容较多，分为上下两个部分。该部分为下。

### GLD 和 GDX 交易实验

GLD 是金价指数，GDX 是一篮子采金公司的指数。直觉上这两个指数应该是起头并进的，然而事实上这两只指数是均值回复(mean reverting)的关系。这部分的协整分析（cointegration analysis）会先放一边，在第七章会有详细解释，在这个例子中我们重点在训练样本上用回归测试（regression test）来决定这两个指数的套期保值比率（hedge ratio），然后为这个配对交易策略设置进入和退出门槛。

首先是获取数据和数据清洗。

