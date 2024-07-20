package com.home.algorithms.amz.medium

import spock.lang.Specification

class RevealCardsInIncreasingOrderTest extends Specification {

    def instance = new RevealCardsInIncreasingOrder()

    def 'test reveal cards'() {
        given: 'parameterized test'
        when: 'method called'
        def res = instance.deckRevealedIncreasing(deck as int[])

        then: 'verify'
        res == expected as int[]

        where: 'parameters'
        deck                     | expected
        [17, 13, 11, 2, 3, 5, 7] | [2, 13, 3, 11, 5, 17, 7]
        [1, 1000]                | [1, 1000]
    }

}
