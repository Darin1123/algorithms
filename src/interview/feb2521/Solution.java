package interview.feb2521;

import java.util.Arrays;

/**
 * problem: N people initially on the 1-st floor, the elevator has capacity K.
 * The cost model is the number of floors the elevator visits. For example if
 * the elevator moves from 2-nd floor to 9-th floor, the cost is (9 - 2) = 7.
 * Calculate the minimum cost for all people reach their desired floors.
 * The elevator will eventually go back to 1-st floor.
 *
 * Sample input:
 * N = 3, K = 2
 * floors = {2, 3, 4}
 *
 * The output should be 8.
 *
 */
public class Solution {
    public int minTime(int N, int K, int[] layers) {
        int result = 0;

        // sort layers
        Arrays.sort(layers);
        while (N > K) {
            result += 2 * (layers[N-1] - 1);
            N -= K;
        }
        result += 2 * (layers[N - 1] - 1);

        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        int N = 4, K = 2;
        int[] layers = {3, 2, 4, 10};
        System.out.println(solution.minTime(N, K, layers));
    }
}
