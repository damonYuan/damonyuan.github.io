ruby_aws
========

1. code route: /var/www/foo/code
2. Nginx config file: /etc/nginx/sites-enabled/myapp.conf
3. Note: in app route dir, there should be a tmp and public folder.
4. Note: remember to set passenger environment and .profile_bash enviroment: RACK_ENV
5. remember to configure the charset and Collation for application:
   create database china_holidays_staging_db default character set utf8 default collate utf8_general_ci;

   218.191.203.209


   