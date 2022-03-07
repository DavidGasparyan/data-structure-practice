package base;

public class Main {

  public static void main(String[] args) {
    LinkedList<Integer> linkedList = new LinkedList<>();

    int [] intList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    for (int item: intList) {
      linkedList.addLast(item);
    }

//    Iterator<Integer> linkedListIterator = linkedList.iterator();
//
//    while (linkedListIterator.hasNext()) {
//      System.out.println(linkedListIterator.next());
//    }

    linkedList.empty();
    linkedList.print();
  }
}
