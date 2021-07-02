# AWS
=====

1. VPC
normally create 2 VPC: staging and production. and for an region the VPC limit is 5.

2. PHP
OpenCart AMI: 
https://aws.amazon.com/marketplace/pp/B00SIBMCUE/ref=srh_res_product_title?ie=UTF8&sr=0-2&qid=1422964022936&tag=vig-20

3. deploy sinatra on Nginx on Ubuntu on Passenger
   http://grosser.it/2010/03/26/sinatra-on-nginx-on-ubuntu-on-passenger/
   http://www.philipholly.com/post/28410140237/sinatra-on-webfaction-glad-it-turned-out-to-be

   Note the server_name: 
   ec2-54-169-32-17.ap-southeast-1.compute.amazonaws.com

   If you do not see your app's front page HTML, then these are the most likely causes:

   You did not correctly configure your server_name directive. The server_name must exactly match the host name in the URL. For example, if you use the command curl http://45.55.91.235/ to access your app, then the server_name must be 45.55.91.235.
   
   You did not setup DNS records. Setting up DNS is outside the scope of this walkthrough. In the mean time, we recommend that you use your server's IP address as the server name.


   * deploy step: https://www.phusionpassenger.com/library/walkthroughs/deploy/ruby/aws/nginx/oss/trusty/deploy_app.html

   note: 1. server_name
         2. public folder
         3. tmp folder

4. Ubuntu instance update
   $ sudo apt-get update        # Fetches the list of available updates
   $ sudo apt-get upgrade       # Strictly upgrades the current packages
   $ sudo apt-get dist-upgrade  # Installs updates (new ones)
   $ sudo apt-get autoremove

   $ sudo apt-get update && sudo apt-get upgrade && sudo apt-get dist-upgrade && sudo apt-get autoremove

5. ssh-keygen -R *ip_address_or_hostname* for used ip change to another one

6. install PHP LAMP server: sudo apt-get install lamp-server^
    $ sudo apt-get -y install phpmyadmin
    $ sudo a2enmod rewrite # match slash
    $ sudo service apache2 restart

    $ sudo apt-get git
    $ sudo git clone .....  into /var/www/html

    $ sudo chown -R www-data:www-data backend2

    /etc/apache2/apache2.conf: 
    <Directory /var/www/>
        Options Indexes FollowSymLinks
        AllowOverride All
        Require all granted
   </Directory>

   /etc/apache2/sites-enabled: to set the root of the site.

   enable curl in php:
   $ sudo apt-get install php5-curl

7. setup the locale for Ubuntu: http://askubuntu.com/questions/162391/how-do-i-fix-my-locale-issue

8. Show availability zones
   $ aws ec2 describe-availability-zones

9. Show available subnets
   $ aws ec2 describe-subnets


# AWS System Administration
====

### Chapter 1. Setting Up AWS tools

1. aws-cli
2. jq   

