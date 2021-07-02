Apache
======

1. Mac allow apache access home folder
   http://stackoverflow.com/questions/6079783/how-do-i-give-apache-access-to-folders-on-mac-osx

   http://stackoverflow.com/questions/24583859/apache-localhost-username-not-working

   https://www.computersnyou.com/3376/setup-apache-php-mysql-macosx-10-10-yosemite/

   IMPORTANT!: not work because of authorization.....

2. using XAMPP

   finally this configuration works:
   http://jonathannicol.com/blog/2012/03/11/configuring-virtualhosts-in-xampp-on-mac

   1. change the localhost in your system: /etc/hosts
   2. Enable virtual host module in apache: #Include /Applications/XAMPP/etc/extra/httpd-vhosts.conf
   3. Create virtual host in: /Applications/XAMPP/xamppfiles/etc/extra/httpd-vhosts.conf
   4. /Applications/XAMPP/xamppfiles/etc/httpd.conf to solve 403 error: 
      # User/Group: The name (or #number) of the user/group to run httpd as.

   
   solve the conflict of brew mysql server:
   http://silentlyrun.blogspot.com.au/2013/02/how-to-change-apache-n-mysql-port-for.html

3. switch php to homebrew version
   http://evertpot.com/switching-to-php-54-on-os-x/

4. Apache for magento:

   1. create .htaccess file in htdocs folder. 
   2. #LoadModule rewrite_module modules/mod_rewrite.so should be uncommented.

5. Apache to redirect traffic to different port 

in httpd-vhosts.conf:

Listen 34567
<VirtualHost *:34567>
    ServerName localhost
    Redirect / http://api3s.handy.local:80/
</VirtualHost>

or in httpd.conf to enable listen to different port: 
Listen 34567

6. DocumentRoot in Apache:
   1. httpd.conf
   2. httpd-vhosts.conf

7. somethimes need to use 
    $ apachectl -k restart

8. setup php with local server and xdebug(not xampp)
   http://stackoverflow.com/questions/9183179/phpstorm-xdebug-setup-walkthrough

9. service
   1. sudo launchctl load -w /System/Library/LaunchDaemons/org.apache.httpd.plist
   2. sudo launchctl unload -w /System/Library/LaunchDaemons/org.apache.httpd.plist 2>/dev/null

10. remember to set the User and Group in apache to prevent the permission error
11. install Apache in OSX
    https://jason.pureconcepts.net/2016/09/update-apache-php-mysql-mac-os-x-sierra/