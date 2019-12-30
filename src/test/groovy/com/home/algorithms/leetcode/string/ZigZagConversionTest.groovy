package com.home.algorithms.leetcode.string

import spock.lang.Specification

class ZigZagConversionTest extends Specification {

    ZigZagConversion zigZagConversion = new ZigZagConversion()

    def 'test dummy'() {
        given:'parameters'
        when:'conversion called'
        def res = zigZagConversion.convert(input, numRows)

        then: 'check'
        res == expected

        where: 'parameters'
        input | numRows | expected
        "PAYPALISHIRING" | 4 | "PINALSIGYAHRPI"
        "ABC" |3 | "ABC"
        "ABCDE" |4 | "ABCED"
    }
}
