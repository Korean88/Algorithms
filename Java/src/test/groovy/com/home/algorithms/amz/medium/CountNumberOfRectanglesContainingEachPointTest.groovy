package com.home.algorithms.amz.medium

import spock.lang.Specification

class CountNumberOfRectanglesContainingEachPointTest extends Specification {

    def instance = new CountNumberOfRectanglesContainingEachPoint()

    def 'test solution'() {
        given: 'parameterized test'
        when: 'method called'
        def res = instance.countRectangles(rectangles as int[][], points as int[][])

        then: 'verify'
        res == expected as int[]

        where: 'parameters'
        rectangles               | points           | expected
        [[1, 2], [2, 3], [2, 5]] | [[2, 1], [1, 4]] | [2, 1]
        [[1, 1], [2, 2], [3, 3]] | [[1, 3], [1, 1]] | [1, 3]
        [[1, 1], [2, 2], [3, 3], [4, 1], [3, 1]] | [[1, 3], [1, 1]] | [1, 5]
        [[81, 69], [85, 18], [4, 89], [2, 23], [29, 25],
         [19, 98], [77, 74], [100, 98], [61, 5],
         [11, 57], [23, 4], [2, 55], [8, 77], [23, 79],
         [4, 69], [4, 33], [44, 69], [93, 47], [77, 4],
         [44, 91], [11, 54], [35, 67], [59, 90], [34, 59],
         [16, 25], [93, 6], [37, 14], [88, 51], [13, 69],
         [16, 26], [77, 7], [6, 63], [3, 41], [90, 89],
         [97, 35], [75, 49], [96, 94], [80, 16], [96, 59]] | [[26, 16], [58, 70], [64, 58], [52, 2], [85, 98],
                                                             [75, 93], [12, 3], [2, 25], [79, 90], [36, 35],
                                                             [45, 40], [12, 34], [2, 71], [63, 88], [74, 91],
                                                             [78, 90], [73, 19], [95, 92], [43, 7], [9, 28]] | [18, 5, 6, 17, 1, 2, 29, 30, 2, 13, 10, 18, 10, 3, 2, 2, 10, 2, 16, 20]
    }

}
