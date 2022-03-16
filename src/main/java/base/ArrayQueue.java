package base;

import java.util.Arrays;

public class ArrayQueue<E> implements Queue<E> {
    private E[] elements;
    private int front = -1;
    private int rear = -1;
    private int size = 0;

    public ArrayQueue() {
        elements = (E []) new Object[10];
    }

    public ArrayQueue(int size) {
        elements = (E []) new Object[size];
    }

    public void enqueue(E e) {

        if (size == elements.length) {
            doubleCapacity();
        }

        if (front == -1 && rear == -1) {
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + elements.length) % elements.length;
        }

        size ++;
        elements[front] = e;
    }

    private void addLast(E e) {
        if (size == elements.length) {
            doubleCapacity();
        }

        if (front == -1 && rear == -1) {
            front = 0;
            rear = 0;
        } else {
            rear = (++rear) % elements.length;
        }

        size ++;
        elements[rear] = e;
    }

    public void dequeue() {
        if (!isEmpty()) {
            elements[rear] = null;

            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                rear = (rear - 1 + elements.length) % elements.length;
            }

            size--;
        }
    }

    public E first() {
        return elements[front];
    }

    public E last() {
        return elements[rear];
    }

    private void doubleCapacity() {
        E[] tempElements = (E[]) new Object[elements.length * 2];

        System.arraycopy(elements, front, tempElements, 0, elements.length - front);
        System.arraycopy(elements, 0, tempElements, elements.length - front, front);


        front = 0;
        rear = elements.length - 1;
        elements = tempElements;
    }

    private boolean addAt(E e, int index) {
        if (index > size || index < 0) {
            return false;
        }

        if (index == front) {
            enqueue(e);
            return true;
        }

        if (index == rear) {
            addLast(e);
            return true;
        }

        size++;

        if (size == elements.length) {
            doubleCapacity();
        }

        int pointer = front;

        while(index > 0) {
            pointer = (pointer - 1 + elements.length) % elements.length;
            index --;
        }

        // Case when index is front position
        // Case when index is rear position
        // Case when in between
        // Case when array needs to resize;


        return true;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }

        return elements[front];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void empty() {
        Arrays.fill(elements, null);

        front = -1;
        rear = -1;
        size = 0;
    }

    @Override
    public void print() {
        for( int i = front; i != rear; i = (++i) % elements.length) {
            System.out.println(elements[i]);
        }

        System.out.println(elements[rear]);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E e) {
        enqueue(e);
        return true;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator();
    }

    private class ArrayQueueIterator implements Iterator<E> {
        int remainder = size;
        int next = front;

        @Override
        public boolean hasNext() {
            return remainder > 0;
        }

        @Override
        public E next() {
            assert hasNext();
            E currentElement = elements[next];

            remainder --;
            next = (++next) % elements.length;

            return currentElement;
        }
    }
}
