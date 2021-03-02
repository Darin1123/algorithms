package leetcode.alibaba.linkedListSum;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 *
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 *
 * 这些数位是反向存放的，也就是个位排在链表首部。
 *
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 */


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode result = new ListNode((head1.val + head2.val) % 10);
        ListNode temp = result;
        boolean up = (head1.val + head2.val) >= 10;
        head1 = head1.next;
        head2 = head2.next;
        while (head1 != null && head2 != null) {
            int raw = head1.val + head2.val;
            int sum = up ? raw + 1 : raw;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            up = sum >= 10;
            head1 = head1.next;
            head2 = head2.next;
        }
        // add the rest
        if (head1 != null || head2 != null) {
            while (head1 != null) {
                if (up) {
                    temp.next = new ListNode((head1.val + 1) % 10);
                    up = (head1.val + 1) >= 10;
                } else {
                    temp.next = new ListNode(head1.val);
                    up = false;
                }
                head1 = head1.next;
                temp = temp.next;
            }
            while (head2 != null) {
                if (up) {
                    temp.next = new ListNode((head2.val + 1) % 10);
                    up = (head2.val + 1) >= 10;
                } else {
                    temp.next = new ListNode(head2.val);
                    up = false;
                }
                head2 = head2.next;
                temp = temp.next;
            }
        }

        if (up) {
            temp.next = new ListNode(1);
        }
        return result;
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

    public static ListNode constructList(int... input) {
        ListNode result = new ListNode(input[0]);
        ListNode t = result;
        for (int i = 1; i < input.length; i++) {
            t.next = new ListNode(input[i]);
            t = t.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = constructList(3, 7);
        ListNode l2 = constructList(9, 2);

        ListNode result = new Solution().addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
