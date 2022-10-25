package interview.sept1422.task1;


// We have imported the necessary tool classes.
// If you need to import additional packages or classes, please import here.

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        int lives = s.nextInt();
        int n = s.nextInt();
        int k = s.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            set.add(s.nextInt());
        }
        // please finish the function body here.
        int a = dfs(lives, set, 0, 1, n);
        int b = dfs(lives, set, 0, 2, n);
        int c = dfs(lives, set, 0, 3, n);
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        System.out.println(a + b + c);
    }

    private static int dfs(int lives, Set<Integer> set, int pos, int step, int n) {
        if (lives == 0) {
            return 0;
        }

        if (pos + step > n + 1) {
            return 0;
        }

        if (pos + step == n + 1) {
            return 1;
        }

        if (set.contains(pos + step)) {
            lives--;
        }

        int a = dfs(lives, set, pos + step, 1, n);
        int b = dfs(lives, set, pos + step, 2, n);
        int c = dfs(lives, set, pos + step, 3, n);
        return a + b + c;
    }
}
