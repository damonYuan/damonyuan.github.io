---
title:  "Microservice Modularisation"
description: "Modularisation"
date: 2019-01-23 15:04:23
categories: [Tech]
tags: [Microservice]
---

### Platform Layer

- docker swarm/stack
- Netflix 
- Spring Cloud

### Infrastructure Layer

- parent project 
  - unify the version of libraries used
  - apply the plugins to gradle
  
- log module   
  - trackers to be implemented by microbase   

- data access module
  - abstraction
    - interface for common access methods
    - abstract class for different data source
      - read/write separation
      - async write with redis type
      - nosql type
      - graphdb type
    - endpoint should be configurable through profile  
  - implementation
    - database: mysql, postgresql, nosql, graph
    - cache: redis, memcache  
    
- microbase module (depends on log module)
  - client resiliency
  - common utils
  
- search module (depends on data access module)  

- event bus module
  - abstraction
    - interface
    - abstract class
    - endpoint should be configurable through profile
  - implementation
    - MQ
    - kafka  

### Service Layer

- Oauth module

### Business Layer

Other services

### API Layer

Provide the API Gateway
