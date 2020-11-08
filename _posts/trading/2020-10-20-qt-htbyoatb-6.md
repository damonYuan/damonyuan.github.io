---
title:  "手动拆解《Quantitative Trading - How to Build Your Own Algorithmic Trading Business》（六）"
description: "手动拆解《Quantitative Trading - How to Build Your Own Algorithmic Trading Business》（六）"
date: 2020-10-20 15:04:23
hidden: true
categories: [Trading]
tags: [backtrader, quantitative, trading]
---

来到第六章，照例放上思维导图吧。

![第六章]({{site.url}}/images/2020-10-01-qt-htbyoatb-6/c6.png "第六章")

凯利公式

我们投资的目的是最大化长期回报，这意味着归零或者更甚的损失是必须避免的。

covariance matrix

http://www.eecs.harvard.edu/cs286r/courses/fall12/papers/Thorpe_KellyCriterion2007.pdf

f = W - (1 - W) / R

f = m / s^2

assume that the return distribution of a strategy (or security) is Gaussian

https://www.quantstart.com/articles/Money-Management-via-the-Kelly-Criterion/

 “half-Kelly” betting.
 
 long-term compounded growth rate of your equity.
 
 g = r + S^2/2
 
 I would advise using a lookback period of six months.
 
 https://www.investopedia.com/articles/financial-theory/11/calculating-covariance.asp
 
 Dividing the maximum tolera- ble one-period drawdown on equity by the maximum historical loss will tell you whether even half-Kelly leverage is too large for your comfort. 
 
 * backtrader init orders
 * backtrader with kelly's formula
 
 [如何通俗易懂地解释「协方差」与「相关系数」的概念](https://www.zhihu.com/question/20852004)
 
 线性回归和协方差的关系 - 没有关系。