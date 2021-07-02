Linux_Record
==============

Linux_Record

# Bash Command (shell)
  1. / is  the root
  2. ~ is /Users/bindo
  3. OS X termianl : Damon-Macbook-Pro:/ Damon$
     The first is Hostname, in sharing and can be set in terminal
     The second is Account Name, should be the same as root folder.
  4. cd .. : upper folder
  5. cd ./xxx :relative to current folder. (In almost all cases, you can omit the ./ because it is implied.)
  6. cd - : changes the working directory to the previous working directory
     cd   : changes the working directory to your home directory
     cd ~username : changes the working directory to the home directory of username.
  7. Filenames that begin with a period character (.) are hidden. ls -a to show them.
  8. .bash_profile : read and the commands in it executed by Bash every time you log in to the system
     .bashrc       : read and executed by Bash every time you start a subshell
     .bash_logout  : read and executed by Bash every time a login shell exits
     http://www.hypexr.org/bash_tutorial.php

# Public Key and Private Key (SSH)
  0. verify the SSH client is available:
     $ ssh -v
  1. check for existing SSH keys on your computer
     $ ls -al ~/.ssh
  2. generate a new key pair
     $ ssh-keygen -t rsa -C "your_email@example.com"
  3. Then add your new key to the ssh-agent:
     $ eval "$(ssh-agent -s)"
     $ ssh-add ~/.ssh/id_rsa
  4. add public key to pasteboard
     $ pbcopy < ~/.ssh/id_rsa.pub
  5. test
     $ ssh -T git@github.com

  6. check public-key fingerprint -> $ ssh-keygen -lf ~/.ssh/id_rsa.pub (l -> list f -> filename)
  7. simply want the public key   -> $ cat ~/.ssh/id_rsa.pub

# $ echo command in Linux
  echo is a built-in command in the bash and C shells that writes its arguments to standard output.
      echo [option(s)] [string(s)]
     
＃ delete a file
   
   $ rm <File Name>
   
   or

   $ rm -df <File or Directory Name>

# copy a file
  $ cp file_directory/file_name new_file_firectory/new_file_name

# $ rake geoip:download
  This command use wget, 
  $ brew install wget

# Open Sublime2 in terminal
  $ ln -s /Applications/Sublime\ Text\ 2.app/Contents/SharedSupport/bin/subl /usr/local/bin/subl

# ssh
  $ ssh-add -l (show all the added key)
  $ ls -al ~/.ssh (show all the key pair generated)
  $ pbcopy < ~/.ssh/github_rsa.pub (copy to pasteboard)
  $ ssh-add ~/.ssh/github_rsa

#using homebrew to update git
  $ git --version
  $ brew doctor
  $ brew update
  $ brew upgrade git
  $ git --version

# $ tail -f log/development.log
  the tail command reads the final few lines of any text given to it as an input and writes them to standard output
  -f : file

# kill a already in use port
  $ lsof -wni tcp:3000
  $ kill -9 PID

# cat command
  The cat program is a standard Unix utility that will output the contents of a specific file and can be used to concatenate and list files. The name is an abbreviation of catenate, a synonym of concatenate.

# start redis server
  use os x's launchctl command 
  1. first setup redis as a service managed by launchctl
     $ ln -sfv /usr/local/opt/redis/*.plist ~/Library/LaunchAgents
  2. Start/Stop
     $ # start redis server
     $ launchctl load ~/Library/LaunchAgents/homebrew.mxcl.redis.plist
     $ # stop redis server
     $ launchctl unload ~/Library/LaunchAgents/homebrew.mxcl.redis.plist
  3. connect to redis
     $ redis-cli
     $ redis-cli shutdown
     $ redis-cli monitor
  4. check redis latency
     $ redis-cli --latency-history localhost

# homebrew
  1. Never run brew as sudo. Not "sudo brew install" nor "sudo brew link".
  2. The "Cellar" is a place that all your "kegs". Homebrew installs packages to their own directory (in the Cellar) and then symlinks their files into /usr/local/.
  3. Change /usr/local/* to be owned by $USER, not root, so you can have write permissions and not need sudo.
  4. The $PATH entry for /usr/local/bin should occur before /usr/bin.

# create dir and file
  $ mkdir /public/create 
  $ touch /public/create/create.js 

# open file in sublime in terminal
  $ ln -s "/Applications/Sublime Text.app/Contents/SharedSupport/bin/subl" /usr/local/bin/sublime

# Warning: Getting “Warning! PATH is not properly set up” when doing rvm use 2.0.0 --default
  The answer was to put this:
  [[ -s "$HOME/.rvm/scripts/rvm" ]] && source "$HOME/.rvm/scripts/rvm" 
  **at the BOTTOM** (last line - important!) of my .bashrc file. I had it in my .bash_profile file (I am on Ubuntu) and that only partially worked leading to the confusing errors.

  And do not source .profile at the beginning of the .bash_profile. : http://stackoverflow.com/questions/18317549/why-do-i-get-a-path-error-when-sourcing-rvm

# Linux about ENV : http://www.peachpit.com/articles/article.aspx?p=31442&seqNum=3
  1. to see all your environment variable
     $ Env 
  2. To temporarily change or create an environment variable in tcsh (or csh):
     $ setenv VISUAL vi
     $ echo VISUAL 
     NOTE: If the value contains spaces, make sure to enclose it in quotes; ToC reset (or unset, in Unix terminology) an environment variable, simply leave off the value; 
  3. To make a durable change to an environment variable in the tcsh shell: (NOT FOR MAC)
     1. Edit your ~/.tcshrc file (or type ~/.cshrc for the csh shell).

     2. Add this line to the end of the file:
        setenv ORGANIZATION "Tony's Pizza"
     
     3. Save the file.

     4. Quit the editor.
        The change will take effect with the next shell you start.

     5. Open a new Terminal window. Test that the variable is set:
        $ echo $ORGANIZATION 

     Note: $ echo setenv ORGANIZATION \"Tony\'s &rarr;Pizza\" >> ~/.tcshrc
           Make sure to use >> and not a single > character. If you use only >, you will wipe out the current contents of your .tcshrc file.
  4. To change or create an environment variable in bash (or sh):
     1. export VISUAL=vi

#  monitor the log: 
   $ tail -f log/test.log
   $stderr.puts last_response

#  $ telnet> toggle options 
   $ telnet> toggle termdata /* hex data */
   
   http://www.in-ulm.de/~mascheck/various/ascii-tty/
   ^@ -> 0x00
   ^A -> 0x01
   ^V -> ^V ^V (22)

# terminal 
Press Control-A to jump to the start of the path and type: "cd " (note that there is a space after the “cd”).
$ find . -type d : search current directory and type is directory

# Mac OS X Directory Structure explained
  1. From the top: The Computer folder 
     choose Go -> Computer or press Shift+Command+C 

  2. Applications folder : In this folder, you find applications and utilities that Apple includes with OS X.
     Library folder : 1. Public library folder 2. System library folder. 3. User xxx library folder 
     If your Mac is setup for multiple users, only users with administrator (admin) privileges can put stauff in the public(root-level) Library folder 

  3. The System folder -> levae the System folder alone, it contains the files that OS X needs to start up and keep working. 

  4. When you open the Users folder, you see a folder for each person who has a user account on the Mac, as well as the shared folder.
     The Shared folder that you see inside the User folder allows everyone who uses the Mac to use any files store there. If you want other people who use your Mac to have access to a file folder, the Shared folder is the proper place to stash it.

  Hidden Folders:
  1. /Network, this folder relates to domain control or LDAP(Lightweight Directory Access Protocol) directory services(Open Directory or Active Directory. Those can be enabled to distribute directory over Internet Protocol. If those environment are not in use directories most likely be empty.
  2. /Volumes, Default location for mounting all media attached to mac. In most cases mounts will be done dynamically upon connection/disconnection of any device. This folder is equivalent to linux/mnt or /media folder.
  3. /bin, it is directory for all essential common binaries. Those files and programs are responsible for booting(starting) and running the operation system.
  4. /cores, Directory dumps of programs upon crash along with the state at the time it crashed. /Core is useful folder for programmers debugging their programs.
  5. /etc, This directory is a symbolic link to `etc -> private/etc` that stores local system configuration, administrative files and scrips.
  6. /home, On OS X this directory remains empty.
  7. /private, private folder holds entire OS X unix core.Many root level folders are just symlinks to private subfolders. eg: etc -> private/etc.
  8. /sbin, stands for "System(or Superuser) Binaries" and contains main system utilities, such ifconfig, mount, halt, etc.Those are fundamental to both-single and multi-user environments and required to start, maintain and recover the system.
  9. /temp, this directory is a symbolic link to tmp -> private/tmp that contains all system temporary files taht will be removed after system restart.
  10. /usr, second major hierachy, includes subdirectories that contain information, configuration files and other essential used by the operating system.
      /usr/local heirarchy is for use by the sytem administrator when installing software locally.
  11. /var, this directory is a symbolic link to var -> private/var that stores multi-purpose log, temporary, transient and spool files.     


  # $ grep 

  # $ chown -R root /data/db

  # $ find

# Linux File Systems: Ext2 vs Ext3 vs Ext4
  http://www.thegeekstuff.com/2011/05/ext2-ext3-ext4/

# Linux process
  https://www.ibm.com/developerworks/community/blogs/58e72888-6340-46ac-b488-d31aa4058e9c/entry/an_overview_of_linux_processes21?lang=en

# Linux system folders' definition:
  http://linuxcommand.org/lc3_lts0040.php

# check port info
  $ netstat -p tcp | grep $PORT

# change owner of symlinks
  $ chown -h myuser:mygroup mysymbolic

# add repo 
  $ sudo add-apt-repository ppa:ondrej/php
  $ sudo apt-get update

  RUN apt-get -y update \
    && apt-get install -y software-properties-common \
    && LC_ALL=C.UTF-8 add-apt-repository -y ppa:ondrej/php5-5.6 \

# block ip : https://www.cyberciti.biz/faq/how-do-i-block-an-ip-on-my-linux-server/
$ iptables -A INPUT -s IP-ADDRESS -j DROP
eg. # iptables -A INPUT -s 65.55.44.100 -j DROP

# 把默认用户加入docker组，免得每次都敲sudo
sudo usermod -aG docker ubuntu

# SSH aborts with Too many authentication failures
https://serverfault.com/questions/580753/ssh-aborts-with-too-many-authentication-failures

# grep network package command : ngrep

wget https://unbeagleyyo.files.wordpress.com/2011/04/ngrep.pdf
mv ngrep.pdf ngrep
adb push ngrep /data/local/tmp/
adb shell
> cd /data/local/tmp/
> chmod 777 ngrep
> ./ngrep 用法就先看http://man.linuxde.net/ngrep，例如 ngrep -W byline -d eth0 port 80

# If you are running this tutorial in a cloud environment like AWS, Azure, Digital Ocean, or GCE you will not have direct access to localhost or 127.0.0.1 via a browser. A work around for this is to leverage ssh port forwarding. Below is an example for Mac OS. Similarly this can be done for Windows and Putty users.

$ ssh -L 5000:localhost:5000 <ssh-user>@<CLOUD_INSTANCE_IP_ADDRESS>


# mount remote partition







 


