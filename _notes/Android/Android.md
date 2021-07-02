Android
==============

Android

1. Error 
   emulator: ERROR: x86 emulation currently requires hardware acceleration!
   Please ensure Intel HAXM is properly installed and usable.

   If you are on a mac you can install haxm using homebrew via cask which is an extension that allows installing non-open-source and desktop apps (i.e. chrome, firefox, eclipse, etc.):

   $ brew install caskroom/cask/brew-cask && brew update
   $ brew cask install intel-haxm 

2. run gradlew tasks to see all the tasks that you can run.
   1. navigate to project directory
   2. ./gradlew tasks 

3. Android project -> Gradle to build -> APK -> Jar Signer to sign -> Android Debug Bridge(ADB)

4. settings -> about phone -> build number and tap on it 7 times 

5. build in terminal: 
   1. $ chmod +x gradlew -> it grants execution permission to the gradlw rappers script 
   2. $ ./gradlw assembleDebug
   3. it creates an APK file at the app/build/apk 
   4. $ adb install -r app/build/apk/app-debug-unaligned.apk
      The -r represent that you can replace an exsiting version of the app if you've already done it before.
   5. $ adb shell am start -n com.example.android.sunshine.app/com.example.android.sunshine.app.MainActivity
      This command will actually run the app 

6. Fragment -> UI layout resource.

7. LinearLayout: Perfect for stacking the views vertically or horizontally, one after another. It si also the only way to break up the display proportionately.
   RelativeLayout: 
   GridLayout(FrameLayout): Frame layout is great for simple layouts when you only have one child to view.  

8. R is a class containing the definitions for all resources of a particular application package. It is in the namespace of the application package.
   This is an auto-generated utility class that provides perferences to the resources in the project.

9. In Java, only nested class can be static 
   1. Nested static class doesn't need reference of Outer class, but Non-static nested class or inner class requires Outer class reference.
   2. Inner class(or non-static nested class) can access both static and non-static membersof Ourter class.
      A static class cannot access non-static members of the Outer class. It can access only static members of Outer class.
   3. An instance of Inner class cannot be created without an instance of outer class and an Inner class can reference data and methods defined in Outer calss in which it nests, so we don't need to pass reference of anobject to the constructor of the inter class. For this reason inner classes can make program simple and concise.

   Static -> belong to the class 

   public final static String NAME = "I am a static variable"; -> make a constant. 

10. HTTP requests on Android 
    1. HttpUrlConnection
    2. HttpClient

11. in terminal, you can type 
    $ adb logcat
    to see the debug and error messages that are being printed to the logcat.
    Link: adb logcat -> http://developer.android.com/tools/help/adb.html?utm_source=udacity&utm_medium=mooc&utm_term=android&utm_content=adb&utm_campaign=training

12. enable auto-import
    To enable auto-import, go to Android Studio > Preferences > Editor > Auto Import. Check all the boxes and insert all imports on paste.

13. Generic: "public class Box<T>" this introduces the type variable, T, that can be used anywhere inside the class.

14. Difference between Array and ArrayList:
    1. Main difference between Array vs ArrayList in Java is static nature of Array and dynamic nature of ArrayList. Once created you cannot change size of Array but ArrayList can re-size itself when needed. 
    2. Another notable difference between ArrayList and Array is that Array is part of core Java programming and has special syntax and semantics support in Java, while ArrayList is part of Collection framework along with other popular classes.
    3. You cannot use Generic along with Array, as Array instance knows about what kind of type it can hold and throws ArrayStoreException. ArrayList allow you to use Generics to ensure type-safty.
    4. length in Array; size() in ArrayList
    5. You cannot store primitives in ArrayList 
    6. add() to insert elements in ArrayList
    7. It is mandatory to provide the size of Array while creating either directly or indirectly by initializing Array while creating it.

15. android.support.v4.app.Fragment is the Fragment class in the android support library, which is a compatibility package that allows you to use some of the newer features of Android on older versions of Android. 
android.app.fragment is the Fragment class in the native version of the Android SDK. It was introduced in Android 3(API 11).

If you want to make your app use fragments and want to target devices before API 11, you must use android.support.v4.app.fragment. However, if you're only trageting devices running API 11 or above, you can use android.app.Fragment.

16. onCreate() happens when fragment is created before onCreateView() is called.

17. R is a class containing the definitions for all resources of a particular application package. It is in the namespace of application package.

18. inner class in Java
    * non-static nested class
    1. to compartmentalize functionality.
    2. have access to the protected/private field and methods available within the user class.
    3. The compiler treats inner classes just like any other classes, except that the inner classes have a limited scopt, and therefore tethered to be the class they are defined with. You would not be able to use or instantiate the inner classes except with an instance of the outer class, but the inner classes could access any fileds or methods available in the outer class as needed.

    * static nested class 
    1. A static inner class defines behavior that is not tied to a specific object instance, but applies across all instance. 
    2. The outer class does not have to be instantiated to perform this instantiation, thus the use of the class name. As such, a static nested class, unlike a non-static nested class, does not have access to members of the outer class - they are not even instantiated.

    * Anonymous inner class 
    1. Begin with the new keyword, followed by the class or interface you wish to extend or implement, followed by the class definitions

    Nested Class: a class defined inside another class.
    Static nested class: a static class defined inside another class.
    Inner class: a non-static nested class defined inside another class.
    Local Inner class: a class defined within a method 
    Anonymous Inner class: an unnamed class defined within a method 

    http://code.tutsplus.com/tutorials/learn-java-for-android-development-inner-classes--mobile-3530

19. activities can only be done after declaring a uses-permission in the manifest: Getting the user's current location.
    declaring a commission is required for using a camera, making a phone call, or accessing contact details, you can do each of the things using a system app as the intermediator. Run time ability to allow it. 


20. first time run apk in device: 
    1. adb push apk to sdcard /mnt/sdcard/
       http://log.amitshah.net/2012/05/using-adb-to-copy-files-to-from-your-android-device/
    2. $ adb shell,  the original file is in 
       /system/priv-app/  -> system app 
       
       Note:
       You can probably find most of them in:
       /data/app
       System apps will be in:
       /system/app 
    3. special : to get the root access ??? 
       $ tinklabs1001 
    4. $ mount -o remount,rw /mnt/sdcard 
    5. $ cp /mnt/sdcard/app-launcher-debug.apk /system/priv-app/app-launcher.apk 

21. $ adb shell to enter the shell of cellphone

22. ~/.bash_profile
    export ANDROID_HOME=/Users/Damon/Library/Android/sdk
    export PATH="$ANDROID_HOME/platform-tools:$ANDROID_HOME/tools:$PATH"

23. For some reason:
    Gradle build cannot find some files: build with the following steps
    1. 23
    1. "Google Inc.:Google APIs:23"

24. cannot enable GPS programatically
    http://stackoverflow.com/questions/22528984/android-device-gps-on-off-programatically/22529084#22529084

25. an (non-static) inner class cannot be instantiated by Android via the AndroidManifest.xml. You must dynamically register it, as shown in the link above.

26. show the package location: 
    $ pm list packages -f | grep “com.jrd.onetouchbackup”

27. test the deep link 
    $ adb shell am start
        -W -a android.intent.action.VIEW
        -d <URI> <PACKAGE>

    $ adb shell am start
        -W -a android.intent.action.VIEW
        -d "example://gizmos" com.example.android

28. logcat 
    adb logcat *:I 
    adb logcat -d > logcat.txt 
    adb logcat > logcat.txt 
    adb logcat -f > mnt/sdcard/logcat.txt

29. adb shell dumpsys package my.package | grep versionName
30. am start -n yourpackagename/.activityname
31. pm list packages -f
32. SELinux set permissive:
    $ setenforce 0
33. check permission:
    $ cat /system/etc/security/mac_permissions.xml can check seinfo and signer
    $ dmesg | grep avc ?????? TODO:

34. Android dump meminfo
    $ adb shell dumpsys meminfo .activation_ota -d
    $ dumpsys meminfo 5025 -d

35. Android grep pid 
    $ ps | grep .activation_ota | awk '{print $2}'

36. Android test apk url links
    $ adb shell am start -a android.intent.action.VIEW -d "example://gizmos" com.myapp

37. popup window
```
PopupWindow popupwindow_obj; // create object

popupwindow_obj=popupDisplay();  // initialize in onCreate()

popupwindow_obj.showAsDropDown(clickbtn,-40, 18); // where u want show on view click event

public PopupWindow popupDisplay() { // disply designing your popoup window
    final PopupWindow popupWindow = new PopupWindow(this); // inflet your layout or diynamic add view

    View view; 

    LayoutInflater inflater = (LayoutInflater)   getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE); 

    view = inflater.inflate(R.layout.mylayout, null);

    Button item = (LinearLayout) view.findViewById(R.id.button1);

    popupWindow.setFocusable(true);
    popupWindow.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
    popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
    popupWindow.setContentView(view);

    return popupWindow;
}
```
```
<LinearLayout
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal" >

        <Button
            android:id="@+id/button1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Window test" />
</LinearLayout>
```

38. adb shell dumpsys netstats detail

19. android device id: adb shell settings get secure android_id
    android imei: 
    
20. *#*#4636#*#*

enter testing mode

21. SSL Pinning (https://medium.com/@appmattus/android-security-ssl-pinning-1db8acb6621e)

    1. ARP Cache Poisoning (https://www.thegeekstuff.com/2012/01/arp-cache-poisoning/)

       - Denial of Service
       - Man in Middle
       - MAC Flooding

    2. Internet Protocol (http://www.ruanyifeng.com/blog/2012/05/internet_protocol_suite_part_i.html)

    3. DNS spoofing (https://en.wikipedia.org/wiki/DNS_spoofing)

    4. You don’t have to pin against just one certificate in the chain. Indeed, the general recommendation is to pin against multiple levels to decrease the chances of bricking your app at the expense of trusting more certificate issuers. In my mind it would seem prudent to pin at the intermediate and leaf levels to give a sensible balance.

    5. pinning: (https://developer.android.com/training/articles/security-ssl#Pinning)

       - Unknown certificate authority
       - Self-signed server certificate
       - However, operating systems like Android typically trust only root CAs directly, which leaves a short gap of trust between the server certificate—signed by the intermediate CA—and the certificate verifier, which knows the root CA. To solve this, the server doesn't send the client only it's certificate during the SSL handshake, but a chain of certificates from the server CA through any intermediates necessary to reach a trusted root CA. However, it is not uncommon to configure a server to not include the necessary intermediate CA. For example, here is a server that can cause an error in Android browsers and exceptions in Android apps
       - They do this so the root CA can be stored offline to reduce risk of compromise.
       - two parts:

         1. The first is to verify the certificate is from a trusted source, which was the focus of the previous section. (CA or certificate file by TrustManager)

         2. making sure the server you are talking to presents the right certificate. (subject and subject alternative names); TLS over SSL on Server Name Indication (SNI), which allows the SSL client to specify the intended hostname to the server so the proper certificate can be returned.

      - Virtual Host

        1. > 2.3 : SNI
        2. < 2.2 : setup an alternative virtual host on a unique port so that it's unambiguous which server by default.
        3. drastic alternative : replace HostnameVerifier with one that uses not the hostname of your virtual host, but the one returned by the server by default.

      - SSLSocket

        1. The techniques described so far to deal with certificate verification issues also apply to SSLSocket. In fact, when using a custom TrustManager, what is passed to HttpsURLConnection is an SSLSocketFactory. So if you need to use a custom TrustManager with an SSLSocket, follow the same steps and use that SSLSocketFactory to create your SSLSocket.
        2. Caution: SSLSocket does not perform hostname verification. It is up to your app to do its own hostname verification, preferably by calling getDefaultHostnameVerifier() with the expected hostname. Further beware that HostnameVerifier.verify() doesn't throw an exception on error but instead returns a boolean result that you must explicitly check.

      - While this list was historically built into the operating system, starting in Android 4.2 this list can be remotely updated to deal with future compromises.
     
      - This article has focused on the user of SSL to secure communications with servers. SSL also supports the notion of client certificates that allow the server to validate the identity of a client. (Security in Server side)      

      - Nogotofail: A network traffic security testing tool

        1. Finding bugs and vulnerabilities.
        2. Verifying fixes and watching for regressions.
        3. Understanding what applications and devices are generating what traffic.
    
    6. Okhttp with pinning certificate


22. Accessibility (TODO)

23. Kotlin inline function (TODO)
    
    > https://medium.com/@dbottillo/kotlin-by-examples-methods-and-lambdas-25aef7544365

24. Security (TODO)





























































