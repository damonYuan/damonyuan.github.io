Ruby_On_Rails_Record
==============

Ruby_On_Rails_Record

# Chapter 1 & 2

## Using RubyMine IDE for Hartl's Rails Tutorial
  https://github.com/perfectionist/sample_project/wiki

## init a project
  0. $ rvm get latest
  1. Defining getset and loading rails for the first_project
     $ rvm use ruby-xxx@xxx_project --create 
     (Note: $ gem list)
     $ rvm gemset list
     $ rvm gemset delete teddy

  1.5 $ gem install rails (Please specify the version here.)
     (Note : here the rails is installed based on the gemset created and used above)
     $ gem install rails -v 3.2.16

  2. Create New Rails Project
     $ rails new xxx_project or

     $ rails new xxx_project --skip-test-unit
     Here the --skip-test-unit option to the rails command tells Rails not to generate a test directory associated with the default Test::Unit framework. Using RSpec to write a thorough test suite.
     NOTE: No test folder will generated then. Should set up RSpec manually
     2.1 $ rails generate rspec:install
         $ bundle exec rspec -> run the specs, by default will run all _spec.rb files in spec directory

  3. cd xxx_project
  4. $ rvm --ruby-version use 1.9.3 (create the .ruby-version file) or $ echo 1.9.3  > .ruby-version
     $ rvm --ruby-version use 1.9.3@my_app                          or $ echo my_app > .ruby-gemset
  5. Then we can open the project with rubymine or other textEditor
  6. modify gemfile

### Notes:
  6.1. gemfile: set version to be definite to avoid disruption from upgrade
  6.2. bundle install --without production -> not install gem required in production
       (Note: this is a "remembered option", which means that we don't have to include it in future invocations of Bundler--> simply '$ bundle install')

       bundle update                       -> this will write the changes in gemfile into gemfile.lock
  6.3. $ bundle exec rake xxx              -> ensure that the right version of rake defined in bundle is used

  7. If use --skip-test-unit and Rspec to test -> $ rails generate rspec:install
     This is used to configure Rails to use RSpec in place of Test::Unit

  8. Then init with git

## Notes: already existing a server running
  delete the file in /temp/pids

## Rails console: 

                 $ rails console (--sandbox)
                 $ first_user = User.first
                 $ first_user.microposts
                 $ exit

## Using Heroku (pg gem is used to allow Rails to talk to Postgres, rails_12factor gem is used by Heroku to serve static assets such as images and stylesheets)

  1. $ heroku create
  2. $ bundle exec rake assets:precompile
  3. $ git commit -a -m "xxxx"
  4. $ git push heroku master
  5. $ heroku run rake db:migrate

  6. $ heroku rename xxx_project
  7. $ heroku open
  8. $ heroku logs

## Deploy to Heroku

  Note: If you do end up using Heroku for a real-life application, be sure to follow the Unicorn configuration (book section 7.5)

# Chapter 3

## Generate through scaffold

   $ rails generate scaffold User <NAME:TYPE> (eg. name:string email:string)

## Generate controller

   $ rails generate controller <CamelCase name of the controller> <lower-case action name of actions> <lower-case action name of actions>

   $ rails destroy  controller <CamelCase name of the controller> <lower-case action name of actions> <lower-case action name of actions>

## Generate model

   $ rails generate model <CamelCase name of the model> <NAME:TYPE> <NAME:TYPE>

   $ rails destroy  model <CamelCase name of the model>

## Database migration

   $ bundle exec rake db:migrate

   $ bundle exec rake db:rollback

   $ bundle exec rake db:migrate VERSION=0 -> this will go all the way back to the beginning

## Cannot log $ rails console ->  Library not loaded: @@HOMEBREW_PREFIX@@/opt/readline/lib/libreadline.6.dylib 
    
    $ brew rm -f readline
    $ brew install readline
    $ brew link readline --force

## Start rails server at a specific IP address and Port
    $ rails server -b $IP -p $PORT


## Setting the root route
  rails 3.x users should 
  1. in /config/routes.rb file, add 
     root :to => 'static_pages#home'
  2. remove public/index.html

  Note: $ rake routes -> show all the routes
  eg:  static_pages_home GET /static_pages/home(.:format)  static_pages#home
                    root     /                             static_pages#home


## /public/ directory
  1. by default Rails serves any files in the public directory directly to the browser. In the case of the special index.html file, you don't even have to indicate the file in the URI, as index.html is the default.

## Eliminating bundle exec
  1. 1.11.X or higher rvm -> install gems will automatically be executed in the proper Bundle environment.



# Chapter 4

## single quotes make a variable to contain a iteral backslash easier.
   Inside double-quoted strings, a literal backslash is represented with two backslashes.
   >> '\n'
   => "\\n"

# Chapter 5

## bootstrap-sass gem
   Bootstrap is a framework uses the LESS CSS language for making dynamic stylesheets; the Rails asset pipeline supports the Sass language by default, so bootstrap-sass converts LESS to Sass and makesall the necessary Bootstrap files available to the current application.

   Bootstrap is a framework from Twitter that makes it easy to add nice web design and user interface elements to an html5 application.

   Note: variables for colors in Bootstrap: Bootstrap page of LESS variables http://bootstrapdocs.com/v2.0.4/docs/less.html

   (Note: &:hover -> #logo:hover as part of converting from SCSS to CSS. hover is the attribute of logo id.)

   (Note: Sass color constant using $, css using #999)

## Rails 3 uses HTML5 by default

   (as indicated by the doctype<!DOCTYPE html>); Since the HTML5 standard is relatively new, some browsers (especially older versions Internet Explorer) don't fully support it, so we include some JavaScript code(known as an "HTML5 shim") to work around the issue:
   
   <!--[if lt IE 9]>
   <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
   <![endif]-->

## All HTML elements can be assigned both classes and ids; 
   these are merely labels and are useful for syling with CSS.

## app/assets/stylesheets
   
   This directory is part of the asset pipeline and any stylesheets in this directory will automatically be included as part of the application.css file included in the site layout.

   The .scss extension, which indicates a "Sassy CSS" file and arranges for the asset pipeline to process the file using Sass.

## rails partials -> <%= render 'layouts/header' %>
   _app/views/layouts/_header.html.erb

## Sass and the asset pipeline
   ###1. Manifest files
   *= require_tree . -> ensures that alll CSS files in the app/assets/stylesheets directory (including the tree subdirectories) are included into the application CSS.
   *= require_self  -> specifies where in the loading sequence the CSS in application.css itself get included.

   Note: http://guides.rubyonrails.org/asset_pipeline.html

   ###2. preprocessor engines: .scss for sass, .coffee for CoffeeScript, .erb for embedded Ruby
   Note: http://railscasts.com/episodes/267-coffeescript-basics; preprocessor engines can be chained, with the code running from right to left.

   Bootstrap defines variable using LESS, not Sass, but the bootstrap-sass gem provides the Sass equivalents. It is not difficult to guess the correspondence; where less uses an "at" sign @, Sass uses a dollar sign $. (http://bootstrapdocs.com/v2.0.4/docs/less.html)

## 5.3 Layout links
   ###1. Add a View
   1. write test
   2. update the routes
   3. add a contact action to the controller
   4. create a view

   ###2. Rails routes
   1. http://guides.rubyonrails.org/routing.html
   2. define the named routes:
      replace

      get 'static_pages/help'

      with

      match(or get) '/help', to: 'static_pages#help'
   3. In the Rails Tutorial, we'll follow the common convention of using the path form except when doing redirects, where we'll use the url form.
      This is because after redirects the HTTP standard technically requires a full URI, although in most browsers it will work either way.

   4. If Heroku do not show CSS style

      $ rake assets:precompile (If it does not work, check database.yml configuration)
      $ git add -A
      $ git commit -a -m "xxx"
      $ git push
      $ git push heroku

# Chapter 6

## 1.generate model
   $ rails generate model User name:string email:string

   Note: in contrast to the plural convention for controller names, model names are sigular: a Users controller, but a User model.

   $ bundle exec rake db:rollback

   under the hood, this command executes the drop_table command to remove the users table from the database. (drop_table is the inverse of create_table)

   In the case of an irreversible migration, such as one to remove the database column, it is necessary to define separate up and down methods in place of the single change method.

   Read about migrations in the Rails Guides for more information. http://guides.rubyonrails.org/migrations.html

## 2.annotate gem
   This gives us a command called annotate. This gives us a command called annotate, which simply adds comments containing the data model to the model file.

## attr_accessible and attr_accessor
   attr_accessible -> a Rails method that allows you to pass in values to a mass assignment. ensure that the attributes are automatically accessible to outside users.
   attr_accessor   -> a ruby method that makes a getter and setter.
   When you create somehow a link between a rails model with a database table you NEVER needs attr_accessor in your model to create setters and getters in order to be able to modify your table's records.
   This is because your model inherit all methods from the ActiveRecord::Base Class, which defines already for your basic CRUD accessors.

## user = User.create(para: something); -> user = User.new(para: something); user.save;
   user.destroy;
   user.save; user.update_attributes(name: "The Dude", email: "dude@abides.org");
   user.reload.email;
   user.update_attributes(name: "The Dude", email: "dude@abides.org")

   Note: Once you have defined some attributes as accessible using attr_accessible, only those attributes can be modified using update_attributes.

## User validateions
   1. user.valid?
      user.errors.full_messages
   2. validates :name, presence: true, length: { maximum: 50 }
   3. Format validation
   4. Adding a secure password
      
# Chapter 7
##1. debug in .erb
     <%= debug(params) if Rails.env.development? %>
##2. Sass mixin facility
     A mixin allows a group of CSS rules to be packaged up and used for multiple elements.
##3. rake routes 
     To show all the available routes
##4. resource and resources
     resource :profile, :only => [:edit, :update]
     as a user, I should only be able to update my own profile. I should never be able to edit other users' profiles, so there's no need for a URL scheme like /users/1/profile/edit. Instead, I use /profile/edit, and the controller knows to user the current user's ID rather than the ID passed in the URL.

     The logic difference is to declare you logically can't have the plural for reference in your app, for example Admin or whatever.
##5. Factory Girl
     We could use Active record to create a user with User.create, but experience shows that tuser factories are a more convenient way to define user objects and insert them in the database.
     Factory Girl is only required for test environment

##6. uplift the speed
     BCrypt's slow speed is part of what makes it so hard to attack.
     BCrypt uses a cost factor to control how computationally costly it is to create the secure hash.
     The solution is to add a few lines to the test configuration file, config/environments/test.rb, redefineing the cost factor from its secure default value to its fast minimum value in test environment.
     
       BCrypt::Engine::DEFAULT_COST = BCrypt::Engine::MIN_COST

     in test.rb

##7. Gravatar
     Gravators are a convenient way to include user profile images without going through the trouble of managing image upload, cropping and storage; all we need to do is construct the proper Gravatar image URI using the user's email address and the corresponding Gravatar image will automatically appear.

     (Note: by default, methods defined in any helper file are automatically available in any view, but for convenience should put the method in the file for helpers associated with the controller)
     (Note: the aside tag, which is used for content(such as sidebars) that complements the rest of the page but can also stand alone.)

##8. Reset a database
     $ bundle exec rake db:reset
     $ bundle exec rake db:test:prepare

##9. Capybara
     1. expect { click_button "Create my account" }.not_to change(User, :count)
        The change method takes as arguments an object and a symbol and then calculates the result of calling that symbol as a method on the object both before and after the block.

##10. Public assets
      Any assets under public will be served as static files by the application or web server. You should use app/assets for files that must undergo some pre-processing before they are served.

      In production, Rails precompiles these files to public/assets by default. The precompiled copies are then served as static assets by the web server. The files in app/assets are never served directly in production.

      Generally asset is anything that browser loads after it gets the HTML page.

      1) the image related to your css and layout design -> go under the app/assets/images
      2) the images that your users upload, those normally go into the public/system or public/uploads folder depending on what you use to receive the uploads. (User-uploaded files are not part of assets)
      3) And finally public/assets is where rails will compile your layout assets from the app/assets and vendor/assets folders when you run $ rake assets:precompile for production.

##11. <%= csrf_meta_tags %>
      This is related to the authenticity token, which Rails automatically includes to thwart a particular kind of attack called a cross-site request forgery(CSRF)
      (http://stackoverflow.com/questions/941594/understand-rails-authenticity-token)

##12. session
      A session usually consists a hash of values and a session id, usually a 32-character string, to identify the hash. Every cookie sent to the client's browser includes he session id. And the other way round: the browser will send it to the server on every request from the client.

      In Rails you can save and retrieve values using the session method:
      session[:user_id] = @current_user.id
      User.find(session[:user_id])

      session and cookie
      cookie containing the sever session id.
      sessions are stored on the server and are not reliant on cookies being enable in the client's browser. Sessions are where web developers store bits of application relevant data that they may wish to use across requests.
      Cookies store bits of data on the client (the browser) and are passed to the server via HTTP header Cookie.
      SSL session id and application or server session id.

##13. form_for(@user)
      This method automatically fills in the fields with the attributes of the @user object.

##14. Signup error message
      Rails provides error messages based on the User model validations.

      $ user.save
      $ user.errors.full_messages

##15. <% render 'shared/error_messages' %>
      This reflects the common Rails convention of using a dedicated shared/ directory for partials expected to be used in views across multiple controllers.
      -> create both app/views/shared directory and the _error_messages.html.erb

##16. pluralize(1, "error")   pluralize(5, "error")
      "1 error"               "5 errors"
      include it explicitly through the ActionView::Helpers::TextHelper

##17. On error pages Rails automatically wraps the fields with errors in divs with the CSS class field_with_errors.
      make use of Sass's @extend function to include the functionality of two Bootstrap classes control-group and error

##18. Password digest presence validation is hiden in has_secure_password

##19. _path and _url
      _path helpers provide a site-root-relative path.
      _url helpers provide an absolute path, including protocol and server name. Mainly use these in emails when creating links to the app on the server. They should mainly be used when provide links for external use.

##20. flash
      flash.each do |key, value|

##21. SSL
      1. Implement SSL site-wide
      2. config/environments/production.rb: $ config.force_ssl = true
      
      set up SSL on the remote server. Configuring a production site to use SSL is painful and error-prone, and among other things it involves purchasing an SSL certificate for your domain.
      
      Luckily, for an application running on a Heroku domain (such as the sample application), we can piggyback on Heroku’s SSL certificate, a feature that is included automatically as part of the Heroku platform.

      If you want to run SSL on a custom domain, such as example.com, you’ll have no choice but to endure some pain.(http://devcenter.heroku.com/articles/ssl)

##22. Bug: input width not 100%
      Make sure you're re-compiling your assets every time you push to Heroku after you've make a change in your CSS or JS.
      RAIL_ENV=production rake assets:precompile

##23. tag css to erb
      <div class＝“alert alert-success”><%= value %></div>
      <%= content_tag(:div, value, class:"alert alert-success") %>

      <a href="http://railstutorial.org" class ="btn" >Ruby on Rails</a>
      <%= link_to('Ruby on Rails', 'http://railstutorial.org', class:'btn') %>

# chapter 8
##1. match '/signout', to: 'sessions#destroy', via: :delete
     Note the use of via: :delete for the signout route, which indicates that it should be invoked using an HTTP DELETE request.

##2. rubymine short-cut
     1. command + B navigating to a declaration
        command + Y quickly view it in aseparate window
     2. command + option/alt + B navigating class hierarchies
        command + U navigate to its superclass definition
     3. control + command + up navigating to related files

##3. selectors
     http://www.w3schools.com/cssref/css_selectors.asp
     In CSS, selectors are patterns used to select the element(s) you want to style.

##4. form_for(@"user")
     allows Rails to infer that the action of the form should be to POST to the URI /users, 
     form_for(:session, url:sessions_path) (we can also use form_tag instead)

##5. Flash in layout
     The contents of the flash persists for one request, but rerendering a template with render doesn't count as a request.
     using flash.now instead.

##6. Cross-site request forgery
     protect_from_forgery : it will start working once we define the sign_out method.

##7. One technique for maintaining the user signin status is to use a traditional Rails session via the special session function
     session[:remember_token] = user.id
     This sessin object makes the user id available from page to page by storing it in a cookie that expires upon browser close.
     On each page, the application could simply call
     User.find(session[:remember_token])
     Because of the way Rail handles session, this process is secure; if a malicious user tries to spoof the user id, Rails will detect a mismatch based on a special session id generated for each session.

##8. $ rails generate migration add_remember_token_to_users
     $ rake db:migrate:up VERSION=2015111201919 --trace

##9. The schema.rb serves mainly two purposes
     1. It documents the final current state of the database schema. Often, especially when you have more than a couple of migrations, it's hard to deduct the schema just from the migrations alone. With a present schema.rb, you can just have a look there. ActiveRecord itself will indeed not use it. It will introspect the database during runtime as this is much safer than to expect users to keep the schema.rb up-to-date. However to avoid confusion of your developers, you should always maintain a file that is up-to-date with your migrations.
     2. It is used by the test to populate the database schema. As such a 
     $ rake db:schema:dump 
     is often run as part of the 
     $ rake test:prepare 
     run. The purpose is that the schema of the test database exactly matches the current development database.

##10. error: rake db:migrate not work
     rake db:drop:all
     rake db:create:all
     rake db:migrate
     or
     rake db:rollback

##11. urlsafe_base64 method from the SecureRandom module in the Ruby standard library
      It creates a Base64 string safe for use in URIs and hence safe for use in cookies as well.

##12. Create a remember token using a callback
      As in that section, we’ll use a before_save callback, this time to create the attribute remember_token just before the user is saved. A second option would be to use a before_create callback4 to set the remember token once, when the user is first created. This would work fine, but it has the downside that any hijacked sessions (which involves copying the remember token and using it to sign in as the corresponding user) would never expire.
      The before_save callback, in contrast, ensures that the token changes every time the user updates his information (Section 9.1.3), so it’s slightly more secure.
      Session hijacking was widely publicized by the Firesheep application, which showed that remember tokens at many high-profile sites were visible when connected to public Wi-Fi networks. The solution is to use site-wide SSL.

##13. Sign in design
      Function: Our desired authentication method is to place a remember token as a cookie on user's browser and then use the token to find the user record in the database as the user moves from page to page.

##14. current_user
      accessible in both controllers and views
      <% current_user.name %>
      redirect_to current_user

##15. rails link
      Rails allows us to link directly to the user, in this context automatically converting current_user into user_path(current_user).

##16. Bootstrap dropdown
      The dropdown menu requires the use of Bootstrap's JavaScript library, which we can include using the Rails asset pipeline by editing the application JavaScript file.
      This uses the Sprockets library to include the Bootstrap JavaScript, which in turn is available thanks to the bootstrap-sass gem.

##17. User.all.each { |user| user.save(validate: false) }
      pass validate: false to tell Active Record skip the validations.

##18. Cucumber
      Write signin tests using Cucumber -> a popular tool for behavior-driven development that enjoys significant popularity in the Ruby community.
      $ rails generate cucumber:install
      It will creates a features/ dir 

      $ bundle exec rspec spec/ => $ bundle exec cucumber features/
      $ bundle exec rake cucumber


##19. :require => false in gemfile
      This means install the gem, but do not call require when you start Bundler. So you will need to manually call 
      require 'whatever'
      if you want to use the library

##20. give each user in heroku a token
      $ heroku run console
      >> User.all.each { |user| user.save(validate: false) }

##21. $ rake assets:clean
      
##22. Error: the dropdown box not working on rails
      put
      //= require bootstrap
      on the top of application.js file.

      $ config.assets.compress = false 
      for both dev and production.

      Stop spreading that config.assets.compile = true is the solution. Yes, it works but the downsides are bad for the performance of your app, since it has to compile dinamically css-js files on the fly if there's no a static version of those files. config.assets.compile = false forces you to serve all the files statically and if one or more are missing then your app throws a 500/404 error. 

      Finally solution:
      Some facts I discovered on my Ubuntu + ruby 1.9.3 + rails 3.2.7 + twitter-bootstrap-rails 2.1.1:

      1. Changing order of inclusions breaks development mode, so did not changed it.
      2. Development mode without assets precompiled works fine.
      3. Development mode with assets precompiled broken.
      4. Production mode (assets precompiled of course) works fine.
      5. Commenting-out config.assets.debug = true in config/environments/development.rb fixes development mode when assets precompiled.
      6. The last thing looks very strange. Some black magic definitely involved.


#chapter9
##1. .idea files and workspace.xml in rails
     This folder and files are created if the application was opened at least once with RubyMine, all the user configuration regarding the project are saved in this directory.

##2. post for edit?
     Since web browsers can't natively send PUT requests (as required by the REST conventions), Rails fakes it with a POST request and a hidden input field.

     How does Rails know to use a POST request for new users and a PUT for editing users?
     The answer is that it is possible to tell whether a user is new or already exists in the database via Active Record's 

     new_record?

     boolean method.

##3. Settings -> test
     Since it depends on the signin status of the user, the test for the Settings link belongs with the other authentication tests.

##4. Capybara
     It helps you test web applications by simulating how a real user would interact with your app.
     Using one of the HTTP request methods directly(get, post, put or delete) will not use Capybara.

##5. Note for cookies.permanent
     It does not work inside tests.

##6. Error: uninitialized constant RSpec::Match (NameError)
     File that contain RSpec::Matchers.define -> require 'rspec-expectations'

##7. configure DNS to point to damonyuan.heroku.com
     1. CNAME: www
        point to: damonyuan.heroku.com
     2. SSL Endpoint

##8. disable ssl
     1. comment out the rails configuration for ssl
     2. push heroku
     3. clear data in browser

##9. a second way, apart from Capybara's visit method, to access a controller action
     By issuing the appropriate HTTP request directly.

     This is necessary because there is no way for a browser to visit the update action directly - it can only get there indirectly by submitting the edit form- so Capybara can't do it either.
     But visiting the edit page only tests the authorization for the edit action, not for update.

     Rails support get post put and delete.

     When using one of the methods to issue HTTP requests directly, we get access to the low-level response object. Unlike the Capybara page object, response lets us test for the server response itself, in this case verifying that the update action responds by redirecting to the signin page.

##10. before_filter
     By default, before filter apply to every action in a controller, so here we restrict the filter to act only on the :edit and :update actions by passing the appropriate :only options hash.

     uses a shortcut for setting flash[:notice] by passing an options hash to the redirect_to function.
     -> redirect_to signin_url, notice: 'Please sign in.'

##11. Bootstrap CSS about flash style
      1. :success
      2. :error
      3. :notice

##12. session and cookies
      session facility provided by Rails can be thought of as being like an instance of the cookies variable that automatically expires upon browser close.

##13. Faker gem
      This allow us to make sample users with semi-realistic names and email addresses.

##14. rake tasks
      lib/tasks
      ??? HOW TO MAKE RAKE TASKS ???
      
      task populate: :environment do
      ensures that the Rake task has access to the local Rails environment, including the User model( and hence User.create!).
      Here create! is just like the create method, except it raises an exception for an invalid user rather than returning false.

      $ bundle exec rake db:reset
      $ bundle exec rake db:populate
      $ bundle exec rake db:test:prepare

##15. Paginate
      will_paginate gem
      bootstrap-will_paginate

      before(:all) ensures that the sample users are created once, before all the tests in the block.

      params[:page], which is generated automatically by will_paginate.

##16. admin
      toggle! method to flip the admin attribute from false to true.
      In migration:
      Without the default: false argument, admin will be nil by default, which is still false, so this step is not strictly necessary. It is more explicit, though, and communicates our intentions more clearly both to Rails and to readers of our code.
      
      Why not just add admin: true to the initialization hash?

      The answer is, it won't work, and this is by design: only attr_accessible attributes can be assigned through mass assignment(that is, using an initialization hash, as in User.new(name: "Foo", ...)), and the admin attribute isn't accessible.

      It is good practice to define attr_accessible for every model. And it's a good idea to write a test for any attribute that isn't accessible.

##17. Web browsers can’t send DELETE requests natively, so Rails fakes them with JavaScript. This means that the delete links won’t work if the user has JavaScript disabled. 
      If you must support non-JavaScript-enabled browsers you can fake a DELETE request using a form and a POST request, which works even without JavaScript.
      http://railscasts.com/episodes/77-destroy-without-javascript

      Unfortunately, there’s still a terrible security hole: any sufficiently sophisticated attacker could simply issue DELETE requests directly from the command line to delete any user on the site.
      To secure the site properly, we also need access control on the destroy action, so our tests should check not only that admins can delete users, but also that other users can’t.

##18. git push
      $ git push heroku
      $ heroku pg:reset DATABASE
      $ heroku run rake db:migrate
      $ heroku run rake db:populate -> populate the production database with sample users.
      $ heroku restart

##19. Configure RubyMine remote connection to Heroku PostgreSQL
      In the Advanced tab, there are a bunch of properties. Set the following properties:
      ssl -> true
      sslfactory -> org.postgresql.ssl.NonValidatingFactory

##20. $ rake db:test:prepare  
      run this everytime before test.

# Chapter 10

##1.  Note that, since we expect to retrieve all the microposts associated with a given user id in reverse order of creation, Listing 10.1 adds an index (Box 6.2) on the user_id and created_at columns.

##2.  attr_accessible :content, :user_id
      this means that anyone could change any aspect of a micropost object simply by using a command-line client to issue malicious requests. For example, a malicious user could change the user_id attributes on microposts, thereby associating microposts with the wrong users. This means that we should remove :user_id from the attr_accessible list

##3.  The canonical way to make a micropost: trhough its association with a user.
      
      eg.
      Micropost.create  -> user.microposts.create
      Micropost.create! -> user.microposts.create!
      Micropost.new     -> user.microposts.build

      When a new micropost is make in this way, its user_id is automatically set to the right value, and the user_id will not be exposed to others.

      @micropost = Micropost.new(content: 'Lorem ipsum', user_id: user.id) -> @micropost = user.microposts.build(content: 'Lorem ipsum')
      Once we define the proper associations, the resulting @micropost variable will automatically have user_id equal to its associated user.
      Because the relationship: A user "has_many" microposts, a micropost "belongs_to" a user.

      Note: Building the micropost through the User association doesn’t fix the security problem of having an accessible user_id, and because this is such an important security concern we’ll add a failing test to catch it.
            describe 'accessible attributes' do
              it 'should not allow access to user_id' do
              expect do
                Micropost.new(user_id: user.id)
              end.to raise_error(ActiveModel::MassAssignmentSecurity::Error)
              end
            end
      
      This test verifies that calling Micropost.new with a nonempty user_id raises a mass assignment security error exception. This behavior is on by default as of Rails 3.2.3, but previous versions had it off, so you should make sure that your application is configured properly.

      Note: config.active_record.whitelist_attributes = true

      Note: RELATION BETWEEN has_many and belongs_to
            has_many -> should decide if to delete the dependent should be deleted
            eg. has_many :microposts, dependent: :destroy
            belongs_to -> should make sure its owner has its presence and it should not be able to change the owner of it through web. And the default_scope to define the sequence of returned value
            eg. validates :user_id, presence: true

##4.  Note: the attributes marked by attr_accessible can be editable through the web! So it is very important to keep the security of the attributes like this.

##5.  Test on micropost.user 
      it { should respond_to(:user) }
      its(:user) { should == user }

##6.  Using FactoryGirl to create one object with attributes that are not listed in attr_accessible
      eg.
      factory :micropost do
        content "Lorem ipsum"
        user
      end

      Here we tell FactoryGirl about the mocropost's associated user just by including a user in the definition of the factory.

      FactoryGirl.create(:micropost, user: @user, created_at: 1.day.ago)
      FactoryGirl.create(:micropost, user: @user, created_at: 1.hour.ago)

      Note how convenient the use of Factory Girl is: not only can we assign the user using mass assignment (since factories bypass attr_accessible), we can also set created_at manually, which Active Record won’t allow us to do.

      To get the ordering test to pass, we use a Rails facility called default_scope with an :order parameter：
      default_scope order: 'microposts.created_at DESC'

##7.  let! and let
      let variable are lazy, meaning that they only spring into existence when referenced. The problem is that we want the microposts to exist immediately, so that the timestamps are in the right order and so that @user.microposts isn't empty. We accomplish this with let!, which forces the corresponding variable to come into existence immediately.

##8.  we must take great care when making duplicates of Ruby objects. To duplicate relatively simple objects such as arrays, we can use the dup method. (or clone)
      Note: difference between dup and clone
      1. clone copies the the singleton class, while dup does not.
      2. clone preserves the frozen state, while dup does not.

      This is known as a “shallow copy”. Making a “deep copy” is a much more difficult problem, and in fact has no general solution, but dropping “ruby deep copy” into a search engine should be enough to get you started if you need to copy a more complicated structure such as a nested array.

##9.  Note here that we can use the count method through the association:
      user.microposts.count
      The association count method is smart, and performs the count directly in the database. In particular, it does not pull all the microposts out of the database and then call length on the resulting array, as this could become inefficient as the number of microposts grew.  Instead, it asks the database to count the microposts with the given user_id. In the unlikely event that finding the count is still a bottleneck in your application, you can make it even faster with a "counter cache"(http://railscasts.com/episodes/23-counter-cache-column).

##10. Note <%= will_paginate %> work without provide a instance var
      This worked because, in the context of the Users controller, will_paginate assumes the existence of an instance variable called @users(Which should be of class ActiveRecord::Relation).

##11. generating sample content for micropost
      Using the Faker gem's handy Lorem.sentence method.(Faker::Lorem.sentence returns lorem ipsum text.)

##12. Error: Missing partial microposts/micropost
      Caveat: If you just provide an object and let rails determine the partial by itself, it will default to :pluralized_model_name/_:singular_model_name, which is microposts/_micropost in your case. 
      If you want rails to render another partial for your collection, you need to explicitly specify it; render partial: 'user/microposts', collection: @microposts.

##13. Everytime add some routes we should think of the ACCESS 

##14. Generate controller without test
      --no-test-framework
      --no-helper
      --no-assets
      --no-controller-specs

##15. Using the user/micropost association to build the new micropost
      @micropost = current_user.microposts.build(params[:micropost])

##16. Difference between render and redirect_to
      Both used in controller to reply to a request. 
      redirect_to will simply redirect the request to a new URL;
      render can be used in may ways, but it's mainly used to render your html views.

      render tells Rails which view(or other asset) to use in constructing a response. The redirect_to method does something completely different: it tells the browser to send a new request for a different URL.
      render :action does not run any code in the target action
      redirect_to: Your code stops running and waits for a new request for the browser. It just happens that you've told the browser what request it should make next, by sending back an http 302 status code.

      render tells your controller to render a view without pasing any data(say, from a form) to the next contrller action.
      redirect_to does a 302 page redirect, passing ddata to either a controller action on your webapp, or an external app.

      NOTE:
      In create action: if create successfully, use redirect_to; if fail, use render the original view.
      REASON: using render you will still be in the same session, and if post again rails will treat it as PUT(TODO: Why?) rather than POST.(POST w)

##17. SQL injection
      http://en.wikipedia.org/wiki/SQL_injection
      Rails use
      Micropost.where("user_id = ?", id) to ensures that id is properly escaped before being included in the underlying SQL query, thereby avoiding the SQL injection.
      Note! always escaping varialbles injected into SQL statements is a good habit to cultivate.

##18. <%= render partial: 'shared/feed_item', collection: @feed_items %>
      Here we pass a :collection parameter with the feed items, which causes render to use the given partial (’feed_item’ in this case) to render each item in the collection.

##19. Why @micropost works but @feed_items does not work?

      @micropost  = current_user.microposts.build if signed_in?
      @feed_items = current_user.feed.paginate(page: params[:page], per_page: 10)

      though: on failed micropost submission, the Home page expects an @feed_items instance variable, so failed submissions currently break (as you should be able to verify by running your test suite). The easiest solution is to suppress the feed entirely by assigning it an empty array.

      ? posted object still be stored in the session until the session finished?
      CACHING: http://hawkins.io/2011/05/advanced_caching_in_rails/

##20. .find_by_id() an .find().first
      .find_by_id() return the nil if not find
      .find()  raise error if not find

##21. For security purposes it is a good practice always to run lookup through the association.
      Reason: http://www.rubyfocus.biz/blog/2011/06/15/access_control_101_in_rails_and_the_citibank-hack.html
      (Access Control 101 in Rails and the Citibank Hack)

##22. NameError:
       undefined local variable or method `root_path' 

       Reason: define visit method in Rspec model test. visit method should only be in pages test.

##23. Difference between :each and :all
      Notice: :each runs before _each_ spec, but :all runs once, before _any_ spec

##24. passing data into partial render
      <%= render partial: '/shared/feed_delete_link', locals: {feed_item: feed_item} %>
      Note: do not use instance variables in partial

##25. method used in a edit_area
      1. wrap helper => keep the layout
      2. raw method  => prevent RAils from escaping the resulting HTML
      3. sanitize method => prevent cross-site scripting

       def wrap(content)
        sanitize(raw(content.split.map{ |s| wrap_long_string(s) }.join(' ')))
       end

      private
      def wrap_long_string(text, max_width = 30)
        zero_width_space = "&#8203;"
        regex = /.{1,#{max_width}}/
        (text.length < max_width) ? text :
                                    text.scan(regex).join(zero_width_space)
      end

##26. For security reason, helper methods should not be included in controller.
      If you want to use a helper method in controller:
      You can use:
      1. @template. (rails 2)
      2. view_context. (rails 3)
      3. ActionController::Base.helpers
      4. include helper in a singleton class and then singleton.helper
      5. include the helper in the controller (WARNING: will make all helper methods into controller actions)

      NORMALLY helper methods are used in views

#chapter 11
##1.  has_many :followed_users, through: :relationships, source: :followed
      $ rails generate model Relationship follower_id:integer followed_id:integer

      add_index :relationships, :follower_id
      add_index :relationships, :followed_id
      add_index :relationships, [:follower_id, :followed_id], unique: true -> composite index that enforces uniqueness of pairs of (follower_id, followed_id), so that a user can't follow another user more than once.
      Adding a unique index arranges to raise an error if a user tries to create duplicate relationships anyway(using, e.g., a command-line tool such as curl)
      We could also add a uniquenesss validation to the Relationship model, but because it is always an error to create duplicate relationships, the unique index is sufficient for our purposes.

##2.  Rails connct two database tables
      An id used in this manner to connect two database tables is known as a foreign key, and when the foreign key for a User model object is user_id, Rails infers the association automatically: by default, Rails expects a foreign key of the form <class>_id, where <class> is the lower-case version of the class name.

      class User < ActiveRecord::Base
        has_many :microposts, dependent: :destroy
        has_many :relationships, foreign_key: 'follower_id', dependent: :destroy
        has_many :followed_users, through: :relationships, source: :followed
      end

##3.  Complicated Relationship
      To write the application code, we define the belongs_to relationship as usual. Rails infers the names of the foreign keys from the corresponding symbols (i.e., follower_id from :follower, and followed_id from :followed), but since there is neither a Followed nor a Follower model we need to supply the class name User.
      in this case only the followed_id is accessible.

##4.  sequence for model
      1. create model
      2. revise migration based on database design
      3. migration
      4. add test for database table relations then Revise relationship between data models based on test
      5. add test for data model validations then add validation to data models.

##5. exclamation point
     (This follow! method should always work, so, as with create! and save!, we indicate with an exclamation point that an exception will be raised on failure.

##6. reverse_relationships
     Instead, we will exploit the underlying symmetry between followers and followed users to simulate a reverse_relationships table by passing followed_id as the primary key.

##7. has_many :followers, through: :reverse_relationships
     since, in the case of a :followers attribute, Rails will singularize “followers” and automatically look for the foreign key follower_id in this case. I’ve kept the :source key to emphasize the parallel structure with the has_many :followed_users association, but you are free to leave it off.

##8. member and collection
     in router, member will include the id; collection will not include the id.

     http://guides.rubyonrails.org/routing.html

##9. form_for()
     Naturally, the former sends a POST request to the Relationships controller to create a relationship, while the latter sends a DELETE request to destroy a relationship.
     form_for(current_user.relationships.find_by_followed_id(@user), html: { method: :delete })

##10. render by view and render by controller
      if render by view should add prefix '_'; if render by controller just leave the name what you want.

##11. Ajax
      Allows web pages to send requests asynchronously to the server without leaving the page.
      just change form_for -> form_for ..., remote: true
      /*
       <form action="/relationships/117" class="edit_relationship" data-remote="true"
      id="edit_relationship_117" method="post">
      */

      and Rails automagically use Ajax. This sets the variable data-remote="true" inside the form tag, which tells Rails to allow the form to be handled by JavaScript.  By using a simple HTML property instead of inserting the full JavaScript code, http://railscasts.com/episodes/205-unobtrusive-javascript.

      Test:
      xhr method (for “XmlHttpRequest”) to issue an Ajax request;
      the xhr method is (somewhat inexplicably) not available in integration tests
      xhr :post, :create, relationship: { followed_id: other_user.id }
       a symbol for the relevant HTTP method, a symbol for the action, and a hash representing the contents of params in the controller itself. 
        All we need to do is respond to a normal HTTP request with a redirect (as in Section 11.2.4) and respond to an Ajax request with JavaScript.
        This code uses respond_to to take the appropriate action depending on the kind of request.
        respond_to do |format|
          format.html { redirect_to @user }
          format.js
        end

        Rails automatically calls a JavaScript Embedded Ruby (.js.erb) file with the same name as the action, i.e., create.js.erb or destroy.js.erb.
         Document Object Model (DOM). The jQuery library provides a large number of methods for manipulating the DOM

          First, we will need to know about the dollar-sign syntax to access a DOM element based in its unique CSS id.
          The second method we’ll need is html, which updates the HTML inside the relevant element with the contents of its argument.

          Unlike plain JavaScript files, JS-ERb files also allow the use of Embedded Ruby, which we apply in the create.js.erb file to update the follow form with the unfollow partial (which is what should show after a successful following) and update the follower count.

##12.  Error:  undefined local variable or method `signin_path' 
       Controller specs cannot interact with pages in the same way that feature specs do, so your sign_in utility will not work for them.

##13. Error: undefined method sign_in
      there should be an "include SessionsHelper" in the application controller. By default, helpers are included in the views but in order to make use of a helper in a controller, it needs to be included explicitly.
      And model/controller/helper Rspec test first describe is not the same as the integration test.

##14. Problem of followed_user_ids = user.followed_user_ids
        pulls all the followed users’ ids into memory, and creates an array the full length of the followed users array.

       The solution involves pushing the finding of followed user ids into the database using a subselect.

       followed_user_ids = "SELECT followed_id FROM relationships
                     WHERE follower_id = :user_id"
       where("user_id IN (:followed_user_ids) OR user_id = :user_id",
       followed_user_ids: followed_user_ids, user_id: user)

##15. Note that the paginate method actually reaches all the way into the Micropost model method in Listing 11.      45, arranging to pull out only 30 microposts at a time from the database.

# Chapter12
## 1. attr_accessor and attr_accessible: 
      ttr_accessor is a ruby method that makes a getter and a setter. attr_accessible is a Rails method that allows you to pass in values to a mass assignment: new(attrs) or update_attributes(attrs)

      NOW, why the hell would you use the attr_accessor ?
      This is in the case your user form do show a field that doesn't exist in your users table as a column.

## 2. In Rails 4.0, default_scope takes lambda instead of a hash, and the -> syntax is a synonym for lambda introduced in Ruby 1.9. 




# About ENV["GMAIL_USERNAME"]
  user_name: ENV["GMAIL_USERNAME"], -> in email configuration
  You could "hardcode" your Gmail username and pssword into the file but theat would expose it to everyone who has access to your git repository.
  Ruby will replace ENV["GMAIL_USERNAME"] with an environment variable.


# Use the PORO Presenter for rendering.

# Put the right thing in the right place
 1.Logic in Controller:1. Session and cookie handling. This might also include authentication/authorization or any additional cookie processing you need to do.
                       2. Model selection. Logic for finding the right model object given the parameters passedin from the request. Ideally this should be a call to a single find method setting an instance variable to be used later for render the response.
                       3. Request parameter management. Gathering request parameters and calling an appropriate model method to persist them.
                       4. Rendering/redirecting. Rendering the result(html, xml, json, etc) or redirecting, as appropriate.
 2.Logic in view:1. use view layouts and partials appropriately to encapsulate things that are repeated on your pages.
                 2. use presenter(POROs) to encapsulate view-building logic in ruby object. You can then add methods into this object to perform logical operations that you might otherwise have put into your view code.
                 3. put logic in helpers.
 4.Logic in model:1. use POROs to put logics to their own classes.
                  2. ActiveRecord configuration: i.e., relations and validations
                  3. Simple mutation methods to encapsulate updating a handful of attributes and saving them in the database
                  4. Access wrappers to hid internal model information(e.g., a full_name method that combines first_name and last_name fields in the database)
                  5. Sophisticated queries(i.e., that are more complex than a simple find); generally speaking, you should never use the where method, or any other query-building method like it, outside of the model class itself.

＃ Activerecord's EAGER LOADING capability in Rails makes it possible to significantly reduce the number of queries by letting you specify in advance all the asociations that are going to be loaded. This is done by calling the includes(or preload) method on the Arel(ActiveRecord::Relation) object being built. With includes, ActiveRecord ensures that all of the specified associations are loaded using the minimum possible number of queries;

# What to test:
  There should be at least one high-level integration test written for each action in your controllers.

# Blocking on calls to external services:
  To avoid blocking on these calls, rather than calling these services directly in your Rails application during the normal processing of a request, you should move them to some sort of background job queuing service where feasible. (Delayed job, Resque, Sidekiq).
  In cases where it is impractical or infeasible to delegate processing to a background job queue, then you will need to make sure that your application has sufficient error handling and fail-over provisions for those inevitable situations when the external service (perhaps by removing the server your application is on from the network) to verify that it doesn't result in any unanticipated consequences.

# The schema.rb file can even be generated when no migrations are present by running the rake db:schema:dump task.A common Rails mistake is to check a new migration into your source repo but not the correspondingly updated schema.rb file.
  When migrations have gotten out of hand and take too long to run, or no longer create the database properly, developers should not be afraid to clear out the old migrations directory, dump a new schema, and continue on from there. Setting up a new development environment would then require a rake db:schema:load rather than the rake db:migrate that most developers rely on.

# How to arrrange the files in assets more effectively?

# What to put into the lib folder?
  http://blog.codeclimate.com/blog/2012/02/07/what-code-goes-in-the-lib-directory/   "What code goes in the lib/ directory?"

# Did not recognize your adapter specification 
  gem clean -> bundle install

# generate rspec
  $ rails generate rspec:install

# ERROR: no implicit conversion of Symbol into Integer
  This might be caused by t ".xxxx". Generally it is caused by using Symbol in a array. fix it by using t(".xxxx").

# assets load sequence in rails
  1. assets/application.xxx : to load the assets included here
  2. vendor/assets
  3. gems
  4. assets/(customized assets) :
  so customized assets will always overwrite the others


# all directories under app/ are automatically in both autoload_paths and eager_load_paths, meaning that adding a directory there requires no further actions.

# active_record
  1. conditions

# This token also already appears in one of the "meta" tags in the head of the application.html.erb layout file by default if you have the following ERB at the top:

<%= csrf_meta_tag %>
That ERB roughly renders to:

<meta content="abc123blahblahauthenticitytoken" name="csrf-token">
You can then grab it using jQuery with the following code:

var AUTH_TOKEN = $('meta[name=csrf-token]').attr('content');
     

--------------

1. Turn on ActiveRecord log in terminal
   ActiveRecord::Base.logger = Logger.new(STDOUT)








