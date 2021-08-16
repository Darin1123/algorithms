package leetcode.individual.sortedSquares;

import java.util.Arrays;

/**
 * @author Zefeng Wang
 */

public class Solution {
    public int[] sortedSquares(int[] nums) {

        int numNegativeIndex = -1;
        int N = nums.length;

        if (nums[0] < 0) {  // starts with negative number
            for (int i=0; i<N; i++) {
                if (nums[i] >= 0) {
                    numNegativeIndex = i;
                    break;
                }
            }
            if (numNegativeIndex == -1) {  // all of them are negative
                for (int i=0; i<N; i++) {
                    nums[i] *= nums[i];
                }
                for (int i=0; i<N/2; i++) {
                    int t = nums[i];
                    nums[i] = nums[N - 1 - i];
                    nums[N - 1 - i] = t;
                }
                return nums;
            }

            int i = numNegativeIndex - 1;
            int[] res = new int[N];
            int cur = 0;

            while (i >= 0 && numNegativeIndex < N) {
                int a = nums[i] * nums[i];
                int b = nums[numNegativeIndex] * nums[numNegativeIndex];
                if (a > b) {
                    res[cur] = b;
                    numNegativeIndex++;
                    cur++;
                } else if (a < b) {
                    res[cur] = a;
                    cur++;
                    i--;
                } else {
                    res[cur] = a;
                    res[cur + 1] = a;
                    i--;
                    numNegativeIndex++;
                    cur += 2;
                }
            }

            if (i >= 0) {
                for (int a = i; a>=0; a--) {
                    res[cur] = nums[a] * nums[a];
                    cur++;
                }
            }

            if (numNegativeIndex < N) {
                for (int a=numNegativeIndex; a<N; a++) {
                    res[cur] = nums[a] * nums[a];
                    cur++;
                }
            }

            return res;

        } else {  // all positive
            for (int i=0; i<N; i++) {
                nums[i] *= nums[i];
            }
            return nums;
        }
    }

    public static void main(String[] args) {
        // int[] nums = new int[] {-4,-1,0,3,10};  // pass
        int[] nums = new int[] {-5, -3, -2, -1};
        System.out.println(Arrays.toString(new Solution().sortedSquares(nums)));
    }
}
