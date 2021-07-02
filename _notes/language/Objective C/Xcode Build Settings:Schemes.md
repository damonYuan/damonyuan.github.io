Xcode Build Settings/Schemes
============================

1. How to change the bundle identifier
   1. Select your target
   2. Select 'info' tab (you can do the same by finding the plist file on the project)
   3. Search for "Bundle Identifier" key, The value on your end should be com.mycompany.${PRODUCT_NAME:rfc1034identifier}.
   If you want to change the grey field just replace the "com.mycompany" with whatever you want. the other field is the "Product Name" (which is read dynamically from the relevant key), You can change it by set the "Product Name" key on "Build Settings". You can also do it pretty ugly and change all the bundle identifier to whatever you want but I don't recommend that because if you would add more targets it would be static and harder to maintain.

2. toolchains/xcodedefault.xctoolchain/usr/bin/clang after change project name
   using textEdit to open .xcodeproj file

   $ cd MyProjectDir
   $ find . -type f -exec grep -i OldProjectName {} \; -ls
   to find the file that contain the OldProjectName

3. #import <XCTest/XCTest.h> not found
   se separate .xcconfig files (App-Debug.xcconfig and App-Production.xcconfig) to define the: LIBRARY_SEARCH_PATHS, HEADER_SEARCH_PATHS & OTHER_LDFLAGS for each target.

4. How to set TEST_HOST

5. Already add <Fabric/Fabric.h> (framework) but cannot find it
   First, you have to remove your FacebookSDK.framework from your Project. Then start over again with these 5 steps. DO NOT re-link the framework.

   1. Go to Build Phases in your Project Target.
   2. In Link Binary With Libraries, click the "+" button.
   3. Click on "Add Other..." button
   4. Browse your FacebookSDK folder. Generally in ~/Documents/FacebookSDK/
   5. Clik on (select) "facebookSDK.framework" and then OPEN.
   
   Framework Search Path : $(PROJECT_DIR) and recursive

6. Validate Build Product
   Checking something that might be rejected by apple. This is definitely an option worth turning on for distribution builds.

7. Code Signing
   Code signing your app assures users that it is from a known source and the app hasn’t been modified since it was last signed. Before your Mac app or iOS app can be used with store services, installed on an iOS device for development or testing, or submitted to the App Store, it must be signed with a certificate issued by Apple.

   https://developer.apple.com/library/mac/documentation/Miscellaneous/Reference/EntitlementKeyReference/Chapters/AboutEntitlements.html

   ????

8. Provisioning Profile
   ????

9. Deployment Postprocessing

10. pch file missing in xcode 6
    http://stackoverflow.com/questions/25840720/xcode-6-pch-file-not-found

11. Other linker Flags
    IMPORTANT: For 64-bit and iPhone OS applications, there is a linker bug that prevents -ObjC from loading objects files from static libraries that contain only categories and no classes. The workaround is to use the -all_load or -force_load flags. -all_load forces the linker to load all object files from every archive it sees, even those without Objective-C code. -force_load is available in Xcode 3.2 and later. It allows finer grain control of archive loading. Each -force_load option must be followed by a path to an archive, and every object file in that archive will be loaded.

12. target?
    add more than one target?

13. Version and Build in General; Bundle version and Bundle versions string in Info
    1. Version: This is the version number for iTunes Connect which is shown in the App Store; This must be a pure version number like 1.2.3
    2. Bundle Version (CFBundleVersion)
     the CFBundleVersion has to be a pure version number like 1.2.3 when you want to upload your application to the (iOS) App Store.
    3. Bundle Version String (CFBundleShortVersionString) This value is used as the real version number. This must be the same string as used for the version in iTunes Connect.

    Usage mode 1 - Only CFBundleVersion is set

      Bundle Version (CFBundleVersion)
      Must be a version number, e.g. 1.0. Must match the iTunes Connect Version.

    Usage mode 2 - Both CFBundleVersion and CFBundleShortVersionString are set

      Bundle Version (CFBundleVersion)
      Must be a build number, e.g. a single integer like 435163.

      Bundle Short Version String (CFBundleShortVersionString)
      Must be a version number, e.g. 1.0. Must match the iTunes Connect Version.

14. error
xcode 6 pch.file not found: 
Apple LLVM 6.0 Language
  Increase Sharing of Precompiled Headers
  Precompile Prefix Header
  Prefix Header

15. KIF
    Lib that should add into KIF:
    UIKit
    SenTestingKit
    Foundation
    CoreGraphics
    KIF.a

16. pods builds error 
    1. Select the Pods project
    2. Change Build Active Architecture Only from Yes to No.

17. product name should be the same as Bundle display name and bundle name in ${PRODUCT_NAME}, better not to have whitespace

18. Note the Excutable name should be right. Especially for Testing => Test Host

19. improve build speeed
    1. forbid dSYM for debug
    2. Optimization Level use none for debug.

20. Environment
    1. dev -> local server debug, archive dev.
    2. alpha -> remote alpha server debug, archive alpha.
    3. Beta -> remote beta server debug, archive beta.
    4. production -> remote production server debug, archive production. // TODO

21. Manually add a project to current project
    Manual installation:
    1. git submodule add git@github.com:CocoaLumberjack/CocoaLumberjack.git
    2. Drag CocoaLumberjack/Framework/{Desktop/Mobile}/Lumberjack.xcodeproj into your project
    3. In your App target Build Settings,Add to 'User Header Search Paths' $(BUILD_ROOT)/../IntermediateBuildFilesPath/UninstalledProducts/include'
    4. Set 'Always Search User Paths' to YES
    5. In your App target Build Phases
       Add CocoaLumberjack static library target to 'Target Dependencies'
       Add libCocoaLumberjack.a to 'Link Binary With Libraries'
    6. Include the framework in your source files with
       #import <CocoaLumberjack/CocoaLumberjack.h>

22. 首先开启调试模式、打印出所有运行时发送的消息： 可以在代码里执行下面的方法：
    (void)instrumentObjcMessageSends(YES);
    或者断点暂停程序运行，并在 gdb 中输入下面的命令：
    call (void)instrumentObjcMessageSends(YES)
    之后，运行时发送的所有消息都会打印到/tmp/msgSend-xxxx文件里了。

23. https://github.com/ChenYilong

24. https://github.com/ChenYilong/iOS9AdaptationTips

25. How to determin if a remote server support TLS 1.2 
    $ brew upgrade openssl
    $ openssl s_client -connect google.com:443 -tls1_2

26. CI with hockeyapp: http://www.metaltoad.com/blog/continuous-delivery-for-enterprise-on-ios
    remember to install puck in hockeyapp > preference > Helper
    VERY USEFUL!!!
    http://faq.sealedabstract.com/xcodeCI/
    http://www.swwritings.com/post/2013-11-25-xcode-bots-build-numbers-and-git/
    http://madebymany.com/blog/continuous-integration-for-ios-development

27. When creating/editing a bot, take note of the Clean setting. This setting also removes all source code, so if it's set to "Always" you will be pulling the entire repo every time.
    Setting it to Never or Once per week will mean you only pull what's not already on the machine.

28. /Users/Damon/Library/Developer/CoreSimulator/Devices






