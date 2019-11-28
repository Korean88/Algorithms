package com.home.algorithms.string

import spock.lang.Specification

class LongestWordFromCharactersTest extends Specification {

    LongestWordFromCharacters longestWordFromCharacters = new LongestWordFromCharacters()

    def 'should return 2 longest words'() {
        given: "array of chars and dictionary of words"
        def array = ['e','o','t','s'] as char[]
        def dictionary = ["otse", "tse", "eo", "stoe"] as Set<String>

        when: 'find words is called'
        def res = longestWordFromCharacters.findWords(array, dictionary);

        then: 'result has 2 longest words from the dictionary'
        res.size() == 2
        res == ["stoe", "otse"] as List<String>
    }
}
