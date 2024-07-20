package com.home.algorithms.amz.medium

import spock.lang.Specification

class MinNumberOfKeypressesTest extends Specification {

    def instance = new MinNumberOfKeypresses()

    def 'test validate bst'() {
        given: 'parameterized test'
        when: 'method called'
        def res = instance.minimumKeypresses(s)

        then: 'verify'
        res == expected

        where: 'parameters'
        s              | expected
        "apple"        | 5
        "abcdefghijkl" | 15
    }
}
