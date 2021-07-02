Raspberry_Pi_Record
==============

Raspberry_Pi_Record

# installation of WIFI and Bluetooth

1. wifi module is already included in raspbian system
   But if you want the system to connect to the network automatically, you should config it through command.

2. For Bluetooth
   1. sudo apt-get update
   2. sudo apt-get upgrade
   3. sudo apt-get autoremove // This will then remove all of the redundant packages after the latest upgrade
   4. sudo apt-get install bluetooth bluez-utils blueman

   note: not to run the command with wifi module. Using LAN Cable

3. Run command:
   sudo bluez-simple-agent hci0 <MAC>

   If you get a error message: 'Creating device failed: org.bluez.Error.AuthenticationRejected: Authentication Rejected'

   You will have to make a slight modification to the bluez-simple-agent file, type in the following:

   sudo nano /usr/bin/bluez-simple-agent

   This will open the nano command line text editor. There is one occurrence of ‘KeyboardDisplay’ you need to replace this with ‘DisplayYesNo’, close the editor with ctrl-x this will close nano and ask you to save the file press y when prompted

# Configuration of Raspberry Pi

   1. This Oracle link tells many things about Raspberry Pi:
     http://www.oracle.com/technetwork/articles/java/raspberrypi-1704896.html#Java

   # Error: can't load IA 32-bit .so on a ARM-bit platform

   1. Anything that's a *.so file is a shared object executable program library. The only way something like that will run on you RPi is if you(or someone else) has built it from source for the armv6 with hard float.

   You can NOT take a version from a X86 or X86_64 system and expect it to run on a RPi(arm system), the processor architecture is entirely different.

   2. Check if the library is appropriate to the Pi, try:
    
      file <dir of the file>

   3. set the Raspberry Pi to full screen
      $ nano /boot/config.txt
      and set the last lines of this file.
     

