JavaScript
==============
# IDE: sublime
1. cmd + shift + P to open the Command Palette, then typing package control and open, then install package.
2. autocompletion and function tooltips: SublimeCodeIntel
3. bracket highlight: BracketHighlighter
4. sidebar standard file and project manipulation options: SidebarEnhancements
5. SublimeLinter
6. HTML Tidy: brew install tidy, sublimeLinter-html-tidy
7. CSSlint, sublimeLinter
8. JSHint, sublimeLinterJSHint, JSFormat, JavaScriptNext
   JSHint configuration:
   https://github.com/jshint/jshint/blob/master/examples/.jshintrc
9. Terminal, cmd + shift + t : open terminal in current file's directory
10. All AutoCompleteˇ
11. Git
12. Markdown Preview
13. SublimeERB
14. install node.JS version manage: n 
15. a(Using JSC (Mac OS X)). Create a JS console: http://www.wikihow.com/Create-a-Javascript-Console-in-Sublime-Text
    1. Open the Javascript file that you want to run in Sublime Text.
    2. Use debug() instead of console.log() in your script.
    3. Go to "Tools > Build System" in the top bar and select "JSC". This is the build system that you just created.
    4. Build the Javascript file, using either the shortcut (^ Ctrl+B for Windows, and ⌘ Command+B for Mac), or by choosing "Build" from the "Tools" menu. A console will now appear in a pane at the bottom of the window, showing the results of your script!
    
    b(using node.js ).  
    1. Open the Javascript file that you want to run in Sublime Text.
    2. Go to "Tools > Build System" in the top bar and select "node". This is the build system that you just created.
    3. Build the Javascript file, using either the build shortcut (^ Ctrl+B for Windows, and ⌘ Command+B for Mac), or by choosing "Build" from the "Tools" menu. A console will now appear in a pane at the bottom of the window, showing the results of your script!
16. SASS
17. $ n use 0.9.4 some.js
18. handlebars

# install node and npm?
1. system install: sudo npm uninstall npm -g;
2. brew install: use it !!!
   1. brew install npm(it will install node as well)
   2. Error: Could not symlink share/systemtap/tapset/node.stp
      solution: sudo chown -R $USER /usr/local/share/systemtap/tapset
3. n install globally
   Damons-MacBook-Pro-2:~ Damon$ npm install -g n
      /usr/local/bin/n -> /usr/local/lib/node_modules/n/bin/n
      n@1.3.0 /usr/local/lib/node_modules/n
4. $ n 0.12.2 
   to install node in /usr/local/n/versions/node/0.12.2
5. $ npm install -g bower

# init a project
  1. create dir xxx_project/site
  2. cd into site folder and run $ npm init and create a nonempty README.md file to squelch the warning.
  3. npm install --save express
     --save will update the packeage.json file 
  4. add .gitignore in xxx_project dir 
  5. $ git init :in xxx_project dir 
     push to remote
  6. create the entry point (app file) such as index.js/app.js/server.js/project_name.js 
     Note: the var set through app.set() can be accessed through app.settings object
     Note: res.status(200); res.type(); res.set(); res.send('') -> for API
           res.status(200); res.render('home') -> for web
     Note: add public folder:
           before declare any routes, you'll add the static middleware; The static middleware has the same effect as creating a route for each static file you want to deliver that renders a file and returns it to the client.
  
# create your own module
  1. create a dir called 'lib'
  2. in that folder, create a file called fortune.js
     Note: if you want something to be visible outside of the module, you have to add it to exports.
  3. It is traditional(but not required) to specify imports at the top of the file:
     var fortune = require('./lib/fortune.js');

# tests
  1. logic and presentation; unit test and integration test; Generally, unit testing for logic testing. Integration testing is useful in both realms
  2.  Mocha for Page testing; Zombie.js(Selenium, PhantomJS and Zombie) for cross-page testing; logic testing; JSHint for linting; Link checking falls under the category of unit testing. We will be using LinkChecker for this.
      Mocha --save-dev instead of --save; 

      put Mocha resources in the public folder: public/vendor:
        $ mkdir public/vendor
        $ cp node_modules/mocha/mocha.js public/vendor 
        $ cp node_modules/mocha/mocha.css public/vendor;

      Tests usually require a function called assert(or expect). This is available in the Node framework, but not inherently in a browser, so using the Chai:
        $ npm install --save-dev chai
        $ cp node_modules/chai/chai.js public/vendor 

      Note: use ?test=1 to enable the tests. Using some middleware to detect test = 1 in the querystring. IT MUST APPEAR BEFORE WE DEFINE ANY ROUTES IN WHICH WE WISH TO USE IT.

      Noet: the res.locals object is part of the context that will be passed to views.

      Zombie.js:
        $ npm install --save-dev zombie
      Note: setup === before :each 
            When test: mocha -u tdd -R spec qa/tests-crosspage.js 2>/dev/null(make sure you have Mocha installed globally)

            Error: Use of const in strict mode: mocha -u --harmony tdd -R spec xxxxx
            Note: fix crosspage test issue: https://gist.github.com/evolvingtech/18893351c6356e302c74

  3. automatically restart server when it detects changes in JavaScript.
     nodemon; Grunt plugin.

# update a brew installed npm:
  $ npm update -gf
  $ brew unlink node && brew link --overwrite node

  Adding -f to npm -g update makes it a forced update. With that flag, npm will no longer refuse to delete /usr/local/bin/npm. Well, at least that’s how I understand it. Be careful though, as it’s not a safe thing to do. But I like to live dangerously, so yeah. In case you want to play safe, don’t add the -f flag on npm -g update. Instead, only forcefully update those packages that won’t update without the -f flag. In my case, that’s npm.
  The second line is to fix the broken homebrew links.

# <script src="//code.jquery.com/jquery-2.0.2.min.js"></script>
  Using jQuery here because, in addition to using it as our primary DOM manipulation library for the site, we can use it to make test assertions.

# JavaScript libraries should be loaded last, right before the closing </body> tag.
  Why?

# update nmp -> 
  $ npm install -g npm

# public, private and privileged in js: 
  http://javascript.crockford.com/private.html

# all kinds of async : https://thomashunter.name/blog/the-long-road-to-asyncawait-in-javascript/

# all this 
  http://bjorn.tipling.com/all-this

# app.use and app.all 
  http://stackoverflow.com/questions/14125997/difference-between-app-all-and-app-use

# apply and call 
  logFoo.apply(thing, ["using apply"]);
  logFoo.call(thing, "using call");
  logFoo.bind(thing)("using bind");

# As with any function in JavaScript, the scope is inherited from where it is defined, not where it is invoked.

# the let keyword has officially been added to the ES6 specification. It can be used alternatively to the var keyword and supports the declaration of block scope local variables.

# react native route 

# EventTarget.addEventListener
  EventTarget may be an Element in a document, the Document itself, a Window, or any other object that support event, such as XMLHttpRequest.

# To quote Ben Cherry’s excellent article: “Function declarations and function variables are always moved (‘hoisted’) to the top of their JavaScript scope by the JavaScript interpreter”.

Variable Declarations get hoisted but their Assignment Expressions don’t. 

# three ways to define a class: https://www.phpied.com/3-ways-to-define-a-javascript-class/

- function
- Using object literals
- Singleton using a function



