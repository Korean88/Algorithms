package com.home.algorithms.crackingbook.array

import spock.lang.Specification

class ZeroMatrixTest extends Specification {

    ZeroMatrix zeroMatrix = new ZeroMatrix()

    def 'test arrays with flags'() {
        given: '2-dimensional array'
        def matrix =input as int[][]

        when: 'method called'
        def res = zeroMatrix.nullifyMatrix(matrix)

        then: 'check'
        res == expected as int[][]

        where: 'parameters'
        input              | expected
        [[1, 2, 3, 4],
         [3, 5, 0, 8],
         [99, 0, 12, 11],
         [77, 33, 44, 55]] | [[1, 0, 0, 4],
                              [0, 0, 0, 0],
                              [0, 0, 0, 0],
                              [77, 0, 0, 55]]
        [[3, 5, 88, 8],
         [99, 4, 0, 11],
         [77, 33, 44, 55]] | [[3, 5, 0, 8],
                              [0, 0, 0, 0],
                              [77, 33, 0, 55]]
    }
}
