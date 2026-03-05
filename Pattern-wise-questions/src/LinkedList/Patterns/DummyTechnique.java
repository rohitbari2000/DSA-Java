package LinkedList.Patterns;

class DummyTechnique {
    // Remove all nodes with given value
    static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0); dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return dummy.next;
    }

    // Partition around x (like stable partition)
    static ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0), before = beforeHead;
        ListNode afterHead = new ListNode(0), after = afterHead;
        while (head != null) {
            if (head.val < x) { before.next = head; before = before.next; }
            else { after.next = head; after = after.next; }
            head = head.next;
        }
        after.next = null;
        before.next = afterHead.next;
        return beforeHead.next;
    }
}
