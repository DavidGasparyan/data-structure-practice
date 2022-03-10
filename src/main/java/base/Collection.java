package base;

public interface Collection<E> extends Iterable<E>  {
    boolean isEmpty();
    void empty();
    void print();
    int size();
    Iterator<E> iterator();
}
