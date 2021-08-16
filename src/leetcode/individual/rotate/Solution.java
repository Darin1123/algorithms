package leetcode.individual.rotate;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 * @author Zefeng Wang
 */

public class Solution {
    public void rotate(int[] nums, int k) {
        int N = nums.length;
        int[] res = new int[N];
        int cur = 0;
        for (int i=k+1; i<N; i++) {
            res[cur] = nums[i];
            cur++;
        }
        for (int i=0; i<k; i++) {
            res[cur] = nums[i];
            cur++;
        }
        System.arraycopy(res, 0, nums, 0, N);
    }
    
    
}
