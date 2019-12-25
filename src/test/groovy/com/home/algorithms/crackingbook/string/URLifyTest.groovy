package com.home.algorithms.crackingbook.string

import spock.lang.Specification

class URLifyTest extends Specification {

    URLify urLify = new URLify()

    def 'test solution with reverse iteration'() {
        given: 'input array and true length'

        when: 'method called'
        def res = urLify.perform(array as char[], trueLength)

        then: 'check'
        res == expected as char[]

        where: 'parameters'
        array                                                   | trueLength | expected
        ['m', 'r', ' ', 's', 'm', 'i', 't', 'h', ' ', ' ']      | 8          | ['m', 'r', '%', '2', '0', 's', 'm', 'i', 't', 'h']
        ['m', 'r', ' ', 's', ' ', 'i', ' ', ' ', ' ', ' ']      | 6          | ['m', 'r', '%', '2', '0', 's', '%', '2', '0', 'i']
        ['m', 'r', ' ', 's', ' ', 'i', ' ', ' ', ' ', ' ', ' '] | 6          | ['m', 'r', '%', '2', '0', 's', '%', '2', '0', 'i', ' ']
    }
}
