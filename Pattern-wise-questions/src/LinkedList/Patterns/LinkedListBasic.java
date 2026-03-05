package LinkedList.Patterns;

class LinkedListBasic {
    // Insert at end
    static ListNode insertEnd(ListNode head, int val) {
        ListNode node = new ListNode(val);
        if (head == null)
            return node;
        ListNode cur = head;
        while (cur.next != null)
            cur = cur.next;
        cur.next = node;
        return head;
    }

    // Delete first occurrence of value
    static ListNode deleteValue(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
                break;
            }
            prev = prev.next;
        }
        return dummy.next;
    }

    // Length
    static int length(ListNode head) {
        int n = 0;
        while (head != null) {
            n++;
            head = head.next;
        }
        return n;
    }

    static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }
}
