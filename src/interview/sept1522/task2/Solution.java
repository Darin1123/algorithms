package interview.sept1522.task2;

import java.util.*;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param numA string字符串
     * @param numB string字符串
     * @return string字符串
     */
    public String sum (String numA, String numB) {
        // write code here
        StringBuilder builder = new StringBuilder();

        int i = numA.length() - 1;
        int j = numB.length() - 1;
        boolean up = false;
        while (i >= 0 || j >= 0) {
            if (i == -1) {
                if (up) {
                    int num = Integer.parseInt("" + numB.charAt(j)) + 1;
                    if (num == 10) {
                        builder.append(0);
                    } else {
                        up = false;
                        builder.append(num);
                    }
                } else {
                    builder.append(numB.charAt(j));
                }
                j--;
                continue;
            }

            if (j == -1) {
                if (up) {
                    int num = Integer.parseInt("" + numA.charAt(i)) + 1;
                    if (num == 10) {
                        builder.append(0);
                    } else {
                        up = false;
                        builder.append(num);
                    }
                } else {
                    builder.append(numA.charAt(i));
                }
                i--;
                continue;
            }

            int a = Integer.parseInt("" + numA.charAt(i));
            int b = Integer.parseInt("" + numB.charAt(j));
            int c = a + b + (up ? 1 : 0);
            if (c >= 10) {
                builder.append(c % 10);
                up = true;
            } else {
                builder.append(c);
                up = false;
            }

            i--;
            j--;
        }

        if (up) {
            builder.append(1);
        }

        // reverse string
        StringBuilder reverseBuilder = new StringBuilder();
        String reversed = builder.toString();

        for (int k = reversed.length() - 1; k >= 0; k--) {
            reverseBuilder.append(reversed.charAt(k));
        }

        return reverseBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sum("999", "1"));
    }
}
