package leetcode.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Zefeng Wang
 */

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] - b[0] != 0) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        ArrayList<int[]> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                result.add(new int[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else {
                if (intervals[i][1] > end) {
                    end = intervals[i][1];
                }
            }
            if (i == intervals.length - 1) {
                result.add(new int[] {start, end});
            }
        }

        int[][] resultArray = new int[result.size()][2];
        result.toArray(resultArray);
        return resultArray;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                new int[] {1, 3},
                new int[] {2, 6},
                new int[] {8, 10},
                new int[] {15, 18}
        };

        int[][] merged = new Solution().merge(intervals);

        for (int[] a : merged) {
            System.out.print(a[0]);
            System.out.print(", ");
            System.out.println(a[1]);
        }

        System.out.println(merged.length);
    }
}
