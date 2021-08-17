package leetcode.countAndSay;

/**
 * 2021/08/10
 * https://leetcode-cn.com/problems/count-and-say/
 * @author Zefeng Wang
 */

public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i=0; i<n; i++) {
            s = helper(s);
        }
        return s;
    }

    private String helper(String s) {
        if ("1".equals(s)) {
            return "11";
        }

        StringBuilder builder = new StringBuilder();
        char digit = s.charAt(0);
        int size = 1;

        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i) != digit) {
                builder.append(size).append(digit);
                digit = s.charAt(i);
                size = 1;
            } else {
                size++;
            }
            if (i == s.length() - 1) {
                builder.append(size).append(digit);
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(4));
    }
}
