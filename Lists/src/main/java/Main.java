public class Main {
    public static void main(String[] args) {

        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();

        a.addLast(2);
        a.addLast(2);
        a.addLast(1);
        a.addLast(4);
        a.addLast(9);
        a.addLast(9);
        a.addLast(5);
        a.addLast(3);
        a.addLast(10);


        DoublyLinkedList<Integer> c = DoublyLinkedList.mergeSort(a);

        c.showList();

    }
}
