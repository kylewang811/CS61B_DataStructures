public class ArrayDeque<T> implements Deque<T> {

    private int size;
    private T[] items;
    private int nextFirst;
    private int nextBack;

    private int increment(int index) {
        return (index + 1) % items.length;
    }

    private int decrement(int index) {
        return (index - 1 + items.length) % items.length;
    }

    private void resize(int len) {
        T[] temp = (T[]) new Object[len];
        if (len < items.length) {
            System.arraycopy(items, increment(nextFirst), temp, 0, size);
        } else {
            System.arraycopy(items, increment(nextFirst), temp, 0,
                    items.length - increment(nextFirst));
            System.arraycopy(items, 0, temp, items.length - increment(nextFirst), nextFirst);
        }
        items = temp;
        nextFirst = items.length - 1;
        nextBack = size;
    }

    @Override//Adds an item T to the front of the deque
    public void addFirst(T item) {
        if (nextFirst == nextBack && size == items.length - 1) {
            resize(items.length * 2);
        }
        items[nextFirst] = item;
        nextFirst = decrement(nextFirst);
        size++;
    }

    @Override//Adds an item T to the back to the deque
    public void addLast(T item) {
        if (nextFirst == nextBack && size == items.length - 1) {
            resize(items.length * 2);
        }
        items[nextBack] = item;
        nextBack = increment(nextBack);
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

        for (int i = 0; i < size; i++) {
            System.out.print(this.get(i) + " ");
        }
    }

    @Override//Removes and returns the first item in the deque
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T answer = items[increment(nextFirst)];
        items[increment(nextFirst)] = null;
        nextFirst = increment(nextFirst);
        size -= 1;
        if (size != 0 && items.length >= 16 && (double) size / items.length < 0.25) {
            resize(items.length / 2);
        }
        return answer;
    }

    @Override//Removes and returns the last item in the deque
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T answer;
        answer = items[decrement(nextBack)];
        items[decrement(nextBack)] = null;
        nextBack = decrement(nextBack);
        size -= 1;
        if (size != 0 && items.length >= 16 && (double) size / items.length < 0.25) {
            resize(items.length / 2);
        }
        return answer;
    }

    @Override//Returns the item at the given index
    public T get(int index) {

        if (index >= 0 && index < items.length) {
            return items[increment(nextFirst + index)];
        }
        return null;
    }

    //Creates an empty array deque
    public ArrayDeque() {

        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextBack = 1;
    }

    //Creates a deep copy of other
    public ArrayDeque(ArrayDeque other) {

        items = (T[]) new Object[other.items.length];
        int counter = 0;
        while (counter < other.items.length) {
            items[counter] = (T) other.items[counter];
            counter += 1;
        }
        this.size = other.size;
        this.nextFirst = other.nextFirst;
        this.nextBack = other.nextBack;
    }
}
