package base;

public class GenericTree<E> implements TreeADT<E> {

  private Node<E> root;

  public void setRoot(Node<E> n) {
    root = n;
  }

  public Node<E> getRoot() {
    return root;
  }


  protected static class Node<E> {
    E data;
    LinkedList<Node<E>> children;
    Node<E> parent;
    Node<E> left;
    Node<E> right;

    public Node(E d) {
      data = d;
      children = new LinkedList<>();
      parent = null;
      left = right = null;
    }

    public Node(E d, Node<E> p) {
      data = d;
      parent = p;
      children = new LinkedList<>();
      p.children.addLast(this);
    }
  }

  public void printPreOrder() {
    printPreOrder(root, "");
  }

  public void printPreOrder(Node<E> n, String prefix) {
    System.out.println(prefix + n.data);

    Iterator<Node<E>> iterator = n.children.iterator();

    while (iterator.hasNext()) {
      printPreOrder(iterator.next(), prefix + "\t");
    }
  }
}
