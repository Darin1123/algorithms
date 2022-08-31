package interview.aug2722.task1;

import java.util.Scanner;

public class Solution {
    public static boolean f(String s, String t) {
        if (t.length() < s.length()) {
            return false;
        }
        int p1 = 0, p2 = 0, c1 = 1, c2 = 1;
        if (s.charAt(p1) != t.charAt(p2)) {
            return false;
        }
        char pre = s.charAt(0);
        while (p1 < s.length() || p2 < t.length()) {
            if (p1 == s.length() - 1) {
                if (t.charAt(p2) != pre) {
                    return false;
                }
                p2++;
                if (p2 == t.length()) {
                    return true;
                }
                continue;
            }
            while (s.charAt(p1) == pre) {
                c1++;
                p1++;
            }
            while (t.charAt(p2) == pre) {
                c2++;
                p2++;
            }
            if (c2 < c1) {
                return false;
            }
            if (s.charAt(p1) != t.charAt(p2)) {
                return false;
            }
            c1 = 0;
            c2 = 0;
            pre = s.charAt(p1);
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            String t = sc.next();
            System.out.println(f(s, t) ? "YES" : "NO");
        }
    }
}
