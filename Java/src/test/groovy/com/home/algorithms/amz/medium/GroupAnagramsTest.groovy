package com.home.algorithms.amz.medium

import spock.lang.Specification

class GroupAnagramsTest extends Specification {

    def instance = new GroupAnagrams()

    def 'test reveal cards'() {
        given: 'parameterized test'
        when: 'method called'
        def res = instance.groupAnagrams(strs as String[])

        then: 'verify'
        res.size() == expected.size()
        for (List<String> l : res) {
            Collections.sort(l)
            expected.contains(l)
        }

        where: 'parameters'
        strs                                       | expected
        ["eat", "tea", "tan", "ate", "nat", "bat"] | [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]
        [""] | [[""]]
        ["a"] | [["a"]]
    }

}
