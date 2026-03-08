package LinkedList.Patterns;

class MergeSort {
    // Merge two sorted lists
    static ListNode mergeTwo(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) { tail.next = l1; l1 = l1.next; }
            else { tail.next = l2; l2 = l2.next; }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    // Merge sort for linked list (O(n log n))
    static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        // split
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; // split
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return mergeTwo(l1, l2);
    }
}
