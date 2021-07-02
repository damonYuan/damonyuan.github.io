microservices: from design to deployment
Microservice reference architecure
====

1. Netflix api gateway

> https://medium.com/netflix-techblog/reactive-programming-in-the-netflix-api-with-rxjava-7811c3a1496a

2. Spring reactor

> https://projectreactor.io/

> https://tech.io/playgrounds/929/reactive-programming-with-reactor-3/Intro

3. Materialized view

A materialized view takes a different approach: the query result is cached as a concrete ("materialized") table (rather than a view as such) that may be updated from the original base tables from time to time. This enables much more efficient access, at the cost of extra storage and of some data being potentially out-of-date. Materialized views find use especially in data warehousing scenarios, where frequent queries of the actual base tables can be expensive.


