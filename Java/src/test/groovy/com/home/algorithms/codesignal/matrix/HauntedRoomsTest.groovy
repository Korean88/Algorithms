package com.home.algorithms.codesignal.matrix

import com.home.algorithms.codesignal.matrix.HauntedRooms
import spock.lang.Specification

class HauntedRoomsTest extends Specification {

    def instance = new HauntedRooms()

    def 'test haunted rooms'() {
        given: 'parameterized test'
        when: 'method called'
        def res = instance.solution(arr as int[][])

        then: 'verify'
        res == expected

        where: 'parameters'
        arr                                        | expected
        [[0, 1, 1, 2], [0, 5, 0, 0], [2, 0, 3, 3]] | 9
    }
}