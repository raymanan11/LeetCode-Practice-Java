import java.util.*;

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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        Set<Integer> unique = new HashSet<>();
        ListNode previous = new ListNode(0);
        while (current.next != null) {
            if (!unique.contains(current.next.val)) {
                unique.add(current.next.val);
                previous = current.next;
                current = current.next;
            }
            else previous.next = previous.next.next;
        }
        return dummy.next;
    }

    // Write a function to delete a node in a singly-linked list.
    // You will not be given access to the head of the list,
    // instead you will be given access to the node to be deleted directly.

    // It is guaranteed that the node to be deleted is not a tail node in the list.

    // Input: head = [4,5,1,9], node = 5
    // Output: [4,1,9]
    // Explanation: You are given the second node with value 5,
    // the linked list should become 4 -> 1 -> 9 after calling your function.

    public void deleteNode(ListNode node) {
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }

    // Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

    // Input: 1->2->3->3->4->4->5       Input: 1->1->1->2->3
    // Output: 1->2->5                  Output: 2->3

    public ListNode deleteDuplicatesAgain(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
        ListNode curr = dummy.next;
        ListNode prev = new ListNode(0);
        Set<Integer> common = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        // keep track of all the duplicate values in Linked List
        while (curr != null) {
            if (!common.contains(curr.val)) common.add(curr.val);
            else duplicates.add(curr.val);
            curr = curr.next;
        }

        // reset current node
        curr = dummy;

        while (curr != null) {
            // if node is not a duplicate set previous to current node and proceed to next node
            if (!duplicates.contains(curr.val)) {
                prev = curr;
                curr = curr.next;
            }
            // else this means it encountered a duplicate
            // set the previous to skip over current node and proceed to next node
            // set the current to be the previous nodes next node after previous step
            else {
                if (prev.next == null)
                    prev = curr;
                prev.next = prev.next.next;
                curr = prev.next;
            }
        }
        return dummy.next;
    }

    // You are given two linked lists: list1 and list2 of sizes n and m respectively.
    // Remove list1's nodes from the ath node to the bth node, and put list2 in their place.

    // Input: list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
    // Output: [0,1,2,1000000,1000001,1000002,5]
    // Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place.
    // The blue edges and nodes in the above figure indicate the result.

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE, list1);
        ListNode curr = dummy.next;
        ListNode prev = new ListNode(0);
        ListNode secondHalf = null;
        int count = 0;

        // keep track of the rest of the Linked List that needs to be added in second half
        while (curr.next != null) {
            if (count == b) {
                secondHalf = curr.next;
                break;
            }
            curr = curr.next;
            count++;
        }

        // reset values
        curr = dummy.next;
        count = 0;

        // once reaches a value, set the previous node's next value to list2
        while (curr.next != null) {
            if (count == a) {
                prev.next = list2;
                // set current == to list2 bc need to get to end of the LL to add secondHalf
                curr = prev.next;
            }
            prev = curr;
            curr = curr.next;
            count++;
        }

        // set the end of the LL to the second half
        if (secondHalf != null) curr.next = secondHalf;

        return dummy.next;
    }

    // Reverse a singly linked list.

    // Input: 1->2->3->4->5->NULL
    // Output: 5->4->3->2->1->NULL

    public ListNode reverseList(ListNode head) {

        ListNode dummy = new ListNode(0, head);
        ListNode current = dummy.next;

        ArrayList<Integer> reversedNumbers = new ArrayList<>();

        while (current != null) {
            reversedNumbers.add(current.val);
            current = current.next;
        }

        Collections.reverse(reversedNumbers);
        current = dummy.next;

        for (int reversedNum : reversedNumbers) {
            current.val = reversedNum;
            current = current.next;
        }
        return dummy.next;
    }

    // Given a singly linked list, determine if it is a palindrome.

    // Input: 1->2->2->1
    // Output: true

    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> numbers = new ArrayList<>();

        while (head != null) {
            numbers.add(head.val);
            head = head.next;
        }

        for (int i = 0; i < numbers.size() / 2; i++) if (numbers.get(i).equals(numbers.get(numbers.size() - 1 - i))) return false;

        return true;
    }

}
