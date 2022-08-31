package interview.aug2722.dj.task2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println(solution(a));
    }

    private static int solution(int[] a) {
        /**
         * 将数组拆成两组, 1 1 4 5 1 4 被拆成 1 4 1, 1 5 4 两组.
         * 然后计算每个组中各个元素出现的次数,
         * 第一组中:
         * 数字    次数
         * 1      2
         * 4      1
         *
         * 第二组中:
         * 数字    次数
         * 1      1
         * 5      1
         * 4      1
         *
         * 可以得到: 第一组中, 1出现的次数最多, 那么 1 就是长城数字之一,
         * 在第二组中所有数字出现的次数一样, 所以都可以作为长城数字 (1 不可以.)
         *
         * 那么计算第一组中还有多少数字不是 1, 得到 1
         * 计算第二组中多少数字不是其中的任一数字, 得到 2
         *
         * 结果就是 1 + 2 = 3
         *
         * 考虑特殊情况:
         *
         * 如果两组中最多的数字是一样的.
         * 如 1 1 4 5 1 1 1 2, 分成两组: 1 4 1 1, 1 5 1 2
         * 可以观察到, 第一组中的 1 更多, 所以第一组的 1 被选中.
         * 在第二组中找到出现次数第二多的数字, 然后做剩下的计算即可.
         * 所以答案为: 1 + 3 = 4
         */

        Map<Integer, Integer> countA = compute(a, 0);
        Map<Integer, Integer> countB = compute(a, 1);

        List<Map.Entry<Integer, Integer>> entriesA = new ArrayList<>(countA.entrySet());
        List<Map.Entry<Integer, Integer>> entriesB = new ArrayList<>(countB.entrySet());

        entriesA.sort((x, y) -> y.getValue() - x.getValue());
        entriesB.sort((x, y) -> y.getValue() - x.getValue());

        int maxAVal = entriesA.get(0).getKey();
        int maxBVal = entriesB.get(0).getKey();

        if (maxAVal != maxBVal) {
            int res = 0;
            for (int i = 1; i < entriesA.size(); i++) {
                res += entriesA.get(i).getValue();
            }

            for (int i = 1; i < entriesB.size(); i++) {
                res += entriesB.get(i).getValue();
            }
            return res;
        }

        if (entriesA.get(0).getValue() > entriesB.get(0).getValue()) {
            return specialCase(entriesA, entriesB);
        } else {
            return specialCase(entriesB, entriesA);
        }
    }

    /**
     * the first input contains higher count
     */
    private static int specialCase(
            List<Map.Entry<Integer, Integer>> count1, List<Map.Entry<Integer, Integer>> count2) {
        int res = 0;
        for (int i = 1; i < count1.size(); i++) {
            res += count1.get(i).getValue();
        }

        for (int i = 0; i < count2.size(); i++) {
            if (i == 1) { continue; }
            res += count2.get(i).getValue();
        }

        return res;
    }

    /**
     * @param offset either 0 or 1
     */
    private static Map<Integer, Integer> compute(int[] a, int offset) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = offset; i < a.length; i+=2) {
            if (count.get(a[i]) == null) {
                count.put(a[i], 1);
            } else {
                count.put(a[i], count.get(a[i]) + 1);
            }
        }

        return count;
    }
}
