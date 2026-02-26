package LinkedList;


public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;

        size++;
    }

    // insert using recursion
    public void insertRec(int val, int index) {
        head = insertRec(val, index, head);
    }
    private Node insertRec(int val, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index-1, node.next);
        return node;
    }


    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }

        Node prev = get(index - 1);
        int val = prev.next.value;

        prev.next = prev.next.next;
        size--;
        return val;
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int deleteFirst() {
        int val = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return val;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    //https://leetcode.com/problems/merge-two-sorted-lists/description
    public LL mergeLists(Node firstHead, Node secondHead){
        Node f = firstHead;
        Node s = secondHead;
        LL ans = new LL();

        while(f != null && s != null){
            if(f.value < s.value){
                ans.insertLast(f.value);
                f = f.next;
            } else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }
        while(f != null){
            ans.insertLast(f.value);
            f = f.next;
        }
        while(s != null){
            ans.insertLast(s.value);
            s = s.next;
        }
        return ans;
    }

    //https://leetcode.com/problems/linked-list-cycle/description (Extension)
    public int cycleLength(Node head){
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                Node temp = fast;
                int length = 0;
                do{
                    temp = temp.next;
                    length++;
                } while (temp != fast);
                return length;
            }
        }
        return 0;
    }

    //https://leetcode.com/problems/linked-list-cycle-ii/
    public Node detectCycle(Node head){
        int cycleLength = cycleLength(head);
        if(cycleLength == 0)
            return null;
        Node first = head;
        Node second = head;

        while(cycleLength > 0){
            second = second.next;
            cycleLength--;
        }

        while(first != second){
            first = first.next;
            second = second.next;
        }

        return first;
    }

    //https://leetcode.com/problems/happy-number/description
    public boolean isHappy(int n){
        int slow = n;
        int fast = n;

        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while(slow != fast);

        if(slow == 1)
            return true;
        return false;
    }

    private int findSquare(int num){
        int ans = 0;
        while(num > 0){
            int digit = num % 10;
            ans += digit * digit;
            num /= 10;
        }
        return ans;
    }

    //recursion reverse
    private void reverse(Node node){
        if(node == tail){
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        node.next = null;
        tail = node;
    }

    //iterative reverse
    private Node iterativeReverse(Node node){
        if(node == null || node.next == null)
            return node;
        Node prev = null;
        Node present = node;
        Node next = present.next;

        while(present != null){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null)
                next = next.next;
        }
        return prev;
    }

    //http://leetcode.com/problems/reverse-linked-list-ii/
    public void reverseBetween(Node head, int left, int right) {
        if(left == right)
            return;
        Node prev = null;
        Node present = head;

        for(int i = 0; present != null && i < left - 1; i++){
            prev = present;
            present = present.next;
        }

        Node last = prev;
        Node newEnd = present;
        Node next = present.next;
        for(int i = 0; present != null && i < right - left + 1; i++){
            present.next = prev;
            prev = present;
            present = next;
            if(next != null)
                next = next.next;
        }
        if(last != null)
            last.next = prev;
        else
            head = prev;

        newEnd.next = present;
        return;
    }

    //https://leetcode.com/problems/palindrome-linked-list/description
    private boolean isPalindrome(Node head){
        Node mid = middleNode(head);
        Node secondHead = iterativeReverse(mid);
        Node reReverseHead = secondHead;

        while(head != null && secondHead != null){
            if(head.value != secondHead.value)
                break;
            head = head.next;
            secondHead = secondHead.next;
        }
        iterativeReverse(reReverseHead);
        return head == null || secondHead == null;
    }

    private Node middleNode(Node head) {
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //https://leetcode.com/problems/reorder-list/description
    private void reorderList(Node head){
        if(head == null || head.next == null)
            return;
        Node mid = middleNode(head);

        Node firstHead = head;
        Node secondHead = iterativeReverse(mid);

        while(firstHead != null && secondHead != null){
            Node temp = firstHead.next;
            firstHead.next = secondHead;
            firstHead = temp;

            temp = secondHead.next;
            secondHead.next = firstHead;
            secondHead = temp;
        }

        if(firstHead != null)
            firstHead.next = null;
    }

    private int listLength(Node head){
        if(head == null)
            return 0;
        Node temp = head;
        int ans = 0;
        while(temp!= null){
            ans++;
            temp = temp.next;
        }
        return ans;
    }

    //Hard : https://leetcode.com/problems/reverse-nodes-in-k-group/description
    private Node reverseKGroup(Node head, int k){
        if(k <= 1 || head == null)
            return head;

        Node prev = null;
        Node present = head;
        int remainingLength = listLength(head);

        while(remainingLength >= k){
            Node last = prev;
            Node newEnd = present;
            Node next = present.next;

            for(int i = 0; present != null && i < k; i++){
                present.next = prev;
                prev = present;
                present = next;
                if(next != null) {
                    next = next.next;
                }
            }
            if(last != null)
                last.next = prev;
            else
                head = prev;

            newEnd.next = present;
            prev = newEnd;
            remainingLength -= k;
        }
        return head;
    }

    private Node rotateRight(Node head, int k){
        if(k <= 0 || head == null || head.next == null)
            return head;
        Node last = head;
        int length = 1;
        while(last.next != null){
            last = last.next;
            length++;
        }
        last.next = head;
        int rotations = k % length;
        int skip = length - rotations;
        Node newLast = head;

        for (int i = 0; i < skip - 1; i++) {
            newLast = newLast.next;
        }

        head = newLast.next;
        newLast.next = null;
        return head;
    }

    public static void main(String[] args) {
        LL first = new LL();
        LL second = new LL();

        first.insertLast(1);
        first.insertLast(2);
        first.insertLast(3);
        first.insertLast(2);
        first.insertLast(1);
        first.insertLast(7);
        first.insertLast(8);

        first.display();
//        first.reverseBetween(first.head, 3,5);
        first.reorderList(first.head);
//        System.out.println(first.reOrderList(first.head));
        first.display();
    }
}
