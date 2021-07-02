'use strict';

(function() {
    function lengthCal(nums, prev, curpos) {
        if (curpos == nums.length) {
            return 0;
        }
        let taken = 0;
        if (nums[curpos] > prev) {
            taken = 1 + lengthCal(nums, nums[curpos], curpos + 1);
        }
        let nottaken = lengthCal(nums, prev, curpos + 1);
        return Math.max(taken, nottaken);
    }

    function lengthOfLIS(nums) {
        return lengthCal(nums, Number.MIN_VALUE, 0);
    }

    function prompt(question, callback) {
        let stdin = process.stdin;
        let stdout = process.stdout;

        stdin.resume();
        stdin.setEncoding('utf8');
        stdout.write(question);

        stdin.once('data', function(data) {
            callback(data.toString().trim());
        });
    }

    prompt('please enter numbers: \n', function(data) {
        let value = data.split(',').map(function(num) {
            return Math.round(num);
        });
        console.log(lengthOfLIS(value));
    });
})();

