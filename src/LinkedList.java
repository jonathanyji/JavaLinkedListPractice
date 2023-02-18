import java.util.NoSuchElementException;

public class LinkedList {
    private Node first;
    private Node last;


    //addFirst
    public void addFirst(int item){
        Node node = new Node(item);

        if (isEmpty()){
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
    }

    //addLast
    public void addLast(int item){
        Node node = new Node(item);

        //Check to see if list is empty or not
        if (isEmpty()){
            first = node;
            last = node;
            //Also can be written as first = last = node;

        } else {
            // Linking last node to current node
            last.next = node;
            //Update last to point to new node
            last = node;
        }

    }

    //deleteFirst
    public void removeFirst(){
        // [10 -> 20 -> 30]

        if (isEmpty())
            throw new NoSuchElementException();

        //Case where the list has only 1 item
        if (first == last){
            first = last = null;
            return;
        }

        Node second = first.next;
        first.next = null;
        first = second;
    }

    //deleteLast
    public void removeLast(){
        // [10 -> 20 -> 30]
        // last -> 30
        last = getPrevious(last);
        last.next = null;

    }

    //contains
    public boolean contains(int item){
        return indexOf(item) != -1;
    }

    //indexOf
    public int indexOf(int item){
        //Traverse this list and find the index of this item
        int index = 0;
        Node currentNode = first;

        while (currentNode != null){
            if (currentNode.value == item) return index;
            currentNode = currentNode.next;
            index ++;
        }

        return -1;
    }

    private boolean isEmpty(){
        return first == null;
    }

    private Node getPrevious(Node node){
        Node currentNode = first;
        while (currentNode != null){
            if (currentNode.next == node) return currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

}
