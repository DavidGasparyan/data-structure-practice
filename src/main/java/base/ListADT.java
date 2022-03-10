package base;

public interface ListADT<E> extends Collection<E> {
    void addFirst(E e);
    E removeFirst();
    void addLast(E e);
    E removeLast();
    E first();
    E last();
    boolean replace(E e, E r);
}
