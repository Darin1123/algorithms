package interview.sept0222.task1;

import java.util.Arrays;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param digits int整型一维数组
     * @return int整型
     */
    public int maxDigit (int[] digits) {
        // write code here
        Arrays.sort(digits);
        String num = "";
        for (int i = digits.length - 1; i >= 0; i--) {
            num += digits[i];
        }

        return Integer.parseInt(num);
    }

    public static void main(String[] args) {
        int[] digits = new int[] {1, 2, 4, 3 ,6};
        System.out.println(new Solution().maxDigit(digits));
    }
}
