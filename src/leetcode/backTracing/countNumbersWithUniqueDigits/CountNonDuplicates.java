package leetcode.backTracing.countNumbersWithUniqueDigits;

import java.util.ArrayList;
import java.util.List;

public class CountNonDuplicates {
    private int n;
    private int result = 0;
    private final List<Integer> temp = new ArrayList<>();
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        this.n = n;
        for (int i = 0; i < 10; i++) {
            iterate(i);
        }
        return result;
    }

    private void iterate(int tail) {
        if (tail != 0) {
            if (temp.contains(tail)) {
                return;
            }
        } else {
            boolean nonZero = false;
            boolean afterNonZero = false;
            for (Integer i : temp) {
                if (!nonZero && i != 0) {
                    nonZero = true;
                }
                if (nonZero && !afterNonZero && i == 0) {
                    afterNonZero = true;
                }
            }
            if (nonZero && afterNonZero) {
                return;
            }
        }

        this.temp.add(tail);
        if (temp.size() == this.n) {
            result++;
            temp.remove(temp.size() - 1);
            return;
        }
        for (int i = 0; i < 10; i++) {
            iterate(i);
        }
        this.temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        CountNonDuplicates countNonDuplicate = new CountNonDuplicates();
        System.out.println(countNonDuplicate.countNumbersWithUniqueDigits(4));
    }
}
