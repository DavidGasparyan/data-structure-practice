package base;

public interface Queue<E> extends Collection<E> {
    // Inserts the specified element into the queue.
    // Returns true in case of success
    boolean add(E e);

    boolean offer(E e);

}
