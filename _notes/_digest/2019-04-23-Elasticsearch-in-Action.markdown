---
title:  "Elasticsearch in Action"
description: "Elasticsearch in Action"
hidden: true
date: 2019-04-23 15:04:23
categories: [Tech, Mindmap]
tags: [Elasticsearch]
---

# Chapter 1: Introducing Elasticsearch

  Both Elasticsearch and Solr are based on Lucene.

  GUI: https://hub.docker.com/r/elastichq/elasticsearch-hq/

## Sharding

  The ability to split your data across multiple servers.

## replicas

  Copies for each of your initial shards.

## primaries

  Your initial shards. Primaries differ from replicas in that they're the first to receive new documents. Other than that, they're the same: both index the same documents eventually, and both can serve searches.

  this helps in two ways:

  * Because searches also run on replicas, you can increase the number of concurrent searches you serve by adding more nodes and replicas to your cluster.
  * Replicas and primary shards index documents in the same way, and replicas can be promoted to primaries. That's exactly what Elasticsearch does in the event that a node hosting a primary shard goes down.

# Chapter 2: Diving into the functionality

## Index a documents

   * Documents are indexed to random primary shards and their replicas.
   * Searches run on complete sets of shards, regardless of their status as primaries or replicas.
     (Q: how about the sync between the primary and the replicas)
   * A shard is a Lucene index: a directory of files containing an inverted index.
   * Too few shards limit how much you can scale and too many shards impact performance.
   * Elasticsearch uses a round-robin format to forward the request to the cluster’s nodes and shards.

## Searching for and retrieving data

### tf-idf (term frequency-inverse document frequency) algorithm

   Term frequency means for each term (word) you search, the document’s score is increased if it has more occurrences of that term. Inverse document frequency means the score is increased more if the term is rare across all documents because it’s considered more relevant.

### Also by default, Elasticsearch returns documents matching any of the specified words.

### Filters care only whether a result matches the search or not.

### Remember that newly indexed documents only appear in searches after a refresh.

## Adjusting JVM settings

### The default setting lets Elasticsearch allocate 256MB of your RAM for its heap, initially, and expand it up to 1GB.

### K8S node types

there are only 4 node types - master, data, client and tribe;

Master only nodes take place in updating cluster state as well as master elections. They should never handle query or index loads.
Data only nodes store data that is indexed into Elasticsearch. These can also handle querying and indexing.
Client only nodes are used as load balancers for indexing and searching.
Tribe nodes are akin to cross-cluster client nodes, in that they can query more than one cluster. Think federated search.

# Chapter 3: Indexing, updating, and deleting data

## Two fields with the same name

  This approach creates a problem when the same field name occurs in multiple types. To avoid unpredictable results, two fields with the same name should have the same settings, otherwise Elasticsearch might have a hard time figuring out which of the two fields you’re referring to. In the end, both those fields belong to the same Lucene index. For example, if you have a name field in both group and event documents, both should be strings, not one a string and one an integer. This is rarely a problem in real life, but it’s worth remembering to avoid surprises.

## Define a type

  You can define a new mapping after you create the index but before inserting any document into that type. When you put a mapping over an existing one, Elasticsearch merges the two.  

  Removing data also removes the current mapping.

  editing an existing document implies deleting and indexing again.

  the default analyzer lowercases all letters, and then breaks the string into words.

  The analyzer removes the word "with" because it’s so common it belongs to a list of stop words. stop words are eliminated during analysis because they appear so frequently that they’re irrelevant in searches.

  Stemming produces terms that are synonyms of your original terms, so queries for synonyms match as well.

  let’s look at the index option, which can be set to analyzed (the default), not_analyzed or no.

  For some queries, such as the query_string you used previously, the analysis process is applied to your search criteria.

  Predefined field names always begin with an underscore.

  We’ll divide the predefined fields in the following categories:

  - Control how to store and search your documents— \_source lets you store the original JSON document as you index it. \_all indexes all your fields together.

  - Identify your documents—These are special fields containing data about where your document was indexed: \_uid, \_id, \_type, \_index.

  - Add new properties to your documents—You can index the size of the original JSON with \_size. Similarly, you can index the time it was indexed with \_timestamp and make Elasticsearch delete it after a specified amount of time with \_ttl.

  - Control the shard where your documents are routed to—These are \_routing and \_parent. We’ll look at them in chapter 8, where we talk about relationships among documents.

## Breaking changes in Elasticsearch 6.x

  > https://www.elastic.co/guide/en/elasticsearch/reference/6.0/breaking-changes-6.0.html

## \_ttl

  To change the frequency of those searches, by change the value of indices.ttl.interval in the configuration file. You can also change the indices.ttl.bulk_size option to adjust the size of each bulk of expired documents that gets deleted at a time.

## Pessimistic Locking

  This kind of concurrency control is called optimistic because it allows parallel operations and assumes that conflicts appear rarely, throwing errors when they do appear. This is opposed to pessimistic locking, in which conflicts are prevented in the first place by blocking operations that might cause conflicts.

## Instead of deleting indices, you also have the option of closing them. If you close an index, you won’t be able to read or write data from it with Elasticsearch until you open it again.

# Chapter 4. Searching your

## Query

## Filter

Filters are similar to the queries we discuss in this chapter, but they differ in how they affect the scoring and performance of many searching actions. Rather than computing the score for a particular term as queries do, a filter on a search is a simple binary “does this document match this query” yes-or-no answer.

Because of this difference, filters can be faster than using a regular query, and they can also be cacheable.

# Chapter 5. Analyzing your data

Analysis is the process Elasticsearch performs on the body of a document before the document is sent off to be added to the inverted index. Elasticsearch goes through a number of steps for every analyzed field before the document is added to the index:

  - Character filtering: Transform the characters using a character filter.
  - Breaking text into tokens: Break apart the text into a set of one or more tokens.
  - Token filtering: Transform each token using a token filter.
  - Token indexing: Store those tokens into the index.

# Chapter 6. Searching with relevancy

# Chapter 7. Exploring your data with Aggregations

Aggregations are divided in two main categories: metrics and bucket. Metrics aggre- gations refer to the statistical analysis of a group of documents, resulting in metrics such as the minimum value, maximum value, standard deviation, and much more. For example, you can get the average price of items from an online shop or the number of unique users logging on to it.

Bucket aggregations divide matching documents into one or more containers (buckets) and then give you the number of documents in each bucket. The terms aggregation, which would give you the most popular tags in figure 7.1, makes a bucket of documents for each tag and gives you the document count for each bucket.

# Chapter 8. Relations among documents

# Chapter 9. Scaling out

# Chapter 10. Improving performance

# Chapter 11. Administering your cluster

# Appendixes     

## A. Working with Geospatial data

## B. Plugins

## C. Highlighting

## D. Elasticsearch monitoring plugins

## E. Turning search upside down with the percolator

## F. Using suggesters for autocomplete and did-you-mean functionality

# TODO

1. Sync RDMS to Elasticsearch
