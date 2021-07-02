Effective Objective-C
=====================

# Chapter 1: 
Item 2: 
1. always import headers at the very deepest point possible. This usually means forward declaring classes in a header and importing their corresponding headers in an implementation.
2. consider moving the protocol-conformance declaration to the class-continuation category if possible.

Item 3:
1. Since NSArray, NSDictionary and NSNumber are class cluster, they are rarely subclassed.
2. for literal syntax, if a mutable variant is required, a mutable copy must be taken.

Item 4:

Item 5: 
1. Use the NS_ENUM and NS_OPTIONS macros to define enumeration types with an explicit type.
   Doing so means that the type is guaranteed to be the one chosen rather than a type chosen by the compiler.
   You should always use NS_OPTIONS if you are going to be ORing together the enumeration values. If not, you should use NS_ENUM.
2. When used for switching on an enumeration that defines a state machine, it is best not to have a default entry.
   The reason is that if you add a state later on, the compiler will helpfully warn that the newly added state has not been cared for in the switch statement. A default block handles the new state, so the compiler won't warn.

Item 6: 
