package leetcode.checkRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zefeng Wang
 */

public class Solution {
    private final static int MOD = 1000000007;
    private int res = 0;
    private final char[] table = new char[] {'A', 'L', 'P'};

    // for debugging
    private final List<Character> picked = new ArrayList<>();
    private long counter = 1;
    private long wrong = 1;
    private long correct = 1;

    public int checkRecord(int n) {
        for (char record : table) {
            picked.add(record);
            dfs(n, 0, 0, record);
            picked.remove(picked.size() - 1);
        }
        return res;
    }

    private void dfs(int n, int absents, int succLate, char current) {
        if (current == 'A' && absents + 1 == 2) {
            System.out.print(counter + " - ");
            counter++;
            System.out.print(picked);
            System.out.println(" - ❌ - " + wrong);
            wrong++;
            return;
        }

        if (current == 'L' && succLate + 1 == 3) {
            System.out.print(counter + " - ");
            counter++;
            System.out.print(picked);
            System.out.println(" - ❌ - " + wrong);
            wrong++;
            return;
        }

        if (n == 1) {
            res = (res + 1) % MOD;
            System.out.print(counter + " - ");
            counter++;
            System.out.print(picked);
            System.out.println(" - ✅ - " + correct);
            correct++;
            return;
        }

        if (current == 'A') {
            for (char record : table) {
                picked.add(record);
                dfs(n - 1, absents + 1, 0, record);
                picked.remove(picked.size() - 1);
            }
        } else if (current == 'L') {
            for (char record : table) {
                picked.add(record);
                dfs(n - 1, absents, succLate + 1, record);
                picked.remove(picked.size() - 1);
            }
        } else {
            for (char record : table) {
                picked.add(record);
                dfs(n - 1, absents, succLate, record);
                picked.remove(picked.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int expected = 8;
        long start = System.currentTimeMillis();
        int actual = new Solution().checkRecord(n);
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("Actual: " + actual);
        System.out.println("Expected: " + expected);
        System.out.println("Time: " + elapsed);
    }
}
