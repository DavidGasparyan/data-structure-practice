public class LinkedList<E> implements List<E> {
  private Node<E> first;
  private Node<E> last;
  private int size = 0;

  private static class Node<E> {
    Node<E> next;
    E element;

    public Node(E element) {
      this.next = null;
      this.element = element;
    }

    public Node(E element, Node<E> next) {
      this.next = next;
      this.element = element;
    }

    @Override
    public String toString() {
      return "Node {" + "element=" + element + '}';
    }
  }

  public LinkedList () {}

  public void addFirst(E element) {
    final Node<E> tempFirst = first;
    final Node<E> newNode = new Node<E>(element, tempFirst);

    first = newNode;

    if (first == null) {
      last = newNode;
    }

    size ++;
  }

  public void addLast(E element) {
    final Node<E> tempLast = last;
    final Node<E> newNode = new Node<E>(element, null);

    last = newNode;

    if (first == null) {
      first = newNode;
    } else {
      tempLast.next = newNode;
    }

    size ++;
  }

  public E removeFirst() {
    // If the list is empty just return null;
    if (first == null) {
      return null;
    }

    final E element = first.element;
    final Node<E> next = first.next;

    first = next;

    if (next == null) {
      last = null;
    }

    size --;

    return element;
  }

  public E removeLast() {
    // If the list is empty just return null;
    if (first == null) {
      return null;
    }

    final E element = last.element;
    final Node<E> lastNode = last;

    Node<E> previousNode = null;
    Node<E> nextNode = first;

    while (nextNode != lastNode) {
      previousNode = nextNode;
      nextNode = nextNode.next;
    }

    last = previousNode;

    if (previousNode == null) {
      first = null;
    } else {
      previousNode.next = null;
    }

    size --;

    return element;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public E get(int index) {
    if (index > size || index < 0) {
      throw new IndexOutOfBoundsException();
    }

    Node<E> tempNode = first;

    while(index > 0) {
      tempNode = tempNode.next;
      index --;
    }

    return tempNode.element;
  }

  public void set(E element, int index) {
    if (index > size || index < 0) {
      throw new IndexOutOfBoundsException();
    }

    if (index == 0) {
      addFirst(element);
      return;
    }

    Node<E> previousNode = null;
    Node<E> nextNode = first;

    while(index > 0) {
      previousNode = nextNode;
      nextNode = nextNode.next;
      index --;
    }

    previousNode.next = new Node<>(element, nextNode);
  }

  public void print() {
    Node<E> firstNode = first;

    while (firstNode != null) {
      System.out.println(firstNode.element);
      firstNode = firstNode.next;
    }
  }

  public void insertBefore(E element, int index) {
    if (index > size || index < 0) {
      throw new IndexOutOfBoundsException();
    }

    if (index == 0) {
      addFirst(element);
      return;
    }

    Node<E> previousNode = first;
    Node<E> currentNode = first.next;

    while (index > 1) {
      previousNode = currentNode;
      currentNode = currentNode.next;
      index --;
    }

    previousNode.next = new Node<>(element, currentNode);
    size ++;
  }

  public void insertAfter(E element, int index) {
    if (index > size || index < 0) {
      throw new IndexOutOfBoundsException();
    }

    if (index == 0 && first == null) {
      addFirst(element);
    }

    Node<E> currentNode = first;
    Node<E> nextNode = first.next;

    while (index > 0) {
      currentNode = nextNode;
      nextNode = nextNode.next;
      index--;
    }

    currentNode.next = new Node<>(element, nextNode);
    size ++;
  }

  public void remove(int index) {
    if (index > size || index < 0) {
      throw new IndexOutOfBoundsException();
    }

    if (index == 0) {
      removeFirst();
      return;
    }

    Node<E> beforeNode = first;
    Node<E> currentNode = first.next;

    while (index > 1) {
      beforeNode = currentNode;
      currentNode = currentNode.next;
      index--;
    }

    beforeNode.next = currentNode.next;
    size --;
  }

  public void remove(E element) {

  }
}
