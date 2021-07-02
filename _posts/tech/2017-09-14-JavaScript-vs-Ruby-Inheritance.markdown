---
title:  "JavaScript vs Ruby in Inheritance"
description: "Both JavaScript and Ruby have special inheritance model. In JavaScript, it is handled by stuff known as prototype chain; in ruby, there is a special class named as Singleton Class that wires all the magic up. The basic concept is the same: instance methods should be placed in 'Class' so that the instance can refer to it rather than duplicating it. Here is a diagram to clarify the inheritance chain in JS and Ruby and hope the comparison will shed some light on the common concept."
date: 2017-09-14 15:04:23
categories: [Tech]
tags: [JavaScript, Ruby]
---

> * Author: [Damon Yuan](https://www.damonyuan.com)
> * Date: 2017-09-14

Both JavaScript and Ruby have special inheritance model. In JavaScript, it is handled by stuff known as prototype chain; in ruby, there is a special class named as Singleton Class that wires all the magic up. The basic concept is the same: instance methods should be placed in 'Class' so that the instance can refer to it rather than duplicating it. Here is a diagram to clarify the inheritance chain in JS and Ruby and hope the comparison will shed some light on the common concept.

Note: the foo object in ruby diagram also has an corresponding singleton class. And the `extend` key word is a short-cut to open the singleton class.
```
moddule m
// here is the module
// do whatever you want 
end

foo.exend m
```

```
foo.instance_eval do
// here the singleton class of object foo is open 
// do whatever you want 
end
```

![COMPARE]({{site.url}}/images/2017-09-14-Javascript-vs-Ruby-Inheritance/JS-vs-Ruby-Inheritance.png)

By the way, [Metaprogramming Ruby 2](https://pragprog.com/book/ppmetr2/metaprogramming-ruby-2) is really great a book for rubyists.
