Xcode_Record
==============

Xcode_Record

# shortcuts

1. Cmd-Opt-Shift-K: deep clean
2. Opt-Cmd-click display definition

# Third Party Tools

1. fauxpas - check potential fault
2. Mixpenal - Track user action
3. HockeyApp and TestFlight

# Note

1. Build problems
   1. Build Settings -> Build Active Architecture Only -> should be NO
   2. Build Phases -> Compile Sources -> check if all the .m files are included
   3. Check if the .h files are included
   4. Check if the pods project settings are right

2. location of db
   Macintosh HD ▸ Users ▸ Damon ▸ Library ▸ Developer ▸ CoreSimulator ▸ Devices ▸ F06FD8C5-330F-42F2-AEE9-82FF95D92EE5 ▸ data ▸ Containers ▸ Data ▸ Application ▸ 07ED1B27-A393-43EA-90EB-461F99310C00 

# Distribute through Hockeyapp
  1. UDIDs always need to be added the provisioning profile if it is a non enterprise profile.
  2. OTA distribution using team provisioning profiles is not guaranteed to work by Apple. OTA distribution is defined to be used with Ad-Hoc profiles.
  3. You can update the same profile that was used to sign the app and add more UDIDs and then simply upload that updated profile to HockeyApp. New users then can install the updated profile first before installing the app.
  4. We do support enterprise provisioning profiles, but Apple only allows those profiles to be used for employees of the same company that owns the profile certificate.

# $ xcode-select 
  to check if a valid xcode version is selected.
  $ sudo xcodebuild -license
  to accept the license 





