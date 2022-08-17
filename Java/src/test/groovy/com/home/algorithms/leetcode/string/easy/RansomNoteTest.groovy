package com.home.algorithms.leetcode.string.easy

import spock.lang.Specification

class RansomNoteTest extends Specification {
    def "should determine if ransom note can be assembled"() {
        given: 'instance'
        def instance = new RansomNote()

        when: 'method called'
        def res = instance.canConstruct(note, magazine)

        then: 'verify result'
        res == expected

        where: 'parameters'
        note    | magazine        | expected
        "abc"   | "cbaa"          | true
        "q we"  | "abwc zbre qqq" | true
        " "     | " "             | true
        ""      | ""              | false
        "asd"   | ""              | false
        null    | "asd"           | false
        "asd"   | null            | false
        "tyu"   | "abcdef"        | false
        "tyu"   | "abcdefty"      | false
        "t y u" | "abcdeftyu"     | true
    }
}
