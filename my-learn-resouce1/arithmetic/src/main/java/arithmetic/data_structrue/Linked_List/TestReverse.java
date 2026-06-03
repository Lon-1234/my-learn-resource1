package arithmetic.data_structrue.Linked_List;

public class TestReverse {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        for (Integer i :
                myLinkedList) {
            System.out.println(i);
        }
        System.out.println("___________");
        myLinkedList.reverse();
        for (Integer i :
                myLinkedList) {
            System.out.println(i);
        }
    }
}
