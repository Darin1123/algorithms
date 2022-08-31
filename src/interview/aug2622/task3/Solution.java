package interview.aug2622.task3;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int solution(int[] A, int[] B) {
        // write your code in Java 8 (Java SE 8)
        int N = A.length, i = 0,
                min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        while (i < N) {
            if (A[i] == B[i]) {
                if (!set.contains(A[i])) {
                    list.add(A[i]);
                }
                set.add(A[i]);
            } else {
                if (!set.contains(Math.max(A[i], B[i]))) {
                    list.add(Math.max(A[i], B[i]));
                }
                set.add(Math.max(A[i], B[i]));
            }
            i++;
        }

        list.sort((a, b) -> a - b);

        if (list.get(0) > 1) {
            return 1;
        }

        int pre = list.get(0);
        i = 1;
        while (i < list.size()) {
            int c = list.get(i);
            if (c - pre > 1) {
                return pre + 1;
            }
            pre = c;
            i++;
        }
        return list.get(list.size() - 1) + 1;
    }

    public static void main(String[] args) {
        int[] A = new int[] {1, 2, 4, 3};
        int[] B = new int[] {1, 3, 2, 3};

//        int[] A = new int[] {1, 2};
//        int[] B = new int[] {1, 2};

//        int[] A = new int[] {3, 2, 1, 6, 5};
//        int[] B = new int[] {4, 2, 1, 3, 3};
        System.out.println(new Solution().solution(A, B));
    }
}

