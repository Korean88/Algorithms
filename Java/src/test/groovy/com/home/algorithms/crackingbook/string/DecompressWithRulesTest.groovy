package com.home.algorithms.crackingbook.string

import com.home.algorithms.string.DecompressWithRules
import spock.lang.Specification

class DecompressWithRulesTest extends Specification {

    def "should decompress String"() {
        given: 'instance'
        def instance = new DecompressWithRules()

        when: 'method called'
        def res = instance.decompress(symbol, compositionRules, generationRules)

        then: 'verify result'
        res == expected

        where: 'parameters'
        symbol      | compositionRules                       | generationRules            | expected
        'A' as char | ["A:BB", "B:CD"]                       | ["C:la", "D:tte"]          | "lattelatte"
        'A' as char | ["A:BB", "B:CD", "D:E", "E:FG", "F:H"] | ["C:la", "F:tte", "H:.io"] | "la.iola.io"
        'A' as char | ["A:BB", "B:CD", "D:E", "E:FG", "F:"] | ["C:la", "F:tte", "H:.io"] | "lala"
    }
}
