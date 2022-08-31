package interview.aug2622.task1;


import java.util.Arrays;

public class Solution {
    public int solution(String S) {
        // write your code in Java 8 (Java SE 8)
        // brute force
        int ans = 0, N = S.length();

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j += 2) {
                int l = f(S.substring(i, j + 1));
                ans = Math.max(ans, l);
            }
        }

        return ans;
    }

    int f(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int c : count) {
            if (c % 2 != 0) {
                return -1;
            }
        }

        return s.length();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("asddsdddsaaaadsasdddssaddsaddssasdddaasddasdadsdsssasddsasdadadsdsdasdsdaddsdadaddasdadadsdasdaddasdddadsdsdadadsdsdadaddadasdsdaddsaddsdsdsddsdaddadaddadadsdadasdadadsdasddadsdadadaddsdadasdsdasdadsdsdaddsddsdadaddasdasdsaddasdasdsddsdsadasdffasddasdsaddasdsaddasddasds"));
    }
}
