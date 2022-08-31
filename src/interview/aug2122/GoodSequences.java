package interview.aug2122;

import java.util.HashMap;
import java.util.Map;

public class GoodSequences {
    private static Map<Character, Integer> map = new HashMap<>();
    private static int[] count = new int[26];

    public static int Cmn(int m ,int n){
        int[][] dp=new int[m+1][n+1];
        dp[0][0]=1;
        for(int i=1;i<=m;i++){
            dp[i][0]=1;
            for(int j=1;j<=Math.min(i+1,n);j++){
                dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
            }
        }
        return dp[m][n];
    }

    public static int countGoodSubsequences(String word) {
        // Write your code here
        // count frequency
        for (char c : word.toCharArray()) {
            map.merge(c, 1, Integer::sum);
            count[c - 'a']++;
        }

        int min = 0;
        for (int c : count) {
            if (c == 0) continue;
            if (min == 0) {
                min = c;
                continue;
            }
            if (c < min) {
                min = c;
            }
        }

        for (int i = 0; i < count.length; i++) {
            count[i] -= min;
        }

        long total = 0;
        for (int i = 1; i <= word.length(); i++) {
            total += Cmn(word.length(), i);
        }

        System.out.println(total);

        long exTotal = 0;

//        for (int c : count) {
//            if (c > 0) {
//                for ()
//                exTotal =
//            }
//        }

        return 0;

    }

    public static void main(String[] args) {
        System.out.println(countGoodSubsequences("aabc"));
    }
}
