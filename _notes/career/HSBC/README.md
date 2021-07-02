README
====

1. Work to do

   - Read source code

   - The layout of android architecture we are going to achieve
     
     1. Componentized/Modulized application

        - Dependency Injection (Decoupled components, always use interface when inject)
        - API clients/Local Persistent/Model (Domain Driven Design: API/Database, Entity, and DAO -> AnemicDomainModel(https://martinfowler.com/bliki/AnemicDomainModel.html); internal/external API; different clients with different gateway; Facade pattern for presenter -> Reactive; Item, ItemDao, ItemDaoImpl; ItemManger)
        - Log (ELK stack: centralized log, analysis and monitoring)
        - Tracker (AOP with tracking vendors and analysis)
        - Concurrency model - Functional Reactive Programming and EventBus (why -> Microservice style, Gateway, defects in shared memory; sync/aync/concurrent/non-concurrent; Concurrent programming in android)
        - Application Design Patterns: MVP/MVVM, VIP (Is there any difference?)
        - UIKit
        - Utils (implemented as Traits -> Kotlin and Java 8 - default methods in Interface)
        - Security

     2. Test

        - UI test
        - Monkey test
        - Unit test: bug fixes must have unit test
        - Coverage
        - Integration tests
        - Happy path and sad path

     3. Code quality refactor: 

        - Static Analysis (Gradle lint) for Code standard
        - Composition over Inheritance (why prefering Kotlin)
        - Manually fine tune (like !!)
        - Activity and Fragment -> Too many activities; Activity Init modes -> All the activity is default mode
        - Tools: LeakCanary
        - 

     4. Automation: 

        - Automated tests with gradle and Jenkins
        - Automated build with Jenkins
        - Automated Beta distribution
        - Performance profiling

     5. Security

        - Server side: SSL
        - Client side: Dynamic and Static, rooted?
        - Analysis tools: QARK, Frida
        - Componentized with AOP (Spring)
        - minifyEnabled and ProGuard

     6. Dynamic patch 

     7. Offline vs Online

        - Remote persistent
        - Local Persistent
        - AnemicDomainModel: Case by case, domain object related -> Item (Why not as Trait and Mixin), domain object irrelated -> ItemManager; decouple the orm; why there should have a service level? -> sometimes we just update the item in memory aq8nd want to revert it, not update the persistent layer every time.

           - Item/Entity
           - ItemLocalDao, ItemDaoLocalImpl, ItemRemoteDao, ItemDaoRemoteImpl: REST / or Traits -> ItemLocalTrait/ItemRemoteTrait
           - ViewPresenter (Service layers): Aysnc or sync -> the logic between remote and local

     8. AB testing      

   - Tech Diagrams: 

     1. layers in architecture

   - Implementation plans and priority     

   - Future projects

     1. Android Wear
     2. Android Pad
     3. Android Auto
     4. Android things
     5. Android TV

   - Workflow for developers
   
     1. Tickets and git issues (dev team internal and external communication)

     2. github sync flow ??? really need to be like this? (external <-> intermediate <-> internal)  


   - Ownership and responsibility
   
     1. Incentive plan?

     2. Module ownership and responsibility

     3. Career path?  

2. Secrets

Email: peakhktest@gmail.com
Password: Test@1234     



