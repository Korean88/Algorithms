package com.home.algorithms.amz.medium

import spock.lang.Specification

class AnalyzeUserWebsiteVisitPatternTest extends Specification {

    def instance = new AnalyzeUserWebsiteVisitPattern()

    def 'test validate 3 pointers'() {
        given: 'parameterized test'
        when: 'method called'
        def res = instance.mostVisitedPattern(username as String[], timestamp as int[], website as String[])

        then: 'verify'
        res == expected

        where: 'parameters'
        username                                                                              | timestamp                                                         | website                        | expected
        ["joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"] | [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]                                   |
                ["home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"]                                                                                         | ["home", "about", "career"]
        ["ua", "ua", "ua", "ub", "ub", "ub"]                                              | [1, 2, 3, 4, 5, 6]                                                | ["a", "b", "a", "a", "b", "c"] | ["a", "b", "a"]
        ["uod", "uod", "uod", "kfuagsh", "uod"]                                           | [520_778_108, 799_976_888, 522_803_143, 968_158_505, 908_405_336] |
                ["bfx", "taohbuuleq", "vsryf", "irmbcoebt", "bfx"]                                                                                                                             | ["bfx", "taohbuuleq", "bfx"]
        ["h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"] | [527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930] |
                ["hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"] | ["hibympufi","hibympufi","yljmntrclw"]
    }

}
