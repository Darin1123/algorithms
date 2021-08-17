package leetcode.getHint;

import java.util.HashMap;
import java.util.Map;

/**
 * @date 2021-03-03
 *
 * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
 *
 * 你写出一个秘密数字，并请朋友猜这个数字是多少。
 * 朋友每猜测一次，你就会给他一个提示，告诉他的猜测数字中有多少位属于数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位属于数字猜对了但是位置不对（称为“Cows”, 奶牛）。
 * 朋友根据提示继续猜，直到猜出秘密数字。
 * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，返回字符串的格式为 xAyB ，x 和 y 都是数字，A 表示公牛，用 B 表示奶牛。
 *
 * xA 表示有 x 位数字出现在秘密数字中，且位置都与秘密数字一致。
 * yB 表示有 y 位数字出现在秘密数字中，但位置与秘密数字不一致。
 * 请注意秘密数字和朋友的猜测数都可能含有重复数字，每位数字只能统计一次。
 *
 * 输入: secret = "1807", guess = "7810"
 * 输出: "1A3B"
 * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
 *
 */

public class Solution {
    public String getHint(String secret, String guess) {
        int x = 0, y = 0, N = secret.length();
        Map<Character, Integer> secretMap = new HashMap<>();
        Map<Character, Integer> guessMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            char secretChar = secret.charAt(i);
            char guessChar = guess.charAt(i);
            if (secretChar == guessChar) {
                x++;
            } else {
                secretMap.put(
                        secretChar,
                        (secretMap.get(secretChar) == null) ?
                                1 : secretMap.get(secretChar) + 1);
                guessMap.put(
                        guessChar,
                        (guessMap.get(guessChar) == null) ?
                                1 : guessMap.get(guessChar) + 1);
            }
        }
        for (Character key : secretMap.keySet()) {
            Integer guessNum = guessMap.get(key);
            if (guessNum != null) {
                y += Math.min(guessNum, secretMap.get(key));
            }
        }
        return x + "A" + y + "B";
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getHint("1123", "0111"));
    }
}
