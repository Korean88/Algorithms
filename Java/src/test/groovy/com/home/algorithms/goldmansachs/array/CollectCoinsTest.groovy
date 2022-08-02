package com.home.algorithms.goldmansachs.array

import spock.lang.Specification

class CollectCoinsTest extends Specification {

    CollectCoins collectCoins = new CollectCoins()

    def 'test collect coins traversal'() {
        given: 'parameterized test'
        when: 'method called'
        def res = collectCoins.maxCoins(input as char[][])

        then: 'verify'
        res == expected

        where: 'parameters'
        input                       | expected
        [['e', 'c', 'c', 'c', 'c'],
         ['c', '#', 'c', '#', 'e'],
         ['#', 'c', 'c', '#', 'c'],
         ['c', 'e', 'e', 'c', 'e'],
         ['c', 'e', '#', 'c', 'e']] | 8
        [['e', 'c', 'c', 'c', 'c'],
         ['c', '#', 'e', '#', 'e'],
         ['#', 'c', 'c', '#', 'c'],
         ['e', 'c', 'e', 'c', 'e'],
         ['c', 'e', '#', 'c', 'e'],
         ['e', '#', 'c', 'c', 'e']] | 9
    }
}
