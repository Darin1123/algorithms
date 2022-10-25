package interview.aug3122.duxiaoman.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        long res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int min = a[i];
                int max = a[i];
                for (int l = i; l <= j; l++) {
                    if (a[l] < min) {
                        min = a[l];
                    }
                    if (a[l] > max) {
                        max = a[l];
                    }
                }
                if (max == min * k) {
                    res++;
                }
            }
        }


        System.out.println(res);
    }
}
