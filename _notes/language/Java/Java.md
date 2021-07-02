Java
==============

# Java -  the googd part

1. Best Singleton design
```
public class Something {
  private Something() {}

  private static class LazyHolder {
      private static final Something INSTANCE = new Something();
  }

  public static Something getInstance() {
      return LazyHolder.INSTANCE;
  }
}
```

2. Backdoor from static field
Java allows static fields in classes, which are shared among all members of the class. This allowed a backdoor mechanism for applets to communicate with each other. If two applets were members of a class that shared a static variable, they could use that static variable to exchange information between themselves.

3. all good classes that extend that interface will declare a serialVersionUID

4. reference vs pointer: http://stackoverflow.com/questions/57483/what-are-the-differences-between-a-pointer-variable-and-a-reference-variable-in

5. generational collector keeps two heaps of objects

6. A finalizer is a special method on a class that is run prior to any object of the class being garbage collected.
   Finalizers are run in an asynchronous fashion.

7. The Java compiler translates the source code into a file of bytecodes, which are then run within the JVM.

8. JIT compiler
   conventional compilers build the whole program as an EXE file BEFORE the first time you run it. For newer style programs, an assembly is generated with pseudocode (p-code). Only AFTER you execute the program on the OS (e.g., by double-clicking on its icon) will the (JIT) compiler kick in and generate machine code (m-code) that the Intel-based processor or whatever will understand.

9. One of the ways that the JVM provides security is that it verifies all the code run in the JVM prior to loading that code. 

   The bytecodes generated for every language will be the Java bytecodes, and the restrictions enforced by the verifier on sequences of bytecodes are tied to the Java language. So if you are using a language that generates bytecodes so that you can use the JVM as your virtual machine, make sure to check the small print of the documentation.

10. The Javadoc tool is the program that turns your comments into HTML files.

11. RMI: Java’s Remote Method Invocation (RMI) system is, on the surface, such a remote pro- cedure call mechanism. 

-----

# https://www.javatpoint.com/RMI

1. RMI (Android AIDL)

2. inner class
   1. Non-static nested class(inner class)
      a)Member inner class
      b)Annomynous inner class
      c)Local inner class
   2. Static nested class

3. JDBC
   Before JDBC, ODBC API was the database API to connect and execute query with the database. But, ODBC API uses ODBC driver which is written in C language (i.e. platform dependent and unsecured). That is why Java has defined its own API (JDBC API) that uses JDBC drivers (written in Java language).



------

# http://tutorials.jenkov.com/java-concurrency/index.html

1.

----

# http://tutorials.jenkov.com/software-architecture/load-balancing.html

The most common load balancing schemes are:

1. Even Task Distribution Scheme
2. Weighted Task Distribution Scheme
3. Sticky Session Scheme
4. Even Size Task Queue Distribution Scheme
5. Autonomous Queue Scheme

----

# http://tutorials.jenkov.com/p2p

1. keys: 1. Peer Identification 2.Peer Location
2. P2P network algorithm: Chord, Kademlia, Pastry, Tapestry

----

# http://tutorials.jenkov.com/soa/index.html


----

# RxJava

1.  public static <T> Observable<T> create(ObservableOnSubscribe<T> source);

http://stackoverflow.com/questions/32725121/what-is-the-t-in-my-code-doing-there // not understand yet

2. Func1<? super T,? extends K> keySelector
 
Generic in function?? // not understand yet

----

# Install Tomcat in Mac OS

https://maltronic.io/2016/01/14/easily-install-apache-tomcat-on-mac-os-x-10-11-el-capitan-with-homebrew/

$ brew install tomcat
$ brew services list

# Six steps to run your first Servlet (http://www.informit.com/articles/article.aspx?p=26920&seqNum=4)

  1. Step 1: Create a Directory Structure under Tomcat






