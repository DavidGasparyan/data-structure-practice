package base;

public interface MapADT<K, V> extends Collection<K> {
  public V put(K k, V v);

  public boolean containsKey(K k);

  public boolean containsValue(V v);

  public K delete(K k, V v);

  public SetADT<K> keySet();
}
