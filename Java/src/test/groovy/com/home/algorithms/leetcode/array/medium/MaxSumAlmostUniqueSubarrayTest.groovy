package com.home.algorithms.leetcode.array.medium

import spock.lang.Specification

class MaxSumAlmostUniqueSubarrayTest extends Specification {

    def instance = new MaxSumAlmostUniqueSubarray()

    def 'should return max sum of elements in a subarray with length k. Each subarray should have at least m distinct elements'() {
        given: 'parameterized test'
        when: 'method called'
        def res = instance.maxSum(nums, m, k)

        then: 'verify'
        res == expected

        where: 'parameters'
        nums                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  | m | k | expected
        [996021492, 996021492, 973489433, 66259330, 554129007, 713784351, 646092981, 328987029, 469368828, 685679486, 66259330, 165954500, 731567840, 595800464, 552439059, 14673238, 157622945, 521321042, 386913607, 733723177, 330475939, 462727944, 69696035, 958945846, 648914457, 627088742, 363551051, 50748590, 400980660, 674779765, 439950964, 613843311, 385212079, 725525766, 813504429, 385212079, 66563232, 578031878, 935017574, 554725813, 456892672, 245308625, 626768145, 270964388, 554725813, 768296675, 676923124, 939689721, 115905765, 625193590, 717796816, 27972217, 277242430, 768296675, 480860474, 659230631, 570682291, 601689140, 955632265, 767424000, 251696645, 675750691, 767424000, 251696645, 767424000, 675750691, 675750691, 251696645] | 8 | 8 | 5_081_057_906
        [2,6,7,3,1,7] | 3 | 4 | 18
        [5,9,9,2,4,5,4] | 1 | 3 | 23
        [1,2,1,2,1,2,1] | 3 | 3 | 0
        [1,1,1,3] | 2 | 2 | 4
    }
}
