import java.util.*;

public class LinkedListProblems {

    // Given the head of a linked list, remove the nth node from the end of the list and return its head.

    // Input: head = [1,2,3,4,5], n = 4   [1,2,3], n = 3   [1,2], n = 1
    // Output: [1,3,4,5]                  [2.3]            [1]


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy;
        ListNode l2 = dummy;

        for (int i = 0; i < n + 1; i++) {
            l1 = l1.next;
        }

        while(l1 != null) {
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
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;

        return head;
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

    // Given head, the head of a linked list, determine if the linked list has a cycle in it.

    // There is a cycle in a linked list if there is some node in the list that can be reached again by
    // continuously following the next pointer. Internally, pos is used to denote the index of the node
    // that tail's next pointer is connected to. Note that pos is not passed as a parameter.

    public boolean hasCycle(ListNode head) {
        Set<ListNode> uniqueNumbers = new HashSet<>();
        while (head != null) {
            if (!uniqueNumbers.contains(head)) uniqueNumbers.add(head);
            else return true;
            head = head.next;
        }
        return false;
    }

    // Remove all elements from a linked list of integers that have value val.

    // Input:  1->2->6->3->4->5->6, val = 6
    // Output: 1->2->3->4->5

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode curr = dummy;
        ListNode prev = new ListNode(0);

        while (curr != null) {
            if (curr.val != val) {
                prev = curr;
                curr = curr.next;
            }
            else {
                prev.next = curr.next;
                curr = prev.next;
            }
        }

        return dummy.next;

    }

    // Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

    // Input: head = [3,2,0,-4], pos = 1
    // Output: tail connects to node index 1
    // Explanation: There is a cycle in the linked list, where tail connects to the second node.

    public ListNode detectCycle(ListNode head) {
        Map<ListNode, Integer> uniqueLN = new HashMap<>();
        int location = 1;
        while (head != null) {
            if (!uniqueLN.containsKey(head)) uniqueLN.put(head, location);
            else return head;
            head = head.next;

        }
        return null;
    }

    // Given a non-empty, singly linked list with head node head, return a middle node of linked list.
    //If there are two middle nodes, return the second middle node.

    public ListNode middleNode(ListNode head) {
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        int middle = size / 2;
        size = 0;
        curr = head;
        while (curr != null) {
            if (size == middle) {
                break;
            }
            curr = curr.next;
            size++;
        }
        return curr;
    }

    public ListNode sortList(ListNode head) {
        ArrayList<Integer> sortedNumbers = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            sortedNumbers.add(curr.val);
            curr = curr.next;
        }
        curr = head;
        Collections.sort(sortedNumbers);
        int i = 0;
        while(curr != null) {
            curr.val = sortedNumbers.get(i);
            i++;
            curr = curr.next;
        }
        return head;
    }

    // Reverse a linked list from position m to n. Do it in one-pass.

    // Input: 1->2->3->4->5->6->7->8->NULL, m = 3, n = 6
    // Output: 1->2->6->5->4->3->7->8->NULL

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode prev = null, curr = head, next = null;

        while (m > 1) {
            prev = curr;
            curr = curr.next;
            m--;
            n--;
        }

        ListNode conn = prev, tail = curr;

        while (n > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            n--;
        }

        if (conn != null) conn.next = prev;
        else head = prev;

        tail.next = curr;
        return head;

    }

    // You are given two non-empty linked lists representing two non-negative integers.
    // The most significant digit comes first and each of their nodes contain a single digit.
    // Add the two numbers and return it as a linked list.

    public ListNode addTwoNumbersAgain(ListNode l1, ListNode l2) {
        Stack<Integer> aNums = new Stack<>();
        Stack<Integer> bNums = new Stack<>();

        while (l1 != null) {
            aNums.add(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            bNums.add(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode after = null;

        while (!aNums.isEmpty() || !bNums.isEmpty()) {
            int a = (!aNums.isEmpty()) ? aNums.pop() : 0;
            int b = (!bNums.isEmpty()) ? bNums.pop() : 0;

            int sum = a + b + carry;
            ListNode result = new ListNode(sum % 10);
            carry = sum / 10;
            result.next = after;
            after = result;
        }

        if (carry > 0) {
            ListNode additional = new ListNode(carry);
            additional.next = after;
            after = additional;
        }

        return after;
    }

    // Given the head of a linked list, rotate the list to the right by k places.

    // Input: head = [1,2,3,4,5], k = 2
    // Output: [4,5,1,2,3]

    public ListNode rotateRight(ListNode head, int k) {
        ListNode first = head;
        Stack<ListNode> stack = new Stack<>();

        if (head == null || head.next == null) return head;

        while (first != null) {
            stack.add(first);
            first = first.next;
        }

        k = k % stack.size();

        first = head;

        ListNode last = stack.pop();

        while (k > 0) {
            last.next = first;
            first = last;
            last = stack.pop();
            last.next = null;
            k--;
        }

        return first;
    }

}


