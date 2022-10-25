package interview.aug3122.shunfeng.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long res = 0;
        if (n == 1) {
            System.out.println(1);
            return;
        }
        long[] heights = new long[n + 1];
        heights[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int half = (i - 1) / 2;
            heights[i] = 1 + Math.max(heights[half], heights[i - 1 -half]);
        }

//        System.out.println(Arrays.toString(heights));

//        int t = n;
        for (Long height : heights) {
            res += height;
        }

        System.out.println(res);
    }

}