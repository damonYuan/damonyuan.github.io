var fs = require('fs');

// helper functions
var count = 0;
var keywordToFind = 'TCP';

fs.readFile(__dirname + '/input.txt', 'utf8', function(err,data) {
	if (err) {
		return console.log('file not found');
	}
	//console.log(data);

	// fake map reduce calls
	var lines = data.split('\n');
	for (var i=0;i<lines.length;i++) {
		map(i, lines[i]);
	}
	for (var key in context.map) {
		reduce(key, context.read(key));
	}
	// OUTPUT ALL KEYS AND THEIR FINAL COUNT
	//for (var key in result.map) {
	//	console.log(key, result.read(key))
	//}
	printResult();
});

// *** Start your code here *** //

var context = {
	map: {},
    put: function(key, value) {
        this.map[key] = value;
    },
	read: function(key) {
        return this.map[key];
    }
};

var result = {
	map: {},
    put: function(key, value) {
        this.map[key] = value;
    },
    read: function(key) {
        return this.map[key];
    }
};

function map(key, value) {
    var mapper = function (item) {
        var re = /[\s()]+/g;
        return item.split(re);
    };
    context.put(key, mapper(value));
}

function reduce(key, values) {
    var reducer = function(intermediate, current) {
        if (current) {
            intermediate[current] = (intermediate[current] || 0) + 1;
        }
        return intermediate;
    };
    values.myReduce = myReduce;
	values.myReduce(reducer, result.map);
    count = result.read(keywordToFind);
}

function myReduce(callback, initialValue) {
    var accumulator = (initialValue === undefined) ? undefined : initialValue;
    for (var i = 0; i < this.length; i++) {
        if (accumulator !== undefined) {
            accumulator = callback.call(undefined, accumulator, this[i], i, this);
        } else {
            accumulator = this[i];
        }
    }
    return accumulator;
}

// *** End your code here *** //

function printResult() {
	console.log(count);
}
