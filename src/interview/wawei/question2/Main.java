package interview.wawei.question2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * given N games, each has the followings:
 * 1) start time
 * 2) end time
 * 3) reward
 * goal: get the maximum reward.
 * the input is like this
 * N
 * s1 s1 s3 ...
 * e1 e2 e3 ...
 * p1 p2 p3 ...
 */
public class Main {
    private final int N;
    private int profit;
    private final int[] chosen;
    private final List<Integer> starts;
    private final List<Integer> ends;
    private final List<Integer> profits;

    public Main(int N, List<Integer> starts, List<Integer> ends, List<Integer> profits) {
        this.starts = starts;
        this.ends = ends;
        this.profits = profits;
        this.profit = 0;
        this.N = N;
        this.chosen = new int[N];
    }

    private List<Integer> findRemaining() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (this.chosen[i] == 0) {
                boolean conflict = false;
                for (int j = 0; j < N; j++) {
                    if (chosen[j] == 1 && !(starts.get(i) > ends.get(j) || ends.get(i) < starts.get(j))) {
                        conflict = true; break;
                    }
                }
                if (!conflict) result.add(i);
            }
        }
        return result;
    }

    private void dfs(int c, int tempProfit) {
        this.chosen[c] = 1;
        tempProfit += profits.get(c);
        if (tempProfit > this.profit) {
            this.profit = tempProfit;
        }
        List<Integer> remaining = findRemaining();
        if (remaining.size() == 0) {
            this.chosen[c] = 0;
            return;
        }
        if (remaining.size() == 1) {
            this.chosen[c] = 0;
            this.profit += profits.get(c);
            return;
        }
        for (Integer remain : remaining) {
            dfs(remain, tempProfit);
            this.chosen[remain] = 0;
        }
    }

    public int getMaxProfit() {
        for (int i = 0; i < N; i++) {
            dfs(i, 0);
        }
        return this.profit;
    }

    public static void main(String[] args) {
        int N = 4;
        List<Integer> start = Arrays.asList(3, 7, 4, 7);
        List<Integer> end = Arrays.asList(6, 9, 6, 8);
        List<Integer> profit = Arrays.asList(7, 8, 9, 15);
        System.out.println(new Main(N, start, end, profit).getMaxProfit());
//        Scanner sc = new Scanner(System.in);
//        int N = Integer.parseInt(sc.nextLine());
//        String startStr = sc.nextLine();
//        String endStr = sc.nextLine();
//        String profitStr = sc.nextLine();
//        List<Integer> start = Arrays
//                .stream(startStr.split(" "))
//                .map(Integer::valueOf)
//                .collect(Collectors.toList());
//        List<Integer> end = Arrays
//                .stream(endStr.split(" "))
//                .map(Integer::valueOf)
//                .collect(Collectors.toList());
//        List<Integer> profit = Arrays
//                .stream(profitStr.split(" "))
//                .map(Integer::valueOf)
//                .collect(Collectors.toList());
    }
}
