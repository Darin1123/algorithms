package interview.sept0222.task3;

public class Solution {
    public long tourismRoutePlanning (int scenicspot) {
        // write code here
        if (scenicspot <= 2) {
            return scenicspot;
        }

        int a = 1, b = 2;

        for (int i = 0; i < scenicspot - 2; i++) {
            int t = b;
            b = a + b;
            a = t;
        }

        return b;
    }

    private long h(int n) {
        if (n <= 2) {
            return n;
        }

        return h(n - 1) + h(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().tourismRoutePlanning(5));
    }
}
