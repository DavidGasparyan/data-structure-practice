package base;

public class Main {

  public static void main(String[] args) {
    ArrayQueue<Integer> queue = new ArrayQueue<>();
//    LinkedList<Integer> list = new LinkedList<>();

    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);
    queue.add(5);
    queue.add(6);
    queue.add(7);
    queue.add(8);
    queue.add(9);
    queue.add(10);
    queue.add(11);
    queue.add(12);
    queue.add(13);

    queue.print();


//    Iterator<Integer> iterator = queue.iterator();
//
//    while (iterator.hasNext()) {
//      System.out.println(iterator.next());
//    }

  }
}
