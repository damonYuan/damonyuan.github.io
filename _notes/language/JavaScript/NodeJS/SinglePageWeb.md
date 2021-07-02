Single-Page web Application
===========================

1. $ brew install node.js 
root node.js comes with npm; use npm to install n; then use n to install the required node.js version. they will be installed in n's folder(under npm packages forlder).

2. $ npm install -g yo
   Yeoman is a tool that suggests an established workflow and can be incorporated into your projects. Grunt and Bower will also be installed.

3. $ npm install -g bower 
   Bower is a manager dependency for the web, but specifically for frontend packages. (list JavaScript example in a file called bower.json) 

4. $ npm install grunt-cli
   Grunt is a tool to automate build tasks done entirely in JavaScript.

5. project structure

root
|
---- css
|
---- images
|
---- js
|    |
|    ---- controllers/Collections/ViewModels
|    |
|    ---- models 
|    |
|    ---- views 
|    |
|    ---- app.js
|
---- libs 
|
---- templates 
|
---- index.html 

6. Pure CSS and Responsive Boilerplate
   1. both of them can be installed with Bower.
      $ bower install responsiveboilerplate
      $ bower install purecss

7. What happens in almost every SPA is that the data traffic from the database to the User interface is done trhough a common restful API using the JSON file format.

8. Instead of starting a new thread for each connection, it creates a process that does not require a memory block to accompany it. It does not block outgoing calls directly to I/O.

Node servers can support tens of thousands of simultaneous connections. it does not allocate one thread per connection model, but uses a model process per connection, creating only the memory that is required for each connection. It achieves its goals by providing highly scalable servers.

Node changes the panorama of the server and the bottleneck of the whole system from the maximum number of connections to the maximum traffic capacity of the system.

when you have a Node project with a file named package.json, you can run the 
$ npm install 
command in the root folder of your project and NPM will install all dependencies listed in package.json.

The NPM init command starts the configuration of your project through a step-by-step configuration to create a package.json file from scratch.

9. NPM commands
   1. $ npm install module_name
   2. $ npm install module_name-save, this installs the module and adds it to the list of dependencies on package.json 
   3. $ npm list 
   4. $ npm list -g 
   5. $ npm remove module_name 
   6. $ module_name npm update
   7. $ npm -v 
   8. $ npm adduser username, this creates a user on the NPM repository
   9. $ npm whoami, this displays details of your public profile on the NPM repository 
   10. $ npm publish, this publishes your module on the NPM repository 

10. The inline function, require(), is the easiest way to include existing modules in separate files.
    The basic behavior of require() is that it reads the JavaScript file, interprets the script and then returns the content of the exports object.

11. REPL: Read-Eval-Print Loop is a simple and interactive program that first reads phrases or sections of a program, then evaluates (or runs) it, and finally prints the result.
    $ node 

12. If the filename passed to require is the name of a directory, the function will first search in a file called package.json in the directory and then load the file referenced in the main property. Otherwise, the function will look for a file called index.js.

13. Node.js Module - exports vs module.exports 
    Your module returns module.exports to the caller ultimately, not exports. All exports does is collect properties and attach them to module.exports if module.exports doesn't have something on it already. If there's something attached to module.exports already, everything on exports is ignored.

    If you want your module to be of a specific object type, use module.exports; if you want your module to be a typical module instance, use exports. Also the result of attaching properties to module.exports is akin to attaching properties to exports.

    As long as you don't overwrite the module.exports object with an assignment operation, anything attached to module.exports and exports will be available in the 'required' module. (even module.exports.age = 68; will be undefined)

    https://cnodejs.org/topic/5231a630101e574521e45ef8 : module.exports 初始值为一个空对象 {}, exports指向这个对象。

14. Node module is a set of default variables available in the scope of each module; the following are the most common variables: 
    1. __filename, this is the filename of the code being executed.
    2. __dirname, this is the name of the directory in which you saved the script that is being excuted.
    3. process, this is an object that is associated with the process that is currently running. In addition to variables, this object has methods such as process.exit, process.cwd, and process.uptime.
    4. process.argv, this is an array that contains the command-line arguments. The first element is the node, the seconde element is the name of the JavaScript file, and the next will be all the arguments of an additional command line if they are assigned.
    5. process.stdin, process.stout, and process.stderr: these streams correspond to the standard input, standard output, and standard error output of the current process.
    6. process.env, this is an object that contains the user environment variables of the current process.
    7. require.main, when a file is executed by Node directly, require.main is assigned to this module. 
       Hence `require.main === module` tells you whether or not your script was invoked directly or required by another file.

15. The Express framework has full support for templates and rendering using the Jade engine as the default. It is very suitable for large-scale application that render HTML on the server side.

16. Node.js server and Express server 
    1. Node.js 
      var http = require('http');
      http.createServer(function (req, res) {
        res.writeHead(200, {'Content-Type': 'text/plain'});
        res.end('Hello World\n');
      }).listen(3000, "127.0.0.1");
    2. Express server 
      var express = require('express');
      var app = express();

      app.get('/', function(req, res){
        res.send('Hello Express');
      });

      app.listen(3000);

17. MongoDB is a document-oriented database; this means that all the data is stored like a JSON file. using binary JSON.
    Instead of performing a query with multiple joins such as the relational model, MongoDB executes a single query, which returns the entire document.

18. MongoDB terminology    			SQL terminology 
    database               			database 
    collection             			table 
    document/BSON document 			row 
    field                  			column
    index                  			index 
    embedded document/linking table joins 
    primaryky is _id field 			column or column combination as primary key
    aggregation pipeline            aggregation: group by 

19. SQL GROUP BY Syntax 
    The GROUP BY statement is used in conjunction with the aggregate functions to group the result-set by one or more columns.

20. install MongoDB with Homebrew
    http://www.mongodbspain.com/en/2014/11/06/install-mongodb-on-mac-os-x-yosemite/
    http://docs.mongodb.org/master/tutorial/manage-mongodb-processes/
    Find mongoDB PID: 
    ps auxwww | grep mongod

    killall -15 mongod

    mongod --dbpath <path to data directory>, so that the user has read and write permission. -> solve warning of runing mongoDB as root.

21. create a new database
    1. $ use exampledb 

22. GUI for MongoDB: UMongo,  http://www.edgytech.com/umongo/

23. MongoDB connection with Mongoose
    1. Object Relational Mapping (ORM)
    2. Object Data Mapping (ODM)

    $ npm install mongoose

    You just need add it to the application file, as shown in the following example:

    var mongoose = require('mongoose');
    mongoose.connect('mongodb://localhost/test');

    var db = mongoose.connection;

    db.on('error', console.error.bind(console, 'connection error:'));
    db.once('open', function callback () { // Hello Mongoose });

24. All we need is a schema and a model for us to work with the data to be persisted on our MongoDB database. Schemas define the structure of documents within a collection and models are used to create instances of data to be stored in documents.

    Schema types: 
    1. String
    2. Number
    3. Data
    4. Buffer
    5. Boolean
    6. Mixed
    7. ObjectId
    8. Array

    eg.

    var bandSchema = new Mongoose.Schema({
      name: { type: String },
      album: { type: String },
      track: { type: Number },
      year: { type: Number }
    }); 
    var Band = Mongoose.model('Band', bandSchema); // This line compiles the Band model using bandschema as the structure.

    * constructor function: 
    1. A constructor is any function which is used as a constructor.
    2. Built-in constructor property is something you cannot set manually.
    3. When an object is constructed, it inherits all the properties of its constructor's prototype.
       We can change the prototype later and still see the changes in the instance. But we can always override it.
    4. http://www.javascriptkit.com/javatutors/oopjs2.shtml : object Constructor and prototyping
    5. The model's instances are the documents that will be persisted by MongoDB using the save function.
    6. Collections(tables) in MongoDB have a flexible schema; this means that collections do not impose the structure of the documents.
       In practice, this means that documents from the same collection need not have the same set of fields or structure and that common fields in a collection of documents can carry different types of data. So using Mongoose to map our dadtabase standardizes the documents of the same schema. This ensures that instances of the model that compiled the schema will always have the same data type attributes specified in the schema.

25. JavaScript call-by-sharing:
    Instead, the situation is that the item passed in is passed by value. But the item that is passed by value is itself a reference. Technically, this is called call-by-sharing.

    For objective-C, what is passed is a pointer or a value type, and it only support pass-by-value.
    note: http://stackoverflow.com/questions/22213197/is-objective-c-pass-by-value-or-pass-by-reference

Chapter 3

1. use Hackathon starter
   note: nodemon, it watches for any changes in your node.js app and automatically restart the server. nodemon app.js.

   Note: before node app.js, ensure the MongoDB is running.

2. MEAN.JS 

Chapter 4

1. use https://github.com/expressjs/generator to init 
2. changing the initialization process
3. ( new Foo ).__proto__ === Foo.prototype
   ( new Foo ).prototype === undefined
4. app.use() to install middleware. ??? How the middleware works in node.js
   http://expressjs.com/guide/using-middleware.html 
5. $ export NODE_ENV=production
   $ node meadowlark.js
6. $ npm install passport passport-local --save
   $ npm install connect-flash --save
7. process.nextTick();
   https://spring.io/understanding/javascript-promises

8. test framework: 
   1. Mocha and Supertest for HTTP assertions
   2. Should.js for BDD style test.
9. set a default version: $ vm alias default 0.10.29 
10. https://strongloop.com/strongblog/nodejs-testing-documenting-apis-mocha-acquit/

```
you don't want your library tests to fail depending on the machine setup (mocha as global, global mocha version, etc), the way to use the local mocha that works cross-platform is:

node node_modules/.bin/mocha
npm puts aliases to all the binaries in your dependencies on that special folder. Finally, npm will add node_modules/.bin to the PATH automatically when running an npm script, so in your package.json you can do just:

"scripts": {
  "test": "mocha"
}
and invoke it with

npm test
```
11. set the node environment value:
    1. $ export NODE_ENV=development
       $ node server.js 
    2. npm test
       "test": "NODE_ENV=test mocha"

12. mongoose migrate











    



