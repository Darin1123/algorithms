package interview.aug0622;

import java.util.ArrayList;
import java.util.List;

public class Question2 {
    public int solution(String s) {
        if (s.length() < 1) {
            return 0;
        }

        int lo = 0, hi = s.length() - 1;
        while (lo < s.length() && s.charAt(lo) == 'W') {
            lo++;
        }

        // all 'W'
        if (lo == s.length()) {
            return 0;
        }

        while (s.charAt(hi) == 'W') {
            hi--;
        }


        List<Integer> data = new ArrayList<>();
        char prev = 'R';
        int count = 1;
        for (int i = lo + 1; i <= hi; i++) {
            if (s.charAt(i) == prev) {
                count++;
            } else {
                data.add(count);
                count = 1;
                prev = s.charAt(i);
            }
        }

        data.add(count);
        System.out.println(data);

        long res = 0L;

        lo = 0;
        hi = data.size() - 1;

        while (lo < hi) {
            if (lo == data.size() - 1 || hi == 0) {
                break;
            }

            if (res > 1000000000) {
                return -1;
            }

            int left = data.get(lo);
            int right = data.get(hi);
            if (left < right) {
                int gap = data.get(lo + 1);
                res += gap * left;
                data.set(lo + 2, data.get(lo + 2) + left);
                lo += 2;
            } else {
                int gap = data.get(hi - 1);
                res += gap * right;
                data.set(hi - 2, data.get(hi - 2) + right);
                hi -= 2;
            }
        }

        return (int) res;
    }

    public static void main(String[] args) {
        String test1 = "RWWRRRWWRRWRRWRRWWRRR";
        int res = new Question2().solution(test1);
        System.out.println(res);
    }
}
