'use strict';

function Lis(nums) {
    this.nums = nums;
    Object.defineProperty(this, "nums", {
        get: () => nums,
        set: (newNums) => {
            nums = newNums;
        },
        configurable: false
    });

    this.length = () => {
        var dp = new Array();
        for (var i = 0; i < this.nums.length; i++) {
            var insert = this.binarySearch(dp, this.nums[i]);
            if (insert > dp.length - 1) {
                dp.splice(insert, 0, this.nums[i]);
            } else {
                dp[insert] = this.nums[i];
            }
        }
        return dp.length;
    }

    this.binarySearch = (dp, num) => {
        var low = 0;
        var high = dp.length - 1;
        while (low <= high) {
            var mid = Math.ceil((low + high) / 2.0);
            if (dp[mid] < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}

function prompt(question, callback) {
    var stdin = process.stdin,
        stdout = process.stdout;

    stdin.resume();
    stdin.setEncoding('utf8');
    stdout.write(question);

    stdin.once('data', function (data) {
        callback(data.toString().trim());
    });
}

prompt("Please enter numbers: ", function(value) {
    var arr = value.split(',').map(function (num) {
        return parseInt(num);
    });
    var lis = new Lis(arr);
    console.log("the length of longest increasing sequence: " + lis.length());
});
