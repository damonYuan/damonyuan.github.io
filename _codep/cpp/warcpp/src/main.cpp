//
// Created by Damon on 2/6/18.
//

#include <iostream>
#include <string>
#include "dictionary.h"

using namespace std;

int main() {
    cout << "scheck version 0.1" << endl;
    Dictionary d( "mydict.dat" );
    string word = "dog";
    if ( d.Check( word ) ) {
        cout << word << " is OK\n";
    }
    else {
        cout << word << " is misspelt \n";
    }
}