package LinkedList.Patterns;

public class LinkedListPatterns {
    public static void main(String[] args) {
        // Build example list: 1->2->3->4->5
        ListNode head = Utils.build(new int[]{1,2,3,4,5});
        System.out.print("Original: "); Utils.print(head);

        // Reverse iteratively
        ListNode rev = Reversal.reverseBetween(head, 2, 4);
        System.out.print("Reversed: "); Utils.print(rev);

        // Reverse back (recursive)
        ListNode back = Reversal.reverseRec(rev);
        System.out.print("Back: "); Utils.print(back);

        // Middle
        System.out.println("Middle value: " + TwoPointer.middleNode(back).val);

        // Remove 2nd from end (n=2) -> removes 4
        ListNode removed = TwoPointer.removeNthFromEnd(back, 2);
        System.out.print("After remove 2nd from end: "); Utils.print(removed);

        // Merge two sorted lists example
        ListNode a = Utils.build(new int[]{1,3,5});
        ListNode b = Utils.build(new int[]{2,4,6});
        ListNode merged = MergeSort.mergeTwo(a,b);
        System.out.print("Merged: "); Utils.print(merged);

        // Add two numbers: 342 + 465 = 807
        ListNode n1 = Utils.build(new int[]{2,4,3}); // 342
        ListNode n2 = Utils.build(new int[]{5,6,4}); // 465
        ListNode sum = AddNumbers.addTwoNumbers(n1, n2);
        System.out.print("Sum list (reverse digits): "); Utils.print(sum);
    }
}
