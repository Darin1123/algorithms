package interview.aug2622.task2;

import java.util.*;

public class Solution {
    public int solution(int[] A, int M) {
        // write your code in Java 8 (Java SE 8)

        // record # point at each coordinate
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            if (map.get(i) == null) {
                map.put(i, 1);
                list.add(i);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        // sort A
        list.sort(Comparator.comparingInt(a -> a));

        boolean[] visited = new boolean[A.length];
        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            int t = map.get(A[i]);
            int init = A[i];
            int ti = i + 1;
            while (ti < list.size()) {
                if (visited[ti]) {
                    ti++;
                    continue;
                }
                if (A[ti] - init < M) {
                    ti++;
                    continue;
                }

                if ((A[ti] - init) % M == 0) {
                    t += map.get(A[ti]);
                    visited[ti] = true;
                }
                ti++;
            }
            if (t > ans) {
                ans = t;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
//        int[] A = new int[] {-3, -2, 1, 0, 8, 7, 1};
//        int[] A = new int[] {7, 1, 11, 8, 4, 10};

        Random r = new Random();
        int N = 100000;
        int M = r.nextInt(100000);
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = r.nextInt();
        }
        System.out.println(new Solution().solution(A, M));
    }
}
