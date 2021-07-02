'use strict';

function perm(array, subIndex) {
    if (subIndex === array.length) {
        console.log(array);
    }
    
    for (let i = subIndex; i < array.length; i++) {
        let tmp = array[subIndex];
        array[subIndex] = array[i];
        array[i] = tmp;

        perm(array, subIndex + 1);

        array[i] = array[subIndex];
        array[subIndex] = tmp;
    }
}

perm(['A', 'B', 'C'], 0);
