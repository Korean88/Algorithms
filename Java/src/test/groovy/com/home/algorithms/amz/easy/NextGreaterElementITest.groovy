package com.home.algorithms.amz.easy


import spock.lang.Specification

class NextGreaterElementITest extends Specification {

    def instance = new NextGreaterElementI()

    def 'test validate 3 pointers'() {
        given: 'parameterized test'
        when: 'method called'
        def res = instance.nextGreaterElement(nums1 as int[], nums2 as int[])

        then: 'verify'
        res == expected as int[]

        where: 'parameters'
        nums1     | nums2        | expected
        [4, 1, 2] | [1, 3, 4, 2] | [-1, 3, -1]
        [2, 4]    | [1, 2, 3, 4] | [3, -1]
        [2, 1, 3] | [2, 3, 1]    | [3, -1, -1]
        [1,3,5,2,4] | [6,5,4,3,2,1,7] | [7,-1,-1,-1,-1]
    }
}
