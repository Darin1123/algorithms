package interview.aug2122;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    private static char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u'};
    private static int[] ops2vow = new int[26];

    /*
     * Complete the 'countMinimumOperations' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING password as parameter.
     */

    private static boolean isVowel(char c) {
        for (char v : vowels) {
            if (c == v) {
                return true;
            }
        }
        return false;
    }

    private static int minOpsCon2Vow(char c) {
        if (isVowel(c)) {
            return 0;
        }
        if (ops2vow[c - 'a'] != 0) {
            return ops2vow[c - 'a'];
        }

        int ans = 0;
        int[] dis = new int[5];
        int i = 0;
        for (char v : vowels) {
            dis[i] = Math.abs(c - v);
            i++;
        }

        Arrays.sort(dis);
        ans = dis[0];
        ops2vow[c - 'a'] = ans;

        return ans;
    }

    public static int countMinimumOperations(String password) {
        // Write your code here
        // count number of vowels and consonants
        int vowelCount = 0;
        for (int i = 0; i < password.length(); i++) {
            if (isVowel(password.charAt(i))) {
                vowelCount++;
            }
        }
        int consonantCount = password.length() - vowelCount;

        // more vowels, return size of more vowels
        if (vowelCount >= consonantCount) {
            return vowelCount - consonantCount;
        }

        // more consonants, return minimum conversion
        int[] ops = new int[password.length()];
        for (int i = 0; i < password.length(); i++) {
            ops[i] = minOpsCon2Vow(password.charAt(i));
        }

        Arrays.sort(ops);

        int start = 0;
        while (ops[start] == 0) {
            start++;
        }

        int ans = 0;

        for (int i = 0; i < (consonantCount - vowelCount) / 2; i++) {
            ans += ops[start];
            start++;
        }

        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        String password = "hack";

        int result = Result.countMinimumOperations(password);

        System.out.println(result);
    }
}

