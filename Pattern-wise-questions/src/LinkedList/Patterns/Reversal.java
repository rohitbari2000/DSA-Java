package LinkedList.Patterns;

class Reversal {
    // Iterative reverse
    static ListNode reverseIter(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nxt;
        }
        return prev;
    }

    // Recursive reverse (returns new head)
    static ListNode reverseRec(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseRec(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    // Reverse between left and right (1-indexed)
    static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) prev = prev.next;
        ListNode cur = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode nex = cur.next;
            cur.next = nex.next;
            nex.next = prev.next;
            prev.next = nex;
        }
        return dummy.next;
    }

    // Reverse nodes in k-group
    static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0), prev = dummy;
        dummy.next = head;
        while (true) {
            ListNode kth = prev;
            for (int i = 0; i < k && kth != null; i++) kth = kth.next;
            if (kth == null) break;
            ListNode groupNext = kth.next;
            // reverse group
            ListNode prevNode = groupNext, curr = prev.next;
            while (curr != groupNext) {
                ListNode tmp = curr.next;
                curr.next = prevNode;
                prevNode = curr;
                curr = tmp;
            }
            ListNode tmp = prev.next;
            prev.next = kth;
            prev = tmp;
        }
        return dummy.next;
    }
}
