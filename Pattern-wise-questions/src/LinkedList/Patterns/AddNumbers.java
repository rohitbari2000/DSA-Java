package LinkedList.Patterns;

import LinkedList.Patterns.util.ListNode;

class AddNumbers {
    // Lists in reverse order: 2 -> 4 -> 3 represents 342
    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), p = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) { sum += l1.val; l1 = l1.next; }
            if (l2 != null) { sum += l2.val; l2 = l2.next; }
            p.next = new ListNode(sum % 10);
            carry = sum / 10;
            p = p.next;
        }
        return dummy.next;
    }

    // If numbers are stored in forward order, you can reverse or use stacks.
}
