import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    // Merge two sorted linked lists and return it as a new sorted list.
    // The new list should be made by splicing together the nodes of the first two lists.

    // Input: l1 = [1,2,4], l2 = [1,3,4]
    // Output: [1,1,2,3,4,4]

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode p = l1;
        ListNode q = l2;

        while (p != null || q != null) {

            // if p or q is null add the one that's not null into LL
            if (p == null || q == null) {
                curr.next = (p != null) ? new ListNode(p.val) : new ListNode(q.val);
                if (p != null) p = p.next;
                else q = q.next;
                curr = curr.next;
                continue;
            }

            // cases where values are not null for both
            int num1 = p.val;
            int num2 = q.val;

            if (num1 < num2) {
                curr.next = new ListNode(num1);
                p = p.next;
            }
            else if (num1 > num2) {
                curr.next = new ListNode(num2);
                q = q.next;
            }
            else {
                curr.next = new ListNode(num1);
                curr.next.next = new ListNode(num2);
                curr = curr.next;
                q = q.next;
                p = p.next;
            }
            curr = curr.next;
        }
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
    
    // Given a linked list, swap every two adjacent nodes and return its head.

    // Input: head = [1,2,3,4]
    // Output: [2,1,4,3]

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = first.next;
            current.next = second;
            second.next = first;
            first.next = second.next;
            current = first;
        }

        return dummy.next;
    }

}
