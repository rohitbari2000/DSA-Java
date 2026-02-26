package LinkedList;

public class Link {
    public int key;
    public int data;
    public Link next;
    public Link prev;
    public Link(){}
    public Link(int key, int data){
        this.key = key;
        this.data = data;
    }

    public void display(){
        System.out.println("{" + key + "," + data + "}");
    }

    public static void main(String[] args) {
        DLL list = new DLL();

        list.insertFirst(1, 10);
        list.insertFirst(2, 20);
        list.insertFirst(3, 30);

        list.insertLast(4, 1);
        list.insertLast(5, 40);
        list.insertLast(6, 56);

        System.out.print("\nList (First to Last): ");
        list.displayForward();
        System.out.println("");
        System.out.print("\nList (Last to first): ");
        list.displayBackward();

        System.out.print("\nList , after deleting first record: ");
        list.deleteFirst();
        list.displayForward();

        System.out.print("\nList , after deleting last record: ");
        list.deleteLast();
        list.displayForward();

        System.out.print("\nList , insert after key(4) : ");
        list.insertAfter(4,7, 13);
        list.displayForward();

        System.out.print("\nList  , after delete key(4) : ");
        list.delete(4);
        list.displayForward();
    }
}
