public class LinkedListDeque<T> implements Deque<T> {

    private class DataNode {
        private T item;
        private DataNode next;
        private DataNode prev;

        private DataNode(DataNode p, DataNode n, T i) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private DataNode sentFirst;
    private DataNode sentBack;
    private int size;


    @Override//Adds an item T to the front of the deque
    public void addFirst(T item) {

        DataNode tempNode = new DataNode(null, null, item);
        tempNode.next = sentFirst.next;
        tempNode.prev = sentFirst;
        sentFirst.next.prev = tempNode;
        sentFirst.next = tempNode;

        size++;
    }

    @Override//Adds an item T to the back to the deque
    public void addLast(T item) {

        DataNode tempNode = new DataNode(null, null, item);
        tempNode.next = sentBack;
        tempNode.prev = sentBack.prev;
        sentBack.prev.next = tempNode;
        sentBack.prev = tempNode;

        size++;
    }

    /*Returns whether or not the deque is empty
    public boolean isEmpty() {

        return size == 0;
    }*/

    @Override//Returns the number of items in the deque
    public int size() {

        return size;
    }

    @Override//Prints the elements in the deque from first to last separated by a space
    public void printDeque() {

        int counter = 0;
        DataNode tempNode = sentFirst.next;
        while (counter < size) {
            System.out.print(tempNode.item + ", ");
            counter++;
            tempNode = tempNode.next;
        }
    }

    @Override//Removes and returns the first item in the deque
    public T removeFirst() {

        if (sentFirst.next == sentBack || sentBack.prev == sentFirst) {
            return null;
        }
        T answer = sentFirst.next.item;
        sentFirst.next = sentFirst.next.next;
        sentFirst.next.prev = sentFirst;

        if (size >= 1) {
            size--;
        }

        return answer;
    }

    @Override//Removes and returns the last item in the deque
    public T removeLast() {

        if (sentFirst.next == sentBack || sentBack.prev == sentFirst) {
            return null;
        }
        T answer = sentBack.prev.item;
        sentBack.prev = sentBack.prev.prev;
        sentBack.prev.next = sentBack;

        if (size >= 1) {
            size--;
        }

        return answer;
    }

    @Override//Returns the item at the given index
    public T get(int index) {

        if (index >= size || index < 0) {
            return null;
        }

        int counter = 0;
        DataNode tempNode = sentFirst.next;
        while (counter < index) {
            tempNode = tempNode.next;
            counter++;
        }

        return tempNode.item;
    }

    //Creates an empty Linked List Deque
    public LinkedListDeque() {

        sentFirst = new DataNode(null, null, null);
        sentBack = new DataNode(null, null, null);
        sentFirst.next = sentBack;
        sentBack.prev = sentFirst;
        size = 0;
    }

    //Creates a deep copy of other
    public LinkedListDeque(LinkedListDeque other) {

        sentFirst = new DataNode(null, null, null);
        sentBack = new DataNode(null, null, null);
        sentFirst.next = sentBack;
        sentBack.prev = sentFirst;
        size = 0;

        DataNode tempNode = other.sentFirst.next;
        while (tempNode != other.sentBack) {
            this.addLast(tempNode.item);
            tempNode = tempNode.next;
        }
        this.size = other.size;
    }

    //Recursive version of get
    public T getRecursive(int index) {

        return helperFunction(index, sentFirst.next);
    }

    private T helperFunction(int n, DataNode node) {

        if (n == 0) {
            return node.item;
        }
        return helperFunction(n - 1, node.next);
    }
}
