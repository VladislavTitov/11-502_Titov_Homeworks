public interface List<T extends Comparable> {

    void addFirst(T element);

    void addLast(T element);

    void remove();

    void clear();

    void insert(T element);

    void append(DoublyLinkedList<T> list);



    void showList();
}
