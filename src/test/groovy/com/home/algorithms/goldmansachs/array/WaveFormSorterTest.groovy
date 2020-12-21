package com.home.algorithms.goldmansachs.array

import spock.lang.Specification

class WaveFormSorterTest extends Specification {

    WaveFormSorter waveFormSorter = new WaveFormSorter()

    def 'should sort input array in wave form'() {
        given: 'input array parameterized'
        when: 'method called'
        def actual = waveFormSorter.sortInWaveForm(input as int[])

        then: 'compare'
        actual == expected as int[]

        where: 'parameters'
        input                    | expected
        [3, 5, 1, 2, 4, 8, 7, 6] | [1, 8, 2, 7, 3, 6, 4, 5]
        [6, 3, 7, 4, 1, 8, 2]    | [1, 8, 2, 7, 3, 6, 4]
        null                     | null
        []                       | null
        [1]                      | [1]
        [22, 22]                 | [22, 22]
    }
}
