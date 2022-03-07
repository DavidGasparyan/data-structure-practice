public class Main {

  public static void main(String[] args) {
    LinkedList<Integer> linkedList = new LinkedList<>();

    int [] intList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    for (int item: intList) {
      linkedList.addLast(item);
    }

    linkedList.remove(9);
    linkedList.remove(5);
    linkedList.remove(2);
    linkedList.remove(4);
    linkedList.remove(0);

    linkedList.print();


//    1
//    2
//    4
//    5
//    8
//    9
  }
}
