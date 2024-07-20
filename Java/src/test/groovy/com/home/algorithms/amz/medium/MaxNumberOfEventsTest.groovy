package com.home.algorithms.amz.medium

import spock.lang.Specification

class MaxNumberOfEventsTest extends Specification {

    def instance = new MaxNumberOfEvents()

    def 'test solution'() {
        given: 'parameterized test'
        when: 'method called'
        def res = instance.maxEvents(events)

        then: 'verify'
        res == expected

        where: 'parameters'
        events                                              | expected
        [[1, 2], [2, 3], [3, 4]] as int[][]                 | 3
        [[1, 2], [2, 3], [3, 4], [1, 2]] as int[][]         | 4
        [[1, 4], [4, 4], [2, 2], [3, 4], [1, 1]] as int[][] | 4
        [[1, 5], [1, 5], [1, 5], [2, 3], [2, 3]] as int[][] | 5
        [[52, 79], [7, 34]] as int[][]                      | 2
        [[1, 2], [1, 2], [3, 3], [1, 5], [1, 5]] as int[][] | 5
        [[1, 2], [1, 2], [1, 6], [1, 2], [1, 2]] as int[][] | 3
        [[27,27],[8,10],[9,11],[20,21],[25,29],
         [17,20],[12,12],[12,12],[10,14],[7,7],
         [6,10],[7,7],[4,8],[30,31],[23,25],[4,6],
         [17,17],[13,14],[6,9],[13,14]] as int[][]          | 18
    }

}
