package interview.sept2622.task1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int hash(int x, int y) {
        return 4 * x + 3 * y + 2;
    }

    private static int dollar(int x, int y) {
        return 2 * x + y + 3;
    }

    private static int eval(String expression) {
        System.out.println(expression);
        // base case 0
        if (expression.matches("\\d+")) {
            return Integer.parseInt(expression);
        }
        // base case 1
        if (expression.matches("\\d+\\$\\d+")) {
            String[] nums = expression.split("\\$");
            int x = Integer.parseInt(nums[0]);
            int y = Integer.parseInt(nums[1]);
            return dollar(x, y);
        }
        // base case 2
        if (expression.matches("\\d+#\\d+")) {
            String[] nums = expression.split("#");
            int x = Integer.parseInt(nums[0]);
            int y = Integer.parseInt(nums[1]);
            return hash(x, y);
        }

        // recursive call
        String[] expressions = expression.split("\\$");
        Integer ans = null;
        for (String child : expressions) {
            if (ans == null) {
                ans = eval(child);
            } else {
                ans = dollar(ans, eval(child));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.next();
        System.out.println(eval(expression));
    }


}



