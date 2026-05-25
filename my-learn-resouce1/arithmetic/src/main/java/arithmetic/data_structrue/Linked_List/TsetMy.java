package arithmetic.data_structrue.Linked_List;

public class TsetMy {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.printAll();
        myLinkedList.addIndex(1,100);
        myLinkedList.printAll();
        Integer index = myLinkedList.getIndex(4);
        System.out.println(index);
        myLinkedList.delete(4);
        myLinkedList.printAll();
        myLinkedList.updataDate(1,999);
        myLinkedList.printAll();
        myLinkedList.clear();
        myLinkedList.printAll();
    }
}
