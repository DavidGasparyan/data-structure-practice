package base;

public class Main {

  public static void main(String[] args) {
    ArrayDeque<Integer> deque = new ArrayDeque<>();

    deque.addFirst(1);
    deque.addFirst(2);
    deque.addFirst(3);
    deque.addFirst(4);
    deque.addFirst(12);
    deque.addFirst(5);
    deque.addFirst(6);
    deque.addFirst(7);
    deque.addFirst(8);
    deque.addFirst(9);
    deque.addFirst(10);
    deque.addFirst(11);
    deque.addLast(11);
    deque.addLast(11);

//    deque.removeFirst();
//    deque.removeFirst();
//    deque.removeFirst();
//    deque.removeFirst();

//    deque.removeLast();
//    deque.removeLast();
//    deque.removeLast();
//    deque.removeLast();

    deque.print();
    System.out.println("----- Size ------");
    /**
     *  rear = element(6)
     *  front = element(3)
     */

//    System.out.println(deque.size());

    Iterator<Integer> iterator = deque.iterator();

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
