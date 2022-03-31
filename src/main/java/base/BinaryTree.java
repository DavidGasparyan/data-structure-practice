package base;

public class BinaryTree<E> implements TreeADT<E> {

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

    // Binary Tree Implementation
    public void addLeft(E data) {
      left = new Node<>(data);
      left.parent = this;
    }

    public void addRight(E data) {
      right = new Node<>(data);
      right.parent = this;
    }
  }

  public void printInOrder() {
    printInOrder(root);
  }

  public void printInOrder(Node<E> n) {
    if(n != null) {
      printInOrder(n.left);
      System.out.println(" " + n.data + " ");
      printInOrder(n.right);
    }
  }
}
