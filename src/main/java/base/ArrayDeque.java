package base;

import java.util.Arrays;
import java.util.NoSuchElementException;

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
            front = rear = 0;
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
            front = rear = 0;
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
            front = rear = -1;
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
            front = rear = -1;
        } else {
            // Move end pointer position
            rear = (rear - 1 + elements.length) % elements.length;
        }

        size --;

        return tempElement;
    }

    @Override
    public E getFirst() {
        if (front == -1) {
            throw new NoSuchElementException();
        }

        return elements[front];
    }

    @Override
    public E getLast() {
        if (rear == -1) {
            throw new NoSuchElementException();
        }

        return elements[rear];
    }

    @Override
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override
    public E remove() {
        return removeFirst();
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void empty() {
        Arrays.fill(elements, null);
        size = 0;
        front = -1;
        rear = -1;
    }

    @Override
    public void print() {
        int start = front;

        while (start != rear) {
            System.out.println(elements[start]);

            start = (++ start) % elements.length;
        }

        System.out.println(elements[rear]);
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
        int remaining = size;
        int tempFirst = front;

        @Override
        public boolean hasNext() {
            return remaining > 0;
        }

        @Override
        public E next() {
            assert hasNext();

            E tempElement = elements[tempFirst];

            remaining --;
            tempFirst = (++ tempFirst) % elements.length;

            return tempElement;
        }
    }
}
