#!/usr/bin/env node
'use strict';

// Example input
var exampleInput = [7,7,4,0,9,8,2,4,1,9];

// Other examples can be passed via command line arguments like `node question.js '[1, 2, 3, 4, 5]'`
var commandLineInput = process.argv[2] && JSON.parse(process.argv[2]);

// Command line arguments take priority over example input
var numbers = commandLineInput || exampleInput;

console.log('start', numbers);

// **************************** //
// *** Start your code here *** //
// **************************** //

function segregateEvenOdd(input) {
    var left = 0, right = input.length - 1;
    while (left < right) {
        while (input[left] % 2 === 0 && left < right) {
            left++;
        }

        while (input[right] % 2 === 1 && left < right) {
            right--;
        }

        if (left < right) {
            var tmp = input[left];
            input[left] = input[right];
            input[right] = tmp;
            left++;
            right--;
        }
    }
}

segregateEvenOdd(exampleInput);

// ************************** //
// *** End your code here *** //
// ************************** //

// here we log the results
// output to stdout should have syntax `[ 1, 2, 3, 4, 5 ]`
console.log(numbers);
