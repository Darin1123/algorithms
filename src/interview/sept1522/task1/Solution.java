package interview.sept1522.task1;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 查找单链表中间节点
     * @param head ListNode类 链表头节点
     * @return int整型
     */
    public int findMidNode (ListNode head) {
        // write code here

        if (head.next == null) {
            return head.val;
        }
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null) {
            if (quick.next == null) {
                return slow.val;
            }

            quick = quick.next.next;
            slow = slow.next;
        }

        return slow.val;
    }
}


class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }
}
