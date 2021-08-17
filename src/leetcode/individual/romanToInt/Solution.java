package leetcode.individual.romanToInt;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zefeng Wang
 */

public class Solution {
    public int romanToInt(String s) {

        int res = 0, N = s.length();

        Map<Character, Integer> table = new HashMap<>();
        table.put('V', 5);
        table.put('L', 50);
        table.put('D', 500);
        table.put('M', 1000);

        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if (c == 'C') {
                if (i < (N - 1)) {
                    if (s.charAt(i + 1) == 'D') {
                        res += 400;
                        i++;  // skip the next number
                    } else if (s.charAt(i + 1) == 'M') {
                        res += 900;
                        i++;  // skip the next number
                    } else {
                        res += 100;
                    }
                } else {
                    res += 100;
                }
            } else if (c == 'X') {
                if (i < (N - 1)) {
                    if (s.charAt(i + 1) == 'L') {
                        res += 40;
                        i++;  // skip the next number
                    } else if (s.charAt(i + 1) == 'C') {
                        res += 90;
                        i++;  // skip the next number
                    } else {
                        res += 10;
                    }
                } else {
                    res += 10;
                }
            } else if (c == 'I') {
                if (i < (N - 1)) {
                    if (s.charAt(i + 1) == 'V') {
                        res += 4;
                        i++;  // skip the next number
                    } else if (s.charAt(i + 1) == 'X') {
                        res += 9;
                        i++;  // skip the next number
                    } else {
                        res += 1;
                    }
                } else {
                    res += 1;
                }
            } else {
                res += table.get(c);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("III"));
    }
}
