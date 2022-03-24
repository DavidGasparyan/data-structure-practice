package base;

public interface SetADT<T> extends Collection<T> {
  public boolean add(T e);

  public boolean remove(T e);

  public boolean contains(T e);

  public void extend(SetADT<T> s);
}
