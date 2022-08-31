package interview.aug2722.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int[] a = new int[N];
//        for (int i = 0; i < N; i++) {
//            a[i] = sc.nextInt();
//        }
//        int K = sc.nextInt();
//        int[] p = new int[K];
//        for (int i = 0; i < K; i++) {
//            p[i] = sc.nextInt();
//        }

        int[] a = new int[] {1, 9, 2, 8, 3, 7, 4, 6, 5};
        int[] b = new int[] {3, 7};

//        System.out.println(partition(a, 3, 0, a.length - 1));
//        System.out.println(Arrays.toString(a));

        qs(a, b, 0, 0, a.length - 1);

        for (int j : a) {
            System.out.print(j + " ");
        }
    }

    public static void qs(int[] nums, int[] ks, int cur, int lo, int hi) throws Exception {
        if (lo > hi) {
            return;
        }
        int index = partition(nums, ks[cur], lo, hi);
        if (cur + 1 >= ks.length) {
            return;
        }
        if (ks[cur + 1] > ks[cur]) {
            qs(nums, ks, cur + 1,index + 1, hi);
        } else {
            qs(nums, ks, cur + 1, lo, index - 1);
        }
    }



    private static int partition(int[] nums, int k, int i, int j) throws Exception {
        List<Integer> lt = new ArrayList<>();
        List<Integer> gt = new ArrayList<>();
        boolean contains = false;
        for (int l = i; l <= j; l++) {
            if (nums[l] < k) {
                lt.add(nums[l]);
            } else if (nums[l] > k) {
                gt.add(nums[l]);
            } else {
                contains = true;
            }
        }
        if (!contains) {
            throw new Exception("key not in range");
        }
        int ans = lt.size() + i - 1;
        lt.add(k);
        lt.addAll(gt);
        for (int l = i; l <= j; l++) {
            nums[l] = lt.get(l - i);
        }

        return ans;

    }
}
