Spring in Action
====

# Chapter 1. Springing into action

1. four key strategies:

   * Lightweight and minimally invasive development with POJOs.
   * Loose coupling through DI and interface orientation.
   * Declarative programmming through aspects and common conventions.
   * Eliminating boilerplate code with aspects and templates.

1.3.1 Spring modules

  - CORE SPRING CONTAINER
  - AOP
  - INSTRUMENTATION
  - WEB AND REMOTING
  - DATA ACCESS & INTEGRATION
  - TESTING   


# Chapter 2. Wiring beans

2.2.3

  - The one thing about setting the base packages as shown here is that they’re expressed as String values. That’s fine, I suppose, but it’s not very type-safe. If you were to refac- tor the package names, the specified base packages would be wrong.

2.2.4

  - Put succinctly, autowiring is a means of letting Spring automatically satisfy a bean’s dependencies by finding other beans in the application context that are a match to the bean’s needs.
  - In the event that multiple beans can satisfy the dependency, Spring will throw an exception indicating ambiguity in selecting a bean for autowiring.
  - @Autowired <-> @Inject
  - @Component <-> @Named

2.3.3

  - It appears that the CompactDisc is provided by calling sgtPeppers, but that’s not exactly true. Because the sgtPeppers() method is annotated with @Bean, Spring will intercept any calls to it and ensure that the bean produced by that method is returned rather than allowing it to be invoked again.
  - By default, all beans in Spring are singletons, and there’s no reason you need to create a duplicate instance for the sec- ond CDPlayer bean.  
  - NOTE: Compare with dagger, the dagger components provide scope-embeded singleton, and the instance is initiated through modules.

    > http://frogermcs.github.io/dependency-injection-with-dagger-2-custom-scopes/

  2.4.4

    - constructor injection for hard dependencies and prop- erty injection for any optional dependencies


# Chapter 3. Advanced wiring

# Chapter 4. Aspect-oriented Spring

- In software development, functions that span multiple points of an application are called cross-cutting concerns.

4.1.1

  - Like most technologies, AOP has its own jargon. Aspects are often described in terms of advice, pointcuts, and join points.

  - In AOP terms, the job of an aspect is called advice.

  - A join point is a point in the execution of the application where an aspect can be plugged in.

  - A pointcut definition matches one or more join points at which advice should be woven.

  - An aspect is the merger of advice and pointcuts.

  - An introduction allows you to add new methods or attributes to existing classes.

  - Weaving is the process of applying aspects to a target object to create a new proxied object.

    * Compile time (AspectJ)
    * Class load time (AspectJ)
    * Runtime (Spring AOP)

4.3.4

  - Some languages, such as Ruby and Groovy, have the notion of open classes. They make it possible to add new methods to an object or class without directly changing the definition of those objects or classes. 

  In fact, using an AOP concept known as introduction, aspects can attach new methods to Spring beans.

  - (The plus sign at the end specifies any subtype of Performance, as opposed to Performance itself)

  -  When Spring discovers a bean annotated with @Aspect, it will automatically create a proxy that delegates calls to either the proxied bean or to the introduction implementation, depending on whether the method called belongs to the proxied bean or to the introduced interface.

  - 




