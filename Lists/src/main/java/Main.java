public class Main {
    public static void main(String[] args) {

        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();

        a.addLast(7);
        a.addLast(1);
        a.addLast(8);
        a.addLast(9);
        a.addLast(6);
        a.addLast(3);
        a.addLast(10);


        DoublyLinkedList<Integer> c = DoublyLinkedList.mergeSort(a);

        c.showList();

    }
}
