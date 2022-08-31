package leetcode.singleNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/single-number/
 * @author Zefeng Wang
 */

public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        return (Integer) set.toArray()[0];
    }
}
