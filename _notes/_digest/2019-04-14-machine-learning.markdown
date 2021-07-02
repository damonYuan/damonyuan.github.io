---
title:  "Machine Learning"
description: "Machine Learning"
hidden: true
date: 2019-04-14 15:04:23
categories: [Tech, Mindmap]
tags: [Python, Machine Learning]
---

# Machine Learning in Action

## About this book

### Top 10 algorithms in data mining

Top 10 Algorithms in Data Mining” and appeared in the Journal of Knowledge and Information Systems in December, 2007

- C4.5 (trees)
- k-means 
- support vector machines
- Apriori
- Expectation Maximization (Exception, very heavy on the math)
- PageRank (Exception, the algorithm that launched the search engine giant Google)
- AdaBoost, a classifier made up of a collection of classifiers
- k-Nearest Neighbors
- Naïve Bayes 
- CART

not included but important, 

- Logistic Regression
- FP-Growth

### Structure

#### Part 1 Machine learning basics

- classification, the process of labeling items
- k-Nearest Neighbors
- decision trees
- using probability distributions for classification and the Naïve Bayes algorithm
- Logistic Regression, which is not in the Top 10 list, but introduces the subject of optimization algorithms, which are important; how to deal with missing values in data
- Support Vector Machines
- AdaBoost ensemble method; classification imbalance problem that arises when the training examples are not evenly distributed

#### Part 2 Forecasting numeric values with regression

- regression
- shrinkage methods
- locally weighted linear regression
- deals with the bias-variance tradeoff
- tree-based regression
- CART

#### Part 3 Unsupervised learning

- Unsupervised learning
- k-Means clustering
- Apriori algorithm
- FP-Growth

#### Part 4 Additional tools

mathematical operations used to remove noise from data

- principal components analysis
- the singular value decomposition
- a tool used to scale machine learning to massive datasets that cannot be adequately addressed on a single machine

others

- [errata](https://manning-content.s3.amazonaws.com/download/1/e6ee5c2-a85c-4601-871f-4ae80f611f58/Pharrington_MachineLearninginAction_err2.html)

## Part 1 Classification

Supervised learning asks the machine to learn from our data when we specify a target variable.

This reduces the machine’s task to only divining some pattern from the input data to get the target variable.

- The first case occurs when the target variable can take only nominal values, eg., profitable, unprofitable. -> Classification

- The second case of classification occurs when the target variable can take an infinite number of numeric values. -> Regression

### Chapter 1 Machine learning basics

With machine learning we can gain insight from a dataset; we’re going to ask the computer to make some sense from data. This is what we mean by learning, not cyborg rote memorization, and not the creation of sentient beings(AI, deep-learning).

- face recognition
- handwriting digit recognition
- spamfiltering in email
- product recommendations from Amazon.com

Spam emails

- looking at the occurrence of certain words used together,
- combined with the length of the email
- other factors

"How to Lie with Statistics" - Darrell Huff

#### terminology

- expert systems
- features / attributes
- instance made up of features
- classification: for each class the features / attributes' values are different
- training set 
- training examples
- target variable; In the classification problem the target variables are called classes, and there is assumed to be a finite number of classes.
  
  In classification the target variable takes on a nominal value, and in the task of regression its value could be continuous. 
  
  In a training set the target variable is known. The machine learns by finding some relationship between the features and the target variable. 
  
- test set
- knowledge representation

  * in the form of a set of rules
  * a probability distribution
  * an example from the training set  

#### key tasks of machine learning

Supervised Learning

- classification
- regression

egs.,

* k-Nearest Neighbors
* Naive Bayes
* Support vector machines
* Decision trees

Unsupervised Learning

- clustering: group similar items together
- density estimation: find statistical values that describe the data
- reducing: reducing the data from many features to a small number so that we can properly visualize it in two or three dimensions

eg.,

* k-Means
* DBSCAN

#### choose the right algorithm

check the data, 
- features nominal / continuous?
- missing values in the features? why?
- outliers in the data?
- looking for a needle in a haystack? (something that happens very infrequently?)

#### Steps in developing a machine learning application

1. Collect data
2. Prepare the input data: standard format; algorithm-specific formatting
3. Analyze the input data: distill multiple dimensions down to two or three so we can visualize the data; skip 3 if you don't have garbage coming in
4. Train the algorithm; in the case of unsupervised learning, there's no training step because you don't have a target value.
5. Test the algorithm  
6. Use it


#### conda with python 

[Create virtual environments for python with conda](https://uoa-eresearch.github.io/eresearch-cookbook/recipe/2014/11/20/conda/)

`randMat = mat(random.rand(4,4))`
`invRandMat = randMat.I`

Conda

- `conda -V`
- `conda create -n ml python=3.7.4 anaconda`
- `conda activate ml`

## Appendix B: Linear algebra

### terminology

- transpose 
- diagonal
- scalar operations: scalar multiplication and addition
- dot product
- identity matrix
- inverse of a matrix; if a matrix is not invertible, we say that it's singular or degenerate
- singular: a matrix can be singular if you can express one column as a linear combination of other columns; if you could do this, you could reduce a column in the matrix to all 0s.
- determinant
- norm
- derivative
- gradient descent

## Appendix C: Probability Refresher

### terminology

- joint probability
- algebraic expression

## Chapter 2 Classifying with k-Nearest Neighbors

### k-Nearest Neighbors

- Pros: High accuracy, insensitive to outliers, no assumptions about data 
- Cons: Computationally expensive, requires a lot of memory
- Works with: Numeric values, nominal values
- error rate: You can add up the number of times the classifier was wrong and divide it by the total number of tests you gave it.

### normalizing numeric values

- To scale everything from 0 to 1, you need to apply the following formula:

  `newValue = (oldValue-min)/(max-min)`
  
- To scale everything from -1 to 1  

### better performance

kNN is an example of instance-based learning, where you need to have instances of data close at hand to perform the machine learning algorithm. The algorithm has to carry around the full dataset; for large datasets, this implies a large amount of storage. In addition, you need to calculate the distance measurement for every piece of data in the database, and this can be cumbersome.

An additional drawback is that kNN doesn’t give you any idea of the underlying structure of the data; you have no idea what an “average” or “exemplar” instance from each class looks like. In the next chapter, we’ll address this issue by exploring ways in which probability measurements can help you do classification.

- One modification to kNN, called kD-trees, allows you to reduce the number of calculations.

## Chapter 3. Splitting dataset one feature at a time: decision trees

- Decision trees are often used in expert systems, and the results obtained by using them are often comparable to those from a human expert with decades of experience in a given field.

### steps

- discuss methods used to construct trees and starting writing code to construct a tree
- address some metrics that we can use to measure the algorithm's success
- use recursion to build our classifier and plot it using Matplotlib

### Decision trees

- Pros: Computationally cheap to use, easy for humans to understand learned results, missing values OK, can deal with irrelevant features
  * information theory: Infor- mation theory is a branch of science that’s concerned with quantifying information.
- Cons: Prone to overfitting
- Works with: Numeric values, nominal values; so any contin- uous values will need to be quantized.

### Pseudo-code for a function called createBranch() would look like this:

```
Check if every item in the dataset is in the same class: 
  If so return the class label
  Else
    find the best feature to split the data 
    split the dataset
    create a branch node
      for each split
        call createBranch and add the result to the branch node
    return branch node
```

### [ID3 algorithm](https://en.wikipedia.org/wiki/ID3_algorithm)

**ID3 can’t handle numeric values.** We could use continuous values by quantizing them into discrete bins, but ID3 suffers from other problems if we have too many splits.

which tells us how to split the data and when to stop splitting it.

ID3 is a greedy heuristic performing a best-first search for locally optimal entropy values. Its accuracy can be improved by preprocessing the data.
 
We can make whatever choice seems best at the moment and then solve the subproblems that arise later. The choice made by a greedy algorithm may depend on choices made so far, but not on future choices or all the solutions to the subproblem. It iteratively makes one greedy choice after another, reducing each given problem into a smaller one. In other words, a greedy algorithm never reconsiders its choices. This is the main difference from dynamic programming, which is exhaustive and is guaranteed to find the solution. After every stage, dynamic programming makes decisions based on all the decisions made in the previous stage, and may reconsider the previous stage's algorithmic path to solution.

### [Greedy algorithm](https://en.wikipedia.org/wiki/Greedy_algorithm)

### [Heuristic](https://en.wikipedia.org/wiki/Heuristic_(computer_science))

### Information Theory

The measure of information of a set is known as the Shannon entropy, or just entropy for short. Its name comes from the father of information theory, Claude Shannon.

Entropy is defined as the expected value of the information

- First, we need to define information. If you’re classifying something that can take on multiple values, the information for symbol xi is defined as

  \\[l(x_i) = l(x_i) = log_2p(x_i)\\]

  where p(xi) is the probability of choosing this class. (p(x) – The proportion of the number of elements in class x to the number of elements in set S)
  
  To calculate entropy, you need the expected value of all the information of all possible values of our class. This is given by
  
  \\[H = -\sum_{i=1}^np(x_i)log_2p(x_i)\\]
  
  where n is the number of classes.

  Entropy is a measure of the amount of uncertainty in the (data) set S (i.e. entropy characterizes the (data) set S).
  
  The higher the entropy, the more mixed up the data is.

- Information Gain

  Information gain IG(A) is the measure of the difference in entropy from before to after the set S is split on an attribute A. In other words, how much uncertainty in S was reduced after splitting set S on attribute A.
  
  \\[IG(S, A) = H(S) - \sum_{t\in T}p(t)H(t) = H(S) - H(S|A)\\]
  Where,
  * H(S) – Entropy of set S
  * T - The subsets created from splitting set S by attribute A such that \\[S = \bigcup_{t\in T}t\\]
  * p(t) - The proportion of the number of elements in t to the number of elements in set S
  * H(t) - Entropy of subset t
  
  Let’s split the dataset in a way that will give us the largest information gain. We won’t know how to do that unless we actually split the dataset and measure the information gain.
  
  You’ll stop under the following conditions: 
  - you run out of attributes on which to split or
  - all the instances in a branch are the same class.   
  
- Gini impurity: Another common measure of disorder in a set. 

  which is the probability of choosing an item from the set and the probability of that item being misclassified.
  
  [A Simple Explanation of Gini Impurity](https://victorzhou.com/blog/gini-impurity/)
  
### matplotlib

- In Python, all variables are global by default  

- change dir in Python 
  
  `import os`
  `os.chdir(path)`  
  
### Persistence

- The Python Pickle module can be used for persisting our tree.  
  
### Overfitting

- The contact lens data showed that decision trees can try too hard and overfit a dataset. This overfitting can be removed by pruning the decision tree, combining adjacent leaf nodes that don’t provide a large amount of information gain.

- There are other decision tree–generating algorithms. The most popular are

  - C4.5
  - CART

## Chapter 4. Classifying with probability theory: naive Bayes

### Naïve Bayes

- Pros: Works with a small amount of data, handles multiple classes
- Cons: Sensitive to how the input data is prepared
- Works with: Nominal values, a popular algorithm for the document-classification problem.
- Assumption:
  - If we assume independence among the features, then our N1000 data points get reduced to 1000*N.
  - The other assump- tion we make is that every feature is equally important. 

### probability

- Bayesian probability: allows prior knowledge and logic to be applied to uncertain statements.
- Frequency probability: only draws conclusions from data and doesn’t allow for logic and prior knowledge.
- Statistics tells us that if we need N samples for one feature, we need N10 for 10 features and N1000 for our 1,000-feature vocabulary. The number will get very large very quickly； If we assume independence among the features, then our N1000 data points get
reduced to 1000*N. 

### Steps

### Reference

- [資料分析經典模型 — — 貝葉斯理論，10分鐘講清楚](https://medium.com/@allaboutdataanalysis/%E8%B3%87%E6%96%99%E5%88%86%E6%9E%90%E7%B6%93%E5%85%B8%E6%A8%A1%E5%9E%8B-%E8%B2%9D%E8%91%89%E6%96%AF%E7%90%86%E8%AB%96-10%E5%88%86%E9%90%98%E8%AC%9B%E6%B8%85%E6%A5%9A-313df7c97ea9)

- [数学之美番外篇：平凡而又神奇的贝叶斯方法](http://mindhacks.cn/2008/09/21/the-magical-bayesian-method/)

- [贝叶斯网络，看完这篇我终于理解了(附代码)！](https://juejin.im/post/5d29509fe51d455070227030)

- [怎样判断漂亮女孩是不是单身的？](https://cloud.tencent.com/developer/article/1366233)

----

# [scikit-learn](https://scikit-learn.org/stable/)

----
# Apply Machine Learning to Stocks

## kNN

### Steps

1. Use attributes and history data (latest 2 weeks, except today) to classify all stocks to profitable and unprofitable
2. Use the 90% data as the train set
3. Use the rest 10% data as the test set
4. If error rate < 40%, apply today's trading data and add those stocks into the portfolio
5. If cannot gain profit within 3 days, remove the stock

### Input Data Structure

| A | B | C | D | Class |
| ------ | ------ | ------ | ------ | ------ |
| 1.1 | 2.2 | 3.3 | 4.4 | Profitable |
| 4.2 | 2.9 | 3.6 | 7.7 | Unprofitable |

### Reference

[Using kNN Classifier to Predict Whether the Price of Stock Will Increase](https://datascienceplus.com/knn-classifier-to-predict-price-of-stock/)
[机器学习与股票实践——用KNN算法预测股票收益率](https://zhuanlan.zhihu.com/p/39786361)
[机器学习实战--kNN](https://xueqiu.com/8287840120/76856084)

## Decision Trees

### Steps

1. Use attributes and history data to classify stocks to profitable and unprofitable

2. Use the 90% data as the train set to build the Tree
3. Use the rest 10% data as the test set
4. check the error rate
5. apply new data to the Decision Tree to check the new class of each stock and build new portfolio accordingly
6. If cannot gain profit within 3 days, remove the stock

### Input Data Structure

1. ID3 can’t handle numeric values.

| A | B | C | D | Class |
| ------ | ------ | ------ | ------ | ------ |
| true | false | true | false | Profitable |
| false | false | true | true | Unprofitable |
