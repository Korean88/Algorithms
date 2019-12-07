package com.home.algorithms.score

import org.apache.commons.lang3.tuple.Pair
import spock.lang.Specification

class BestAverageScoreTest extends Specification {

    BestAverageScore bestAverageScore = new BestAverageScore()

    def 'test with HashMap'() {
        given: 'input array'
        def input = [["Jake":650],["Mike":660],["Steve":620],["Jake":700],["Mike":650]] as Object[][]

        when: 'apply'
        def res = bestAverageScore.findWithHashMap(input)

        then: 'Jake wins'
        res == Pair.of("Jake", 675)
    }

    def 'test with HashMap 2'() {
        given: 'input array'
        def input = [["Jake":650],["Mike":660],["Steve":620],["Jake":700],["Mike":850]] as Object[][]

        when: 'apply'
        def res = bestAverageScore.findWithHashMap(input)

        then: 'Mike wins'
        res == Pair.of("Mike", 755)
    }
}
