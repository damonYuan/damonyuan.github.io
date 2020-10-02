---
title:  "手动拆解《Quantitative Trading - How to Build Your Own Algorithmic Trading Business》（三）"
description: "手动拆解《Quantitative Trading - How to Build Your Own Algorithmic Trading Business》（三）"
date: 2020-09-29 15:04:23
hidden: true
categories: [Trading]
tags: [backtrader, quantitative, trading]
---

> * Author: [Damon Yuan](https://www.damonyuan.com)
> * Date: 2020-09-29

![第三章]({{site.url}}/images/2020-09-28-qt-htbyoatb-3/c3.png "第三章")

第三章的基本结构如上。

## 第一部分

主要讲回测工具与平台，

- Excel 基本的吧，
- Matlab 及其变种，
- TradeStation，贵，
- 其他高大上平台，更贵，

不能说作者用的工具都过时了，因为我不了解所以可能行业内还是很多人用 Excel 做回测吧？这里我主要用 backtrader 进行回测实现，所以这些平台有兴趣的人自己研究吧。

## 第二部分

主要讲数据源。

首先关于数据质量有几个重点关注对象，

- 数据是否复权，前复权还是后复权
- 数据是否存在幸存者偏差
- 策略是否使用最高或者最低价格

这里我们会用三个免费数据源：Tushare, 富途牛牛 和 Quandl。

### [Tushare](https://github.com/waditu/tushare)

主要用于获取国内各种数据。

注意[日线行情](https://tushare.pro/document/2?doc_id=27)是未复权行情。所以请使用[通用行情接口](https://tushare.pro/document/2?doc_id=109)。该接口包含了股票未复权，前复权和后复权数据。

TuShare 数据是有幸存者偏差的，[也就是说它返回的数值只包含没有退市的股票](https://github.com/waditu/tushare/issues/244)，需要手动获取停牌股票信心并处理数据。另外一个简单的处理方案是尽量使用最近的数据进行回测这样回测结果比较不会失真。

最后， TuShare 数据包含了最高或者最低价格。

总而言之，Tushare 数据的调用比较简单，但是从 GitHub 上的 [issues](https://github.com/waditu/tushare/issues) 数量上来看，数据质量并不是那么好。

在 backtrader 中， 我们可以将其包装在一个类中，直接返回 backtrader 可用的数据。

```
class TushareDataFrame:
    def __init__(self, code, start, end):
        self.code = code
        self.start = start
        self.end = end

    def get_data(self):
        df = ts.pro_bar(ts_code=self.code, 
                        adj='qfq', 
                        start_date=self.start, 
                        end_date=self.end)
        df['date'] = df['trade_date']
        df['volume'] = df['vol']
        df.index = pd.to_datetime(df['date'])
        df['openinterest'] = 0
        df = df[['open', 'high', 'low', 'close', 'volume', 'openinterest']]
        return df

# 在 backtrader 主函数中调用
df = TushareDataFrame(code='600000.SH', 
                       start='20100331', 
                       end='20200331').get_data()
data = btfeeds.PandasData(dataname=df.sort_index(), 
                                         fromdate=pd.to_datetime(self.start), 
                                         todate=pd.to_datetime(self.end))
cerebro.adddata(data) 
```

### [富途牛牛](https://github.com/FutunnOpen/py-futu-api)

这是一家券商做的开放式接口，数据质量应该是比较有保证的。该接口不仅含有低频数据接口，同时还有高频数据接口，跟可直接连接交易系统下单。