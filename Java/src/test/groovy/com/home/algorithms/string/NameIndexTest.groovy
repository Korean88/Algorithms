package com.home.algorithms.string

import spock.lang.Specification

class NameIndexTest extends Specification {

    def "should calculate name index"() {
        given: "instance"
        def instance = new NameIndex()

        when: "method call"
        def res = instance.findIndex(given)

        then: "validate"
        res == expected

        where: "parameters"
        given    | expected
        "anna"   | 7
        "zoe"    | 22
        "andrey" | 4266
    }
}
