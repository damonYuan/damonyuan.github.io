//
// Created by Damon on 2/6/18.
//

#ifndef WARCPP_DICTIONARY_H
#define WARCPP_DICTIONARY_H

#include <string>

class Dictionary {
public:
    Dictionary( const std::string & fname );
    bool Check( const std::string & word  ) const;
};

#endif //WARCPP_DICTIONARY_H
