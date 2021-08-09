package leetcode.individual.nthSuperUglyNumber;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/super-ugly-number/
 * @author Zefeng Wang
 */

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int prime : primes) {
                long next = curr * prime;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }

    public static void main(String[] args) {
        int[] primes = new int[] {2, 7, 13, 19};
        System.out.println(new Solution().nthSuperUglyNumber(10, primes));
    }
}
