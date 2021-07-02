---
title:  "DDD in Android"
description: "Domain-Driven Design in Android Application with Dependency Injection and Offline"
date: 2018-06-23 18:00:00
categories: [Tech]
tags: [DDD, Android, Offline]
---

> https://www.oschina.net/question/54100_10400

### What is Dependency Injection, why and how

    - What

    - Why

    - How

      Dagger

### What is Componentized Application, why and how

   - What

   - Why

     * Test and automation
     * Code Reuse
     * Code Quality

   - How

### What is Domain-Driven Design

### How is it implemented in Web Service

    - Mode 1
    - Mode 2
    - Mode 3
    - Mode 4

### How can it be implemented in Android Application



    - Where should DAO interfaces be placed? Dependent package? Lib package? Separate package?
    - How Spring handle it
      - Spring framework provide the public interface and the application import it
      - Application provide the implementation and provide it to Spring Framework
    - Principle - Lib as Util(dependency relationship - Dao interfaces in lib) or Impl(true decouple - public interfaces in separate library)
      - Util definition (Decouple the business logic but not the dependency), Others can CompileOnly the lib and implement its own solution (need test)
      - Impl definition (Decouple both the business logic and the dependency)
      - Util example: (API)
        - Four layers
        - Principle - Data Persistent
      - Impl example: (Log)

### The difference between Web Service and Android Application - Offline feature

### Example



