package interview.sept0222.task2;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class ListNode {
  int val;
  ListNode next = null;
  public ListNode(int val) {
    this.val = val;
  }
}


public class Solution {

    public ListNode combineTwoDisorderNodeToOrder (ListNode node1, ListNode node2) {
        // write code here
        List<Integer> nums = new ArrayList<>();
        while (node1 != null) {
            nums.add(node1.val);
            node1 = node1.next;
        }

        while (node2 != null) {
            nums.add(node2.val);
            node2 = node2.next;
        }

        nums.sort(Comparator.comparingInt(a -> a));

        ListNode res = new ListNode(nums.get(0));
        ListNode t = res;
        for (int i = 1; i < nums.size(); i++) {
            t.next = new ListNode(nums.get(i));
            t = t.next;
        }

        return res;
    }
}
