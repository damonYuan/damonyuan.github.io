---
title:  "Quantitative Trading"
description: "Quantitative Trading"
hidden: true
date: 2019-07-13 15:04:23
categories: [Tech]
tags: [Quantitative, Trading]
---

# Chapter 1

1. time schedule

   * The largest block of time I need to spend is in the morning before the market opens
   
     - run various programs to download and process the latest historical data
     - read company news that comes up on my alert screen
     - run programs to generate the orders for the day
     - launch a few baskets of orders before the market opens 
     - start a program that will launch orders automatically throughout the day
     - update my spreadsheet to record the previous day’s profit and loss (P&L) of the different strategies I run based on the brokerages’ statements
     
   * spend another half hour near the market close
   
     - direct the programs to exit various positions
     - manually checking that those exit orders are correctly transmitted
     - closing down vari- ous automated programs properly
     
2. questions

   * How do you find the right strategy to trade?
   * How do you recognize a good versus a bad strategy even before devoting any time to backtesting them?
   * How do you rigorously backtest them
   * If the backtest performance is good, what steps do you need to take to implement the strategy, in terms of both the business structure and the technological infrastructure
   * If the strategy is profitable in initial real-life trading, how does one scale up the capital to make it into a growing income stream while manag- ing the inevitable (but, hopefully, only occasional) losses that come with trading?
   
3. In reality, maximum long-term growth is achieved by finding a strategy with the maxi- mum Sharpe ratio (defined in the next section), provided that you have access to sufficiently high leverage. 

# Chapter 2. Fishing Ideas

1. Information Ratio 

Information Ratio = Average of Excess Returns / Standard Deviation of Excess Returns

where

Excess Returns = Portfolio Returns − Benchmark Returns

2. It is the leveraged return that matters in the end, not the nominal return of a trading strategy.

3. As a rule of thumb, any strategy that has a Sharpe ratio of less than 1 is not suitable as a stand-alone strategy. For a strategy that achieves profitability almost every month, its (annualized) Sharpe ratio is typically greater than 2. For a strategy that is profitable al- most every day, its Sharpe ratio is usually greater than 3. 

4. how deep and how long a drawdown will you be able to tolerate and not liquidate your port- folio and shut down your strategy

5. The ones that work for me are usually characterized by these properties:

   - They are based on a sound econometric or rational basis, and not on random discovery of patterns.
   - They have few parameters that need to be fitted to past data.
   - They involve linear regression only, and not fitting to some esoteric nonlinear functions.
   - They are conceptually simple.
   - All optimizations must occur in a lookback moving window, involving no future unseen data. And the effect of this optimization must be continuously demonstrated using this future, unseen data.
   
6. filter out some unsuitable strategies

   - Does it outperform a benchmark?
   - Does it have a high enough Sharpe ratio?
   - Does it have a small enough drawdown and short enough drawdown duration?
   - Does the backtest suffer from survivorship bias?
   - Does the strategy lose steam in recent years compared to its earlier years?
   - Does the strategy have its own “niche” that protects it from intense competition from large institutional money managers?
   
# Chapter 3. Backtesting

1. split and dividend adjusted

2. Survivorship Bias Free

3. Strategy use High or Low data

4. I would argue that the Sharpe ratio and drawdowns are the two most important.

   * average annualized return 
   
5. Backtesting measurement

   * Sharpe Ratio
   * Maximum Drawdown
   * Maximum Drawdown Duration   
   
6. common backtesting pitfalls to avoid   

   * average annualized return
   
7. Calculation in Python

  - [Use Python to calculate the Sharpe ratio for a portfolio](https://towardsdatascience.com/calculating-sharpe-ratio-with-python-755dcb346805)   

    The Sharpe ratio is the average return earned in excess of the risk-free rate per unit of volatility (in the stock market, volatility represents the risk of an asset).

  - [Pandas DataFrame: A lightweight Intro](https://towardsdatascience.com/pandas-dataframe-a-lightweight-intro-680e3a212b96) 
  
    * a column of the DataFrame will always be of same type.
    
  - [Pandas Series: A Lightweight Intro](https://towardsdatascience.com/pandas-series-a-lightweight-intro-b7963a0d62a2)  
    
  - [图解NumPy，这是理解数组最形象的一份教程了](https://www.jiqizhixin.com/articles/2019-07-12-4)  

  - [pandas and NumPy arrays explained](https://medium.com/@ericvanrees/pandas-series-objects-and-numpy-arrays-15dfe05919d7)
   
8. common backtesting pitfalls to avoid   
   

   
          