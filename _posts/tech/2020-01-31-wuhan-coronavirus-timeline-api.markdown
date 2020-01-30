---
title:  "Wuhan Coronavirus Timeline API | 武汉肺炎 Timeline API"
description: "Wuhan Coronavirus Timeline API | 武汉肺炎 Timeline API"
date: 2020-01-30 15:04:23
hidden: false
categories: [Tech]
tags: [Wuhan, Coronavirus, Timeline, API, Pneumonia]
---

> * Author: [Damon Yuan](https://www.damonyuan.com)
> * Date: 2020-01-30

Recently the situation of Wuhan Coronavirus is getting serious, more and more foreign friends are aware of it and taking preventive measures to protect themselves from getting infected. Some of them are even interested in what is happening in China, and drop their jaws when hearing something like [China building 1,000-bed hospital in 10 days to treat coronavirus](https://www.dezeen.com/2020/01/27/china-wuhan-huoshenshan-hospital-coronavirus/). 

To get the related credible information from China propagated easier with less language barrier and without second hand modification, I have just created a project to provide the API for English speaking forks consuming. For now it only crawls some Timeline information and I might add more in the future if the time is allowed.

The project is consisted by,

- One MongoDB service
- One MongoExpress service
- One crawler based on Scrapy, and integrated with Google Translation API
- One SpringBoot based API server
- One Swagger UI instance
- One React.js based web app (working on it)

All of them are deployed to Kubernetes with Istio enabled. 

I will open source it later when I feel ready and please let me know if any questions.

The API docs is here: [Wuhan Coronavirus Timeline API | 武汉肺炎 Timeline API](https://wuhanapi.damonyuan.com/)

---

__--CONTINUE--__
