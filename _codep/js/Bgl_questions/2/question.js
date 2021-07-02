#!/usr/bin/env node
'use strict';

// Input
var digits = 123456789;

// Add each result as a string to this array
var results = [];

console.log('start', digits);

// **************************** //
// *** Start your code here *** //
// **************************** //

results = findSolutions(digits, 100);

function findSolutions(digits, searchSum) {
    try {
        validate(digits, searchSum);
    } catch (e) {
        console.log(e.message);
        return [];
    }

    var digitsArray = getDigitsArray(digits);
    var paths = findPaths(searchSum, digitsArray[0], Array.prototype.slice.apply(digitsArray, [1]));

    var solutions = paths.map(function(path) {
        var solution = '';
        for (var node of path) {
            solution += " " + node;
        }
        solution += " = " + searchSum;
        solution = solution.replace(/ & /g, '');
        return solution;
    });

    return solutions;
}

function validate(digits, searchSum) {
    var isValid = /^\d+$/.test(digits);
    if (!isValid) {
        throw new Error('Invalid digits');
    }
    isValid = /^\d+$/.test(searchSum);
    if (!isValid) {
        throw new Error('Invalid search sum');
    }
    if (isNaN(digits)) {
        throw new Error('digits is not a number');
    }
    if (isNaN(searchSum)) {
        throw new Error('search sum is not a number');
    }
}

function getDigitsArray(digits) {
    var output = [];
    var digit = 0, tmp = digits;
    do {
        digit = tmp % 10;
        Array.prototype.push.apply(output, [digit]);
        tmp = Math.floor(tmp / 10);
    } while(tmp > 0);
    return Array.prototype.reverse.apply(output);
}

function concatPrefix(prefix, paths) {
    return paths.filter(function(p) { return p.length > 0; })
        .map(function(p) { return prefix.concat(p); });
}

function findPaths(sum, previousNumber, restDigits) {
    var previousDigit = Math.abs(previousNumber % 10);
    if (restDigits.length === 0) {
        return sum == previousNumber ? [[previousDigit]] : [];
    }

    var currentDigit = restDigits[0];
    var concatenatedNumber = previousNumber >= 0 ? 10 * previousNumber + currentDigit : 10 * previousNumber - currentDigit;
    var nextRestDigits = Array.prototype.slice.apply(restDigits, [1]);

    var plusPaths = findPaths(sum - previousNumber, currentDigit, nextRestDigits);
    var minuspaths = findPaths(sum - previousNumber, -currentDigit, nextRestDigits);
    var concatPaths = findPaths(sum, concatenatedNumber, nextRestDigits);

    var paths = [];
    Array.prototype.push.apply(paths, concatPrefix([previousDigit, '+'], plusPaths));
    Array.prototype.push.apply(paths, concatPrefix([previousDigit, '-'], minuspaths));
    Array.prototype.push.apply(paths, concatPrefix([previousDigit, '&'], concatPaths));

    return paths;
}

// ************************** //
// *** End your code here *** //
// ************************** //

// here we log the results by looping through and logging them
for (var result of results) {
  // output to stdout should have syntax `1 + 23 - 4 + 5 + 6 + 78 - 9 = 100`
  console.log(result);
}
