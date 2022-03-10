package base;

public interface Deque<E> extends Queue<E> {
    /** Inserts the specified element at the front of this deque. */
    void addFirst(E e);

    /** Inserts the specified element at the end of this deque. */
    void addLast(E e);

    /** Retrieves and removes the first element of this deque. */
    E removeFirst();

    /** Retrieves and removes the last element of this deque. */
    E removeLast();

    /** Retrieves, but does not remove, the first element of this deque. */
    E getFirst();

    /** Retrieves, but does not remove, the last element of this deque. */
    E getLast();

    /**
     *  Returns an iterator over the elements in this deque in proper sequence.
     *  The elements will be returned in order from first (head) to last (tail).
     */
    Iterator<E> iterator();

}
