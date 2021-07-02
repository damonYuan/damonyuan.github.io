---
title:  "The first line of Android Application"
description: "How to design the architecture of an Android Application"
date: 2019-01-12 15:04:23
categories: [Tech]
tags: [Android]
---

- Preface
- Architecture and Modularisation
- How to Share common modules
  - Inside the team
  - Outside the team   
  - Gradle
- Git flow and DevOps
  - Git flow
    - Branch Naming Convention
    - PR template
  - DevOps
    - Circle CI, Jenkins, Travis CI
    - Gradle
      - Parent-children structure
      - Script and configuration
      - Dependency Management
    - Lint
      - Android Lint
      - KtLint
      - PMD
      - Checkstyle
      - Findbugs
    - Unit Test and Coverage
      - Jacoco
    - Instrument Test and Device Farm  
    - Security Scan
      - Checkmax
      - SonarQube    
- Structure Pattern
  - MVVM
  - Folder Structure
  - Domain Driven Design
  - Dependency Injection
  - PubSub
- Languages in one application (Open-Close principle)
  - Kotlin
  - Java
- Common Features  
  - Security
    - Basic Authentication
    - OAuth 2.0
  - Error Handling
  - Environment management with Flavor
    - non-production
    - production
  - Principles for API client
- Apendix A Desgin Pattern in Android
  - Inheritance vs Facade Pattern
  - Singleton Pattern
  - Builder Pattern
  - Factory Pattern
  - Strategy Pattern
- Apendix B Activity And Fragment
- Apendix C Concurrency in Android
- Apendix D Other parts in Android not mentioned
- index  

## Preface

Although this series of articles is about Android Application, however it also applies to other frontend application like iOS, React.js, Flutter, etc.

----


Architecture and Modularisation
===============================

### What is the problem

problem in getting some information about the architecture in application, most of architecture is about the backend application and most of the articles in client side are about the details in one specific implementation.

### Why it is important

(What will happen if we don't it)

- Client application code base is pretty large
- Client side code is changeable
- Normally more than one product will be created and there are common parts that can be shared
- Extensible
- Scalability
...

### When to start

When we start to write an application, what is the first thing that we need to consider?

at the very beginning, it is more and more difficult for us to refactor the source code after it has grown to some extent.

### How to implement

modularization and layers

Two dimension to consider:

- Horizontally

- Vertically

....

### Conclusion

(what we have mentioned above)
