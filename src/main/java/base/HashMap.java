package base;

public class HashMap<K, V> implements MapADT<K, V> {
  private int size = 0;
  private int capacity = 16;
  private Entry[] hashTable = (Entry[]) new Object[capacity];

  public HashMap() {

  }

  private int hash(K key) {
    return key.hashCode() % capacity;
  }


  @Override
  public V put(K key, V value) {
    int hashIndex = hash(key);
    Entry e = hashTable[hashIndex];

    while(e != null) {

      if (e.key == key || e.key.equals(key)) {
        V oldValue = e.value;

        e.value = value;

        return oldValue;
      }

      e = e.next;
    }

    size ++;
    hashTable[hashIndex] = new Entry(key, value, hashTable[hashIndex]);

    return value;
  }

  @Override
  public boolean containsKey(Object o) {
    return false;
  }

  @Override
  public boolean containsValue(Object o) {
    return false;
  }

  @Override
  public SetADT<K> keySet() {
    return null;
  }

  @Override
  public K delete(Object o, Object o2) {
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
    return 0;
  }

  public class Entry {
    K key;
    V value;
    Entry next;

    public Entry(K k, V v) {
      key = k;
      value = v;
      next = null;
    }

    public Entry(K k, V v, Entry next){
      key = k;
      value = v;
      this.next = next;
    }
  }


  @Override
  public Iterator<K> iterator() {
    return new HashMapIterator();
  }

  private class HashMapIterator implements Iterator<K> {
    Entry current = null;

    public HashMapIterator() {
      for (int i = 0; i < hashTable.length; i ++) {
        if (hashTable[i] != null) {
          current = hashTable[i];
          break;
        }
      }
    }

    private boolean isEmpty() {
      return current != null;
    }

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public K next() {
      assert hasNext();

      K key = current.key;

      if(current.next != null) {
        current = current.next;
      } else {
        int hashIndex = hash(key);

        current = null;

        for(int i = hashIndex + 1; i < hashTable.length; i ++ ) {
          if (hashTable[i] != null) {
           current = hashTable[i];
           break;
          }
        }
      }

      return key;
    }

  }
}
