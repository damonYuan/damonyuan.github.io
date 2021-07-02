heroku
======

1. You can check your current running dynos using 
   $heroku ps:

2. $ git push heroku yourbranch:master
   push non-master branch to heroku master

   eg: $ git push staging staging:master
       $ git push production production:master

3. create multiple env
   $ heroku create --remote staging xxx_staging
   $ git push staging master
   $ heroku ps --remote staging

   $ heroku create --remote production xxx_production
   $ git push production master
   $ heroku ps --remote production

   $ git config heroku.remote staging

   //delete git remote
   $ git remote -v
   $ git remote remove production
   $ git remote remove staging

   Note: add a existing repo.

4. Setting Environment Variables on Heroku
   $ heroku config:add GMAIL_USERNAME=myname@gmail.com
   If have multiple environments on Heroku
   $ heroku config:add GMAIL_USERNAME=myname@gmail.com --remote staging
   You can check that everything has been added correctly bu running
   $ heroku info --app myapp

5. Heroku config
   $ heroku config:add GMAIL_USERNAME=myname@gmail.com --remote staging

6. generate a public key
   $ ssh-keygen -t rsa
   $ heroku keys:add

7. Heroku restart -a app_name -r remote_name

8. Error: Always GET even use POST method
    I had a similar problem: I was POSTing to myapp.heroku.com instead of myapp.herokuapp.com -- POSTing to the latter solved it. GETting from myapp.heroku.com is OK though

    And also, it might be redirected to www domain automaitically, you should customize subdomain

    remember to use https instead of http as well on heroku domain, because it is automatically open.
    you can set it in environment/staging.rb

9. $ Heroku releases
   $ heroku rollback