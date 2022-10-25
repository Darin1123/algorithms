package interview.otco2422;

import java.util.ArrayList;
import java.util.List;

// 面试题：开心消消乐
// 2022 年 10 月 24 日
// • 给定一个整数数组asteroids， 表示在同一行的水果。
// • 对于数组中的每一个元素，其绝对值表示水果的大小，
//   正负表示水果的移动方向（正表示向右移动，负表示向左
//   移动）。每一颗水果以相同的速度移动。
// • 找出碰撞后剩下的所有水果。碰撞规则：两个水果相互碰
//   撞, 较小的水果会爆炸. 如果两颗水果大小相同, 则他们
//   都会爆炸. 两颗移动方向相同的水果永远不会发生碰撞.

public class Main {
    public List<Integer> func(int[] nums) {
        int N = nums.length;


        // 根据移动的方向, 将原数组分成若干段, 然后根据碰撞规则合并这些片段
        // 1. 分成若干段
        List<List<Integer>> fragments = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        int firstNum = nums[0];
        boolean isPositive = firstNum > 0;
        temp.add(firstNum);

        for (int i = 1; i < N; i++) {
            if (nums[i] > 0 == isPositive) {
                temp.add(nums[i]);
            } else {
                fragments.add(temp);
                temp = new ArrayList<>();
                temp.add(nums[i]);
                isPositive = nums[i] > 0;
            }
        }
        fragments.add(temp);

        // 只有一个片段, 直接返回它
        if (fragments.size() == 1) {
            return fragments.get(0);
        }

        // 合并片段
        List<Integer> ans = fragments.get(0);
        for (int i = 1; i < fragments.size(); i++) {
            ans = merge(ans, fragments.get(i));
        }

        return ans;
    }

    /**
     * 合并两个片段
     * @param a1 左侧的片段可能是先负后正, 或者是同符号
     * @param a2 右侧的片段一定是同符号的.
     * @return 合并后的新片段
     */
    private List<Integer> merge(List<Integer> a1, List<Integer> a2) {
        // 根据左侧的结尾元素进行分类讨论,
        // 1. 如果符号和右侧相同, 则直接拼接两者
        boolean isPositive1 = a1.get(a1.size() - 1) > 0;
        boolean isPositive2 = a2.get(0) > 0;
        if (isPositive1 == isPositive2) {
            List<Integer> ans = new ArrayList<>();
            ans.addAll(a1);
            ans.addAll(a2);
            return ans;
        }

        // 2. 符号不相同,
        // 2.1 如果左侧为负, 右侧为正, 则直接拼接
        if (!isPositive1 && isPositive2) {
            List<Integer> ans = new ArrayList<>();
            ans.addAll(a1);
            ans.addAll(a2);
            return ans;
        }
        // 2.2 如果左侧为正, 右侧为负, 则直接碰撞运算
        for (int i = 0; i < a2.size(); i++) {
            // 获取右侧水果的大小
            int val = Math.abs(a2.get(i));
            int p = a1.size() - 1;
            // 依次向左碰撞
            while (p >= 0) {
                // 左侧水果也是向左移动的, 将当前水果插入, 结束循环
                if (a1.get(p) < 0) {
                    List<Integer> temp = new ArrayList<>();
                    for (int j = 0; j <= p; j++) {
                        temp.add(a1.get(j));
                    }
                    temp.add(val);
                    for (int j = p + 1; j < a1.size(); j++) {
                        temp.add(a1.get(j));
                    }
                    a1 = temp;
                    break;
                }
                // 左侧水果大于该水果, 直接结束循环
                if (a1.get(p) > val) {
                    break;
                }
                // 左侧水果等于该水果, 删除左侧的这个水果, 结束循环
                if (a1.get(p) == val) {
                    a1.remove(a1.size() - 1);
                    break;
                }
                // 左侧水果小于该水果, 删除左侧的这个水果
                if (a1.get(p) < val) {
                    a1.remove(a1.size() - 1);
                    p--;
                }
            }

        }

        return a1;
    }

    public static void main(String[] args) {
//        int[] test = new int[] {3, 7, -4, -5, 6};
//        int[] test = new int[] {3, 7, -4, -5, 6};
//        int[] test = new int[] {-3, -7, 6, -4, -5};
//        int[] test = new int[] {5, 10, -5};
//        int[] test = new int[] {10, 2, -5};
//        int[] test = new int[] {8, -8};
        int[] test = new int[] {8, -8};

        System.out.println(new Main().func(test));
    }
}
