package com.home.algorithms.score


import spock.lang.Specification

class BestAverageScoreTest extends Specification {

    BestAverageScore bestAverageScore = new BestAverageScore()

    def 'test streams solution'() {
        given: 'input array'
        def input = inputArray as Object[][]

        when: 'apply'
        def res = bestAverageScore.bestAvgScore(input)

        then: 'validate'
        res == expected as Object[]

        where: 'parameters'
        inputArray | expected
        [["Jake",650],["Mike",660],["Steve",620],["Jake",700],["Mike",650]] | ["Jake",675.0]
        [["Jake",650],["Mike",660],["Steve",620],["Jake",700],["Mike",850]] | ["Mike", 755.0]
    }

}
