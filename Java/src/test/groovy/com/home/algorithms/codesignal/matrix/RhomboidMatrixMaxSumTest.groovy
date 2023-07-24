package com.home.algorithms.codesignal.matrix

import spock.lang.Specification

class RhomboidMatrixMaxSumTest extends Specification {

    def instance = new RhomboidMatrixMaxSum()

    def 'Given a matrix, find the maximum rhomboid sum with radius k'() {
        given: 'parameterized test'
        when: 'method called'
        def res = instance.solution(matrix as int[][], radius)

        then: 'verify'
        res == expected

        where: 'parameters'
        matrix                  | radius | expected
        [[0, 0, 0, 4, 0, 0, 0],
         [0, 0, 3, 3, 3, 0, 0],
         [0, 3, 2, 2, 2, 3, 0],
         [4, 3, 2, 1, 2, 3, 4],
         [0, 3, 2, 2, 2, 3, 0],
         [0, 0, 3, 3, 3, 0, 0],
         [0, 0, 0, 4, 0, 0, 0]] | 4      | 69

        [[9, 9, 9, 5, 9, 9, 9],
         [9, 9, 4, 3, 3, 9, 9],
         [9, 3, 5, 2, 2, 3, 9],
         [4, 3, 3, 9, 2, 3, 4],
         [9, 3, 2, 2, 4, 3, 9],
         [9, 9, 3, 5, 4, 9, 9],
         [9, 9, 9, 4, 9, 9, 9]] | 4      | 88

        [[9, 9, 9, 5, 4, 9, 9],
         [9, 9, 4, 3, 8, 1, 9],
         [9, 3, 5, 7, 6, 5, 9],
         [4, 3, 6, 9, 1, 7, 8],
         [9, 3, 2, 7, 9, 6, 9],
         [9, 9, 3, 5, 5, 3, 9],
         [9, 9, 9, 4, 2, 9, 9]] | 3      | 84
    }
}
