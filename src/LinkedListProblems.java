import java.util.List;

public class LinkedListProblems {

    // Given the head of a linked list, remove the nth node from the end of the list and return its head.

    // Input: head = [1,2,3,4,5], n = 2   [1,2,3], n = 3   [1,2], n = 1
    // Output: [1,2,3,5]                  [2.3]            [1]


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy;
        ListNode l2 = dummy;

        for (int i = 1; i <= i + 1; i++) {
            l1 = l1.next;
        }

        while (l1 != null) {
            l1 = l1.next;
            l2 = l2.next;
        }

        l2.next = l2.next.next;
        return dummy.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
