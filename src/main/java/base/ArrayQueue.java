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

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    public void enqueue(E e) {

        if (size == elements.length) {
            doubleCapacity();
        }

        if (front == -1 && rear == -1) {
            front = 0;
            rear = 0;
        } else {
            rear = (++ rear) % elements.length;
        }

        size ++;
        elements[rear] = e;
    }

    public void dequeue() {
        if (!isEmpty()) {
            elements[front] = null;

            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (++front) % elements.length;
            }

            size--;
        }
    }

    private void doubleCapacity() {
        E[] tempElement = (E[]) new Object[elements.length * 2];

        for(int i = front; i <= rear; i ++) {
            tempElement[i - front] = elements[i];
        }

        elements = tempElement;
    }


    @Override
    public E peek() {
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
        for(int i = front; i <= rear; i ++) {
            System.out.println(elements[i]);
        }
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
            next ++;

            return currentElement;
        }
    }
}
