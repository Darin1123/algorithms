package leetcode.restoreIpAddresses;


import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/restore-ip-addresses/">链接</a>
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        // 长度不足 4, 直接返回 false
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }

        int N = s.length();

        // 暴力遍历
        for (int i = 1; i <= N - 3; i++) {
            String num1 = s.substring(0, i);
            if (!validNum(num1)) {
                continue;
            }
            for (int j = i + 1; j <= N - 2; j++) {
                String num2 = s.substring(i, j);
                if (!validNum(num2)) {
                    continue;
                }
                for (int k = j + 1; k <= N - 1; k++) {
                    String num3 = s.substring(j, k);
                    String num4 = s.substring(k, N);
                    if (validNum(num3) && validNum(num4)) {
                        res.add(num1 + "." + num2 + "." + num3 + "." + num4);
                    }
                }
            }
        }


        return res;
    }

    private boolean validNum(String num) {
        if (Integer.parseInt(num) > 255) {
            return false;
        }
        if (num.length() == 1) {
            return true;
        }
        if (num.startsWith("0")) {
            return false;
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("1231231231234"));
    }
}
