package base;

public class Main {

  public static void main(String[] args) {
//    ArrayQueue<Integer> queue = new ArrayQueue<>();
//    LinkedList<Integer> list = new LinkedList<>();
//      HashSet<Integer> hashSet = new HashSet<>();
    GenericTree<String> tree = new GenericTree<>();
    GenericTree.Node<String> n1 = new GenericTree.Node<>("Book");

    tree.setRoot(n1);

    GenericTree.Node<String> n2 = new GenericTree.Node<>("Title", n1);
    GenericTree.Node<String> n3 = new GenericTree.Node<>("Author", n1);
    GenericTree.Node<String> n4 = new GenericTree.Node<>("Publisher", n1);
    GenericTree.Node<String> n5 = new GenericTree.Node<>("Name", n3);
    GenericTree.Node<String> n6 = new GenericTree.Node<>("Surname", n3);

//    tree.printPreOrder(n3, "++++");


    BinaryTree<String> binaryTree = new BinaryTree<>();
    BinaryTree.Node<String> btRoot = new BinaryTree.Node<>("+");

    binaryTree.setRoot(btRoot);
    btRoot.addLeft("/");
    btRoot.addRight("2");
    binaryTree.printInOrder();
    btRoot.left.addLeft("12");
    btRoot.left.addLeft("4");





//    queue.add(1);
//    queue.add(2);
//    queue.add(3);
//    queue.add(4);
//    queue.add(5);
//    queue.add(6);
//    queue.add(7);
//    queue.add(8);
//    queue.add(9);
//    queue.add(10);
//    queue.add(11);
//    queue.add(12);
//    queue.add(13);

//    queue.addAt(15, 4);
//
//    System.out.println("-----");
//
//    queue.print();

//    System.out.println(queue.first());
//    System.out.println(queue.last());


//    Iterator<Integer> iterator = queue.iterator();
//
//    while (iterator.hasNext()) {
//      System.out.println(iterator.next());
//    }

  }
}
