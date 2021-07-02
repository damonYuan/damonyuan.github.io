//
// Created by Damon on 2/6/18.
//

#ifndef WARCPP_DICTIONARY_H
#define WARCPP_DICTIONARY_H

#include <string>
#include <set>

class Dictionary {
    public:
        Dictionary( const std::string & fname ) {
            mWords.insert( "dog" );
        }
        bool Check( const std::string & word ) const {
            return mWords.find( word ) != mWords.end();
        }
    private:
        std::set <std::string> mWords;
};

#endif //WARCPP_DICTIONARY_H
