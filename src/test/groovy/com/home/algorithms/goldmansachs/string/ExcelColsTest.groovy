package com.home.algorithms.goldmansachs.string

import spock.lang.Specification

class ExcelColsTest extends Specification {

    ExcelCols excelCols = new ExcelCols()

    def 'should convert number to excel column name'() {
        given: 'parameterized'
        when: 'method called'
        def res = excelCols.excelColumnName(number)

        then: 'verify'
        res == expected

        where: 'parameters'
        number | expected
        26     | "Z"
        51     | "AY"
        52     | "AZ"
        53     | "BA"
        676    | "YZ"
        27     | "AA"
        705    | "AAC"
    }
}
