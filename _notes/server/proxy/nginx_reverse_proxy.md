nginx_reverse_proxy
===================

1. sites-available sites-enabled for nginx is similar to Apache's httpd-vhosts.conf

2. for docker damonyuan.com
server {
    listen 80;
    listen 443 ssl;
    server_name *.damonyuan.com;
    location / {
        proxy_set_header Host $http_host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_pass         http://127.0.0.1:8001;
    }
}

3. for Sinatra tennalabs.com
server {
    listen 80;
    server_name *.tennalabs.com;

    # Tell Nginx and Passenger where your app's 'public' directory is
    root /var/www/ChinaHolidays/code/public;

    # Turn on Passenger
    passenger_enabled on;
    passenger_app_env staging;
    passenger_ruby /usr/local/rvm/gems/ruby-2.2.0@ChinaHolidays/wrappers/ruby;
}

4. for node damonyuan.info 
server {
    listen 80;
    server_name damonyuan.info;

    # Tell Nginx and Passenger where your app's 'public' directory is
    root /var/www/damonyuan/code/public;

    # Turn on Passenger
    passenger_enabled on;
    # Tell Passenger that your app is a Node.js app
    passenger_app_type node;
    passenger_startup_file server.js;
}

5. for docker hezhu.design 
server {
    listen 80;
    server_name *.hezhu.design;
    location / {
        proxy_set_header Host $http_host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_pass         http://127.0.0.1:8000;
    }
}