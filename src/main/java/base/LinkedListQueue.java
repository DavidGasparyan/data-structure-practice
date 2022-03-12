package base;

import java.util.HashMap;

public class LinkedListQueue<E> implements Queue<E> {
    Node<E> first;
    Node<E> last;
    int size;

    protected class Node<E> {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next= next;
        }
    }

    public void enqueue(E e) {
        if (first == null) {
            first = last = new Node<E>(e, null);
        } else {
            Node<E> tempNode = last;
            last = new Node<E>(e, last);
            tempNode.next = last;
        }

        size ++;
    }

    public void dequeue() {
        if (first != null) {
            if (first == last) {
                first.next = null;
                first = null;
                last = null;
            } else {
                first = first.next;
            }

            size --;
        }
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
        if (first != null) {
            return first.element;
        }

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

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListQueueIterator();
    }

    private class LinkedListQueueIterator implements Iterator<E> {
        private int remainder = size();
        private Node<E> end = last;

        @Override
        public boolean hasNext() {
            return remainder > 0;
        }

        @Override
        public E next() {
            assert hasNext();

            Node<E> previous = null;
            Node<E> current = first;
            Node<E> temp = end;

            while(current != null) {

                if (current == end) {
                    break;
                }

                previous = current;
                current = current.next;
            }

            end = previous;
            remainder --;

            return temp.element;
        }
    }
}
