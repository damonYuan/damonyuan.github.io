Ruby_Record
==============

Ruby_Record

# installation of RubyMine Debugger
1. the name of project folder should be normal(no '/ /@/*/&, etc...), or the debugger cannot run.
The error code is: "Process finished with exit code 143"

2. generate Gemfile by running bundle init, it is used o manage a Ruby application's gems

   The Gemfile is where you specify which gems you want to use, and let you specify which version
   
   The Gemfile.lock and 

3. rakefile is used to specify the rake command

4. install:
   gem install debugger-ruby_core_source
   gem install debugger
   gem install ruby-debug-ide
   then restart

# installation with RVM
1. Can't install Ruby under Lion with RVM – GCC issues:
   http://stackoverflow.com/questions/8032824/cant-install-ruby-under-lion-with-rvm-gcc-issues
   (The route to use is CC=/usr/bin/gcc-4.2 rvm install 1.9.3 --enable-shared)

2. Problem during installation about c compile -> you are probably missing the right developer tools. 
   http://www.nokogiri.org/tutorials/installing_nokogiri.html
   (Note: make: /usr/bin/gcc-4.2: No such file or directory -> $ rvm reinstall 1.9.3 --with-gcc=clan)

3. The Homebrew should not be installed under the root. Or the rvm CANNOT be installed.(because of 'brew update' cannot be implemented)

4. rvm gemset list

5. rvm --ruby-version use 1.9.3 (create the .ruby-version file) or echo 1.9.3 > .ruby-version
   rvm --ruby-version use 1.9.3@my_app  or echo my_app > .ruby-gemset


# ruby operator ||=
1. a ||= b -> a || a = b
  http://www.rubyinside.com/what-rubys-double-pipe-or-equals-really-does-5488.html-

# Newest version of Xcode has not install Xcode Command line tools
  see "Xcode Command Line Tools · Yosemite · Install"

# nil is the only Ruby object that is false in a boolean context, apart from false itself;
  even 0 are true. (All other Ruby objects are true)

＃ new syntax for Hash
  >> h1 = {:name => "Michael"}
  => {:name => "Michael"}
  >> h2 = {name: "Michael"}
  => {:name => "Machael"}

# When hashes are the last argument in a function call, the curly braces are optional.

# A string of spaces is not empty, but it is blank. NOte also that nil is blank, since nil isn't a string.

# symbols
  1. Symbols ARE used like this
     mystring = :steveT
     mystring = :steveT.to_s
     myint = :steveT.to_i
     attr_reader :steveT
  2. A Ruby symbol is a thing that has both a number(integer) representation and a string representation.
  3. A Ruby symbol cannot be changed at runtime; Multiple use of the same symbol have the same object ID and are the same object.

# RVM set default
  $ rvm --default use 2.1.1

# Net::NTLM is not available. Install via gem install rubyntlm.
  In Gemfile: gem 'httpi', '2.2.5'
  could solve this problem.

# yield in .erb
  Without any arguments, yield will render the template of the current controller/action.
  When you pass yield an argument, it lets you define content in your templates that you want to be rendered outside of that template.

  eg.
  show.html.erb
  <% content_for :footer do %>
    This content will show up in the footer section
  <% end %>

  layout/car_general.html.erb
  <%= yield :footer %>

# provide in .erb
  provide stores a block of markup in an identifier for later use.
  The same as content_for but when used with streaming flushed straight back to the layout. In other words, if you want to concatenate several times to the same buffer when rendering a given template, you should use content_for, if not, use provide to tell the layout to stop looking for more contents.

# require and include/extend
  require will check if have the define and run the required file
  :Require The require method allows you to load a library and prevents it from being loaded more than once. The require method will return ‘false’ if you try to load the same library after the first time. The require method only needs to be used if library you are loading is defined in a separate file, which is usually the case.
  
  include a module in a class will add instance method
  extend  a module in a class will add class method
  Module cannot be required, only be inluded/extend

# indifferent_hash
  Create a hash with indifferent access


#  Database connections will not be closed automatically, please close your
database connection at the end of the thread by calling `close` on your
connection.  For example: ActiveRecord::Base.connection.close

# blank? nil? empty? present?
  nil? When the value is nil for each object.
    empty? To check for the empty string, array, hash.
    blank? To check the object has a value of nil
    present? The opposite of blank? 

  Finally, With different conditions you can choose best suited methods.
  Note: .blank? and .present? are rails methods.

# consider #includes(), #preload(), #eager_load()
  http://blog.arkency.com/2013/12/rails4-preloading/
  http://stackoverflow.com/questions/5706437/whats-the-difference-between-inner-join-left-join-right-join-and-full-join

# A config.ru file is recommended if:

You want to deploy with a different Rack handler (Passenger, Unicorn, Heroku, …).
You want to use more than one subclass of Sinatra::Base.
You want to use Sinatra only for middleware, and not as an endpoint.


