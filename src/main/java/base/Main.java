package base;

public class Main {

  public static void main(String[] args) {
//    ArrayQueue<Integer> queue = new ArrayQueue<>();
    LinkedListQueue<Integer> queue = new LinkedListQueue<>();

    queue.enqueue(1);
//    queue.enqueue(2);
//    queue.enqueue(3);
//    queue.enqueue(4);
//    queue.enqueue(5);
//    queue.enqueue(6);
//    queue.enqueue(7);
//    queue.enqueue(8);
//    queue.enqueue(9);
//    queue.enqueue(10);

//    System.out.println("--------------");
//    System.out.println(queue.peek());
//    System.out.println("--------------");
    queue.dequeue();
//
//    for(int i = 0; i < 12; i ++) {
//      System.out.println("--------------");
//      System.out.println(queue.peek());
//      System.out.println("--------------");
//      queue.dequeue();
//    }



    Iterator<Integer> iterator = queue.iterator();

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

  }
}
