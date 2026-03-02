package LinkedList.Patterns;

import LinkedList.Patterns.util.ListNode;

import java.util.HashSet;
import java.util.Set;

class HashPattern {
    // Remove duplicates from unsorted list
    static ListNode removeDuplicatesUnsorted(ListNode head) {
        if (head == null) return null;
        Set<Integer> seen = new HashSet<>();
        ListNode dummy = new ListNode(0); dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null) {
            if (seen.contains(prev.next.val)) prev.next = prev.next.next;
            else { seen.add(prev.next.val); prev = prev.next; }
        }
        return dummy.next;
    }

    // Detect cycle using HashSet
    static boolean hasCycleUsingSet(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (!seen.add(head)) return true;
            head = head.next;
        }
        return false;
    }
}
