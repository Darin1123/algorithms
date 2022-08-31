package interview.aug2722.dj.task1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        String str = sc.next();

        String builder = str.substring(0, k).toUpperCase() +
                str.substring(k, n).toLowerCase();

        System.out.println(builder);
    }
}
