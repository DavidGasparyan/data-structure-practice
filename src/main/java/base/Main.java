package base;

public class Main {

  public static void main(String[] args) {
//    ArrayQueue<Integer> queue = new ArrayQueue<>();
    LinkedList<Integer> list = new LinkedList<>();

    list.addFirst(1);
    list.addFirst(2);
    list.addFirst(3);
    list.addFirst(4);
    list.addFirst(5);
    list.addFirst(6);

    list.print();

    list.remove(0);

    list.print();


//    Iterator<Integer> iterator = queue.iterator();
//
//    while (iterator.hasNext()) {
//      System.out.println(iterator.next());
//    }

  }
}
