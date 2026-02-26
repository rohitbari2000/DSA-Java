package LinkedList;

public class DLL {
    private Link first;
    private Link last;

    public DLL() {
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(int key, int data){
        Link link = new Link(key, data);

        if(isEmpty())
            last = link;
        else
            first.prev = link;
        link.next = first;
        first = link;
    }

    public void insertLast(int key, int data){
        Link link = new Link(key, data);

        if(isEmpty()){
            last = link;
        }else {
            last.next = link;
            link.prev = last;
        }
        last = link;
    }

    public Link deleteFirst(){
        Link tempLink = first;
        if(first.next == null)
            last = null;
        else
            first.next.prev = null;
        first = first.next;
        return tempLink;
    }

    public Link deleteLast(){
        Link tempLink = first;
        if(first.next == null)
            first = null;
        else
            last.prev.next = null;
        last = last.prev;
        return tempLink;
    }

    //display the list in from first to last
    public void displayForward(){
        //start from the beginning
        Link current = first;
        //navigate till the end of the list
        System.out.print("[ ");
        while(current != null){
            //print data
            current.display();
            //move to next item
            current = current.next;
            System.out.print(" ");
        }
        System.out.print(" ]");
    }

    //display the list from last to first
    public void displayBackward(){
        //start from the last
        Link current = last;
        //navigate till the start of the list
        System.out.print("[ ");
        while(current != null){
            //print data
            current.display();
            //move to next item
            current = current.prev;
            System.out.print(" ");
        }
        System.out.print(" ]");
    }

    public Link delete(int key){
        if(first == null)
            return null;

        Link current = first;
        while(current.key != key){
            if(current.next == null)
                return null;
            else
                current = current.next;
        }

        //found the match, update the link
        if(current == first)
            first = current.next;
        else{
            current.prev.next = current.next;
        }

        if(current == last)
            last = current.prev;
        else {
            current.next.prev = current.prev;
        }
        return current;
    }

    public boolean insertAfter(int key, int newKey, int data){
        if (first == null)
            return false;
        Link current = first;

        while(current.key != key){
            if(current.next == null){
                return false;
            }else{
                current = current.next;
            }
        }

        Link newLink = new Link(newKey,data);
        if(current == last){
            newLink.next = null;
            last = newLink;
        }
        else{
            newLink.next = current.next;
            current.next.prev = newLink;
        }
        newLink.prev = current;
        current.next = newLink;
        return true;
    }
}