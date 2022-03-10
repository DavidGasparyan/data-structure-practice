package base;

public interface Queue<E> extends Collection<E> {
    // Inserts the specified element into the queue.
    // Returns true in case of success
    boolean add(E e);

    // Retrieves and removes the head of the queue
    E remove();

    // Retrieves but does not remove the head of the queue.
    // Returns null if queue is empty
    E peek();
}
