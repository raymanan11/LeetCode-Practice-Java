import java.util.LinkedList;

public class Misc {
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

    // Given a 32-bit signed integer, reverse digits of an integer.

    public int reverse(int x) {

        if (x == 0) return x;

        long a = x;
        String result = "";
        boolean negative = false;
        if (a < 0) {
            a = 0 - a;
            negative = true;
        }

        while (a != 0) {
            result = result.concat(String.valueOf(a % 10));
            a /= 10;
        }

        long numResult = Long.parseLong(result);
        if (negative) {
            numResult = 0 - numResult;
        }

        if(numResult < Integer.MIN_VALUE || numResult > Integer.MAX_VALUE) return 0;

        return (int) numResult;
    }

    

}
