package com.home.algorithms.array

import spock.lang.Specification

class SecretSantaTest extends Specification {

    def secretSanta = new SecretSanta()

    def "should not assign numbers to themselves"() {
        given: "number of players"
        def n = numberOfMembers
        def dummy = dummyParam

        when: "assign called"
        def result = secretSanta.assign(n)

        then: "assert numbers not assigned to themselves and values unique"
        def keys = new HashSet()
        def values = new HashSet()
        result.entrySet().forEach({ e ->
            assert e.key != e.value
            assert !keys.contains(e.key)
            assert !values.contains(e.value)
            keys.add(e.key)
            values.add(e.value)
        })

        where: "parameters"
        numberOfMembers | dummyParam
        3               | null
        44               | null
        144               | null
        0               | null
        -2               | null
    }
}
