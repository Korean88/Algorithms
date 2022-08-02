package com.home.algorithms.leetcode.array

import spock.lang.Specification

class SearchWordInTableTest extends Specification {

    SearchWordInTable searchWordInTable = new SearchWordInTable()

    def 'test method with recursion'() {
        given: 'table and word in parameters'
        when: 'method called'
        def res = searchWordInTable.exists(board as char[][], word)

        then: 'verify expected'
        res == expected

        where: 'parameters'
        board                                                                | word    | expected
        [['A', 'B', 'R'], ['D', 'C', 'D'], ['M', 'A', 'E'], ['Z', 'Y', 'N']] | "ABCDE" | true
        [['A', 'B', 'R'], ['D', 'C', 'D'], ['M', 'A', 'E'], ['Z', 'Y', 'N']] | "ABRDEN" | true
        [['A', 'B', 'R'], ['D', 'C', 'D'], ['M', 'A', 'E'], ['Z', 'Y', 'N']] | "ABRDCD" | true
        [['A', 'B', 'R'], ['D', 'C', 'D'], ['M', 'A', 'E'], ['Z', 'Y', 'N']] | "ABRDCDMAENYZ" | true
        [['A', 'B', 'R'], ['D', 'C', 'D'], ['M', 'A', 'E'], ['Z', 'Y', 'N']] | "AY" | true
        [['A', 'B', 'R'], ['D', 'C', 'D'], ['M', 'A', 'E'], ['Z', 'Y', 'N']] | "A" | true
        [['A', 'B', 'R'], ['D', 'C', 'D'], ['M', 'A', 'E'], ['Z', 'Y', 'N']] | "ABD" | false
        [['A', 'B', 'R'], ['D', 'C', 'D'], ['M', 'A', 'E'], ['Z', 'Y', 'N']] | "ANYNY" | false
        [[]] | "ANYNY" | false
        [['A','B','C','D']] | "A" | true
        [['A']] | "A" | true
        [['A','B','C','D']] | "AB" | true
        [['A','B','C','D']] | "AA" | false
        [['A','B','C','D']] | "CB" |true
        [['A','A']] | "AAA" |false
        [["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]] | "ABCESEEEFS" | true
    }
}
