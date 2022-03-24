package base;

public class HashSet<E> implements SetADT<E> {
  private Node[] hashTable = (Node[]) new Object[22];
  private int size = 0;

  public HashSet() {

  }

  @Override
  public boolean add(E e) {
    if(contains(e)) {
      return false;
    }

    int hashIndex = hash(e);

    hashTable[hashIndex] = new Node(e, hashTable[hashIndex]);

    size ++;
    return true;
  }

  @Override
  public boolean remove(E e) {
    int hashIndex = e.hashCode();

    Node previousPointer = null;
    Node pointer = hashTable[hashIndex];

    while (pointer != null) {
      if (pointer.data.equals(e)) {
        if (previousPointer == null) {
          hashTable[hashIndex] = pointer.next;
        } else {
          previousPointer.next = pointer.next;
          // Help garbage collector
          pointer = null;
        }

        size --;

        return true;
      }

      previousPointer = pointer;
      pointer = pointer.next;
    }

    return false;
  }

  @Override
  public boolean contains(E e) {
    int hashIndex = hash(e);

    Node pointer = hashTable[hashIndex];

    while(pointer != null) {
      if(pointer.data.equals(e)) {
        return true;
      }

      pointer = pointer.next;
    }

    return false;
  }

  @Override
  public void extend(SetADT<E> s) {
    Iterator<E> iterator = s.iterator();

    while(iterator.hasNext()) {
      E e = iterator.next();

      if(!contains(e)) {
        add(e);
      }
    }
  }

  public static <E> SetADT<E> union(SetADT<E> s1, SetADT<E> s2) {
    SetADT<E> s = new HashSet<>();

    Iterator<E> iterator1 = s1.iterator();

    while(iterator1.hasNext()) {
      E element = iterator1.next();
      s.add(element);
    }

    Iterator<E> iterator2 = s2.iterator();

    while(iterator2.hasNext()) {
      E element = iterator2.next();
      s.add(element);
    }

    return s;
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
    return 0;
  }

  @Override
  public Iterator iterator() {
    return null;
  }

  private int hash(E e) {
    return e.hashCode() % hashTable.length;
  }

  protected class Node {
    E data;
    Node next;

    public Node(E data) {
      this.data = data;
      this.next = null;
    }

    public Node(E data, Node next) {
      this.data = data;
      this.next = next;
    }
  }
}
