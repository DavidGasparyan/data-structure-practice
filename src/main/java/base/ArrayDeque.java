package base;

public class ArrayDeque<E> implements Deque<E> {
    private E[] elements;
    private int front = -1;
    private int rear = -1;
    private int size = 0;

    ArrayDeque() {
        elements = (E[]) new Object[10];
    }

    ArrayDeque(int length) {
        elements = (E[]) new Object[length];
    }

    @Override
    public void addFirst(E e) {

        if (size == elements.length) {
            doubleCapacity();
        }

        if (front == -1) {
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + elements.length) % elements.length;
        }

        elements[front] = e;

        size ++;
    }

    @Override
    public void addLast(E e) {

        if (size == elements.length) {
            doubleCapacity();
        }

        if (front == -1 && rear == -1) {
            front = 0;
            rear = 0;
        } else {
            rear = (++ rear) % elements.length;
        }

        elements[rear] = e;

        size ++;
    }

    @Override
    public E removeFirst() {
        // Nothing to return if Deque is empty
        if (front == -1 && rear == -1) {
            return null;
        }

        E tempElement = elements[front];

        // Delete current element
        elements[front] = null;

        // If front and rear are equal then
        // this is the last element in the array
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            // Move front pointer position
            front = (++ front) % elements.length;
        }

        size --;

        return tempElement;
    }

    @Override
    public E removeLast() {
        // Nothing to return if Deque is empty
        if (front == -1) {
            return null;
        }

        E tempElement = elements[rear];

        // Delete current element
        elements[rear] = null;

        // If front and rear are equal then
        // this is the last element in the array
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            // Move end pointer position
            rear = (rear - 1 + elements.length) % elements.length;
        }

        size --;

        return tempElement;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void empty() {

    }

    @Override
    public void print() {
        for (E element: elements) {
            System.out.println(element);
        }
    }

    @Override
    public int size() {
        return size;
    }

    private void doubleCapacity() {
        int length = elements.length;
        int elementsToFrontRight = length - front;

        E[] temp = (E[]) new Object[length * 2];

        System.arraycopy(elements, front, temp, 0, elementsToFrontRight);
        System.arraycopy(elements, 0, temp, elementsToFrontRight, front);

        elements = temp;
        rear = length - 1;
        front = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<E> {
        int tempSize = size;
        int tempFirst = front;

        @Override
        public boolean hasNext() {
            return tempSize > 0;
        }

        @Override
        public E next() {
            assert hasNext();

            E tempElement = elements[tempFirst];

            tempSize --;
            tempFirst = (++ tempFirst) % elements.length;

            return tempElement;
        }
    }
}
