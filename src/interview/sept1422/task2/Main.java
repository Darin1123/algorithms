package interview.sept1422.task2;


// We have imported the necessary tool classes.
// If you need to import additional packages or classes, please import here.

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        int M = s.nextInt();
        int N = s.nextInt();
        int[] pips = new int[N];
        for (int i = 0; i < N; i++) {
            pips[i] = s.nextInt();
        }

        Package[] a = new Package[M];
        for (int i = 0; i < M; i++) {
            a[i] = new Package();
            a[i].setSize(s.nextInt());
        }
        for (int i = 0; i < M; i++) {
            a[i].setTime(s.nextInt());
        }
        // please finish the function body here.
        int ans = h(pips, a);
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        System.out.println(ans);
    }

    private static int h(int[] pips, Package[] a) {
        Arrays.sort(pips);
        Arrays.sort(a);

        return 0;
    }
}

class Package implements Comparable<Package> {
    private int size;
    private int time;

    public void setSize(int size) {
        this.size = size;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getSize() {
        return size;
    }

    public int getTime() {
        return time;
    }

    @Override
    public int compareTo(Package that) {
        return this.size - that.size;
    }
}

