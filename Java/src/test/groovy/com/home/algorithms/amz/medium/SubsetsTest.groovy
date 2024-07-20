package com.home.algorithms.amz.medium


import spock.lang.Specification

class SubsetsTest extends Specification {

    def instance = new Subsets()

    def 'should return all subsets of a given integer array'() {
        given: 'parameterized test'
        when: 'method called'
        def res = instance.subsets(nums)

        then: 'verify'
        res.size() == expected.size()
        def expectedSets = new ArrayList()
        for (List<Integer> subset : expected) {
            expectedSets.add(new HashSet(subset))
        }
        for (List<Integer> subset : res) {
            def s = new HashSet(subset)
            expectedSets.contains(s);
        }

        where: 'parameters'
        nums               | expected
        [1, 2] as int[]    | [[], [1], [2], [1, 2]]
//        [1, 2, 3] as int[] | [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
//        [0] as int[]       | [[], [0]]
    }
}
