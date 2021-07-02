---
title:  "Java DS & A"
description: "Java Data Structure and Algorithm"
hidden: true
date: 2019-04-14 15:04:23
categories: [Tech, Mindmap]
tags: [Java, Algorithm, Data Structure]
---

## Chapter 1. Java Primer

## Chapter 2. Object-Oriented Design

1. Robustness Encapsulation Modularity

2. Design pattern: 
    
    1. solving algorithm design problems
       * Recursion
       * Amortization
       * Divide-and-Conquer
       * Prune-and-Search/Decrease-and-Conquer
       * Brute force
       * The greedy method
       * Dynamic programming
    2. solving software engineering problems
       * Template method
           
           The template method pattern can be applied to implement each of the methods addAll, retainAll, and removeAll using only calls to the more fundamental methods add, remove, contains, and iterator.

       * Composition
       * Adapter
       * Position
       * Iterator
       * Factory Method
       * Comparator
       * Locator

## Chapter 3. Fundamental data structure

1. Array

java.util.Array;
java.util.ArrayList;

2. Singly linked lists

3. circulary linked list 

4. doubly linked list

java.util.LinkedList;

5. pseudorandom number generator

java.util.Random;

next = (a ∗ cur + b) % n; at the begining there should be a seed.

## Chapter 4. Algorithm Analysis

1. the seven functions

constant logarithm linear n-log-n quadratic cubic exponential
1        log n     n      nlogn   n^2       n^3   a^n

## Chapter 5. Recursion

1. fibonacci

the bad way: 

public static long fibonacciBad(int n) {
    if (n <= 1) {
        return n;
    } else {
        return fibonacciBad(n - 2) + fibonacciBad(n - 1);
    }
}

O(2^n)

the good way:

public static long[] fibonacciGood(int n) {
    if (n <= 1) {
        long[] answer = {n, 0};
        return answer;
    } else {
        long[] temp = fibonacciGood(n - 1);
        long[] answer = {temp[0] + temp[1], temp[0]};
        return answer;
    }

2. Eliminating tail recursion

A recursion is a tail recursion if any recursive call that is made from one context is the very last operation in that context, with the return value of the recursive call (if any) immediately returned by the enclosing recursion. By necessity, a tail recursion must be a linear recursion (since there is no way to make a second recursive call if you must immediately return the result of the first).

Tail recursions are special, as they can be automatically reimplemented nonrecursively by enclosing the body in a loop for repetition, and replacing a recursive call with new parameters by a reassignment of the existing parameters to those value.

## Chapter 6. Stacks, Queues and Deques

1. Stack

java.util.Stack;

difference between Vector and ArrayList:

* Vectors are synchronized, ArrayLists are not;
* Data Growth method: both of them hod onto their content by Array. A Vector defaults to doubling the size of its array, while the ArrayList increases its array size by 50 percent.

2. Queue

java.util.Queue;
java.util.PriorityQueue;

java.util.concurrent.LinkedBlockingQueue; 
java.util.concurrent.SynchronousQueue;
java.util.concurrent.TransferQueue;
java.util.concurrent.LinkedTransferQueue;
java.util.concurrent.PriorityBlockingQueue;
java.util.concurrent.ArrayBlockingQueue;

BlockingQueue implementation are designed to be used primarily for producer-consumer queues.

java.util.concurrent.ConcurrentLinkedQueue;

Non-blocking: https://stackoverflow.com/questions/1426754/linkedblockingqueue-vs-concurrentlinkedqueue


3. Double-Ended Queue -> Deque

supports insertion and deletion at both the font and the back of the queue.

java.util.ArrayDeque;
java.util.Deque;

java.util.concurrent.DelayDeque;
java.util.concurrent.BlockingDeque;
java.util.concurrent.LinkedBlockingDeque;

java.util.concurrent.ConcurrentLinkedDeque;

## Chapter 7. List and Iterator ADTs

1. The java Collections framework

java.util.AbstractCollection;
java.util.Collections;
java.util.Collection;

2. sorting: https://en.wikipedia.org/wiki/Sorting_algorithm

* simple sort
1. insertion sort *
2. selection sort *

* efficient sort
1. merge sort *
2. heap sort *
3. quick sort *

* bubble sort and variants
1. bubble sort *
2. shell sort
3. comb sort

* distribution sort
1. counting sort
2. bucket sort
3. radix sort

3. Amortization (dynamic Arrays): A com- monly used rule is for the new array to have twice the capacity of the existing array that has been filled.


## Chapter 8. Trees

1. A tree is an abstract data type that stores elements hierarchically. With the excep- tion of the top element, each element in a tree has a parent element and zero or more children elements.

2. A binary tree is an ordered tree with the following properties:
    1. Every node has at most two children.
    2. Each child node is labeled as being either a left child or a right child. 
    3. A left child precedes a right child in the order of children of a node.

    A binary tree is proper if each node has either zero or two children.

3. LinkedBinaryTree and Array based binary tree

4. Tree traversal algotithm
    1. In a preorder traversal of a tree T , the root of T is visited first and then the sub- trees rooted at its children are traversed recursively.

    2. Another important tree traversal algorithm is the postorder traversal. In some sense, this algorithm can be viewed as the opposite of the preorder traversal, be- cause it recursively traverses the subtrees rooted at the children of the root first, and then visits the root (hence, the name “postorder”).    

    3. Breadth-First Tree Traversal: Although the preorder and postorder traversals are common ways of visiting the positions of a tree, another approach is to traverse a tree so that we visit all the positions at depth d before we visit the positions at depth d + 1. Such an algorithm is known as a breadth-first traversal.

    4. Inorder Traversal of a Binary Tree: During an inorder traversal, we visit a position between the recursive traversals of its left and right subtrees. The inorder traversal of a binary tree T can be informally viewed as visiting the nodes of T “from left to right.” 

## Chapter 9. Priority Queue

1. Priority Queue: This is a collection of prioritized elements that allows arbitrary element insertion, and allows the removal of the element that has first priority.

implementation: unsorted list and heap

2. Heap: Heap-Order Property: In a heap T , for every position p other than the root, the key stored at p is greater than or equal to the key stored at p’s parent.

3. java.util.PriorityQueue; 
   java.util.PriorityBlockingQueue;

4. A heap is a binary tree T that stores entries at its positions and that satisfies two additional properties: a relational property defined in terms of the way keys are stored in T and and a structural property defined in terms of the shape of T itself.

Heap-Order Property: In a heap T, for every position p other than the root, the key stored at p is greater than or equal to the key stored at p's parent.

## Chapter 10. Maps, Hash Tables, and Skip Lists

1. maps: 
    java.util.AbstractMap;
    java.util.Map;
    java.util.EnumMap;
    
    java.util.HashMap;
    java.util.IdentityHashMap;
    java.util.WeakHashMap;
    java.util.LinkedHashMap;
    java.util.concurrent.ConcurrentHashMap; // extends java.util.concurrent.ConcurrentMap;

    java.util.concurrent.ConcurrentSkipListMap;

    java.util.NavigableMap; // extends java.util.SortedMap;
    java.util.concurrent.ConcurrentNavigableMap;

    java.util.TreeMap;

2. HashMap : Hash function and Compression function(MAD -> Multiply-Add-and-Divide)
    
    Collision-Handling Schemes: Separate Chain & Open Addressing

    Separate Chain: Array + UnsortedTableMap
    Open Addressing: Probing
        * linear probing -> clustering
        * quadratic probing ( A[(h(k)+ f(i)) mod N], for i = 0,1,2,..., where f(i) = i2) -> secondary clustering
        * double hashing -> A[(h(k)+ f(i)) mod N] next, for i = 1,2,3,..., where f(i) = i·h′(k)
        
    In the hash table schemes described thus far, it is important that the load factor, λ = n/N, be kept below 1. 

3. Sorted Map: binary search -> replace or insert; using array list. (TreeMap)

4. Skip Lists (In fact, experimental evidence suggests that optimized skip lists are faster in practice than AVL trees and other balanced search trees)
    
5. Sets, Multisets, and Multimaps

1. Set: A set is an unordered collection of elements, without duplicates, that typi- cally supports efficient membership tests. In essence, elements of a set are like keys of a map, but without any auxiliary values.

    java.util.AbstractSet;
    java.util.BitSet;
    java.util.EnumSet;
    java.util.HashSet;
    java.util.LinkedHashSet;
    java.util.NavigableSet;
    java.util.Set;
    java.util.SortedSet;
    java.util.TreeSet;

    java.util.Concurrent.ConcurrentSkipListSet;
    java.util.Concurrent.CopyOnWriteArraySet;

## Chapter 11. Search Trees

1. Binary Search tree: we may only claim O(n) worst-case time, because some sequences of operations may lead to an unbalanced tree with height proportional to n.

2. Balanced Search Tree
   * template method design pattern: provide the trivial declarations of methods, having bodies that do nothing.

   Important functions:
   1. public void rotate(Position<Entry<K,V>> p);
      Rotates Position p above its parent;
   2. public Position<Entry<K,V>> restructure(Position<Entry<K,V>> x);
      Performs a trinode restructuring of Position x with its parent/grandparent;

   2.1 AVL Tree (named after inventors Adelson-Velsky and Landis) 
      * Height-Balance Property: For every internal position p of T , the heights of the children of p differ by at most 1.
      * an AVL tree storing n entries has height at most 2 log n + 2.
      * restore the balance of the nodes in the binary search tree T by a simple "search-and-repair" strategy.

   2.2 Splay Tree
      * A splay operation causes more frequently accessed elements to remain nearer to the root, thereby reducing the typical search times. The surprising thing about splaying is that it allows us to guarantee a logarithmic amortized running time, for insertions, deletions and searches.
      
   2.3 Red-Black Tree

3. (2,4) Tree
