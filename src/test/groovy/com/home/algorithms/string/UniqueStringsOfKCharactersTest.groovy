package com.home.algorithms.string

import spock.lang.Specification

class UniqueStringsOfKCharactersTest extends Specification {

    UniqueStringsOfKCharacters uniqueStringsOfKCharacters = new UniqueStringsOfKCharacters()

    def 'test recursive with loop'() {
        given: 'array and length of unique Strings k'
        def inputArray = ['a', 'b'] as char[]
        int k = 3

        when: 'run method'
        def res = []
        uniqueStringsOfKCharacters.find(inputArray, k, "", res)

        then: '8 unique combinations'
        res.sort({ a, b -> (a <=> b) }) == ['aaa','aab','aba','abb','baa','bab','bba','bbb']
    }

}
