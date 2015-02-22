/**
 * Leetcode's Implementation of AddTwoNumber: https://oj.leetcode.com/problems/add-two-numbers/
 * Created by wei on 2/21/15.
 */

/**
 * This implementation of list is so silly.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
};

public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            throw new IllegalArgumentException ("Input cannot be null.");

        int addOn = 0;
        ListNode head = null, cur = null;
        while (l1 != null || l2 != null || addOn != 0) {
            int d1 = l1 == null ? 0 : l1.val;
            int d2 = l2 == null ? 0 : l2.val;

            int d = (d1 + d2 + addOn) % 10;
            addOn = (d1 + d2 + addOn) / 10;

            if (cur == null)
                head = cur = new ListNode(d);
            else
                cur = cur.next = new ListNode(d);

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        return head;
    }
}