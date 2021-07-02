NodeJS
==============

#1. Installation
    1. install node: 
       $ brew install node
    2. npm:
       npm is Node's package manager. It is now installed automatically with Node.js so there is no need to do a separate installation.
       $ npm -v 
       check the version of npm
   
#2. process.nextTick() http://howtonode.org/understanding-process-next-tick
    1. IO bound vs CPU bound 
       IO bound is typically associated with disk.
    2. what is actually does is defer the execution of an action till the next pass around the event loop.
    3. keeping callbacks truly asynchronous.
       process.nextTick(function() {
       	  callback(data == 'foo');
       	});

#3. use Cluster for multi-core server

#4. Javascript object treasure map:
    http://zeekat.nl/articles/constructors-considered-mildly-confusing.html
    https://javascriptweblog.wordpress.com/2010/06/07/understanding-javascript-prototypes/

    Ojbect.getPrototypeOf(a); == // Fails in Opera or IE<=8
    a.__proto__; ==   // Fails in IE
    a.constructor.prototype; (a.prototype.constructor.prototype; actually) // All

    prototype is for function(class), for an instance, it is hidden and need to use the method above to retreive.

    A function’s prototype property is the object that will be assigned as the prototype to all instances created when this function is used as a constructor.

    A.prototype == A.__proto__; //false
    A.__proto__ == Function.prototype; //true - A's prototype is set to its constructor's prototype property

#5. Node.js for CPU-bound tasks:  //TODO
    http://neilk.net/blog/2013/04/30/why-you-should-use-nodejs-for-CPU-bound-tasks/
    http://neilk.net/blog/2013/04/16/letterpwn-a-nodejs-base d-letterpress-solver/

#6. https://github.com/promises-aplus/promises-spec
    libraries: Q, when, WinJS, RSVP.js
    https://github.com/kriskowal/q
    https://strongloop.com/strongblog/promises-in-node-js-with-q-an-alternative-to-callbacks/

#7. use strict mode
    http://www.w3schools.com/js/js_strict.asp

#8. 1. use api version to determine the data that should be returned.
    2. set the default value if the value is required.
    3. use __v to get mongoose version key.

    Always add a new field, do not change the column that has already in production and will have impact on current users.
#8. node.js better not use session to store info. because once restart the server, all the info will get lost because the default session store for express-session is MemoryStore. And once there is a exception the whole node server will stop and need a restart.
    http://stackoverflow.com/questions/23260676/express-4-sessions-not-persisting-when-restarting-server

#9. solution for npm 'command not found'
    https://docs.npmjs.com/getting-started/fixing-npm-permissions

#10. npm 
    npm install will install both "dependencies" and "devDependencies"
    npm install --production will only install "dependencies"
    npm install --dev will only install "devDependencies"

#11. S3 image uploader: https://devcenter.heroku.com/articles/s3-upload-node 

#12. debug memory leakage: http://blog.yld.io/2015/08/10/debugging-memory-leaks-in-node-js-a-walkthrough/

#13. npm prefix 
~/.npmrc

    







