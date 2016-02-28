public class DoublyLinkedList<T> implements List<T>{

    Node<T> first;
    Node<T> last;
    int count = 0;
    Node<T> current;
    DoublyLinkedListIteratorImpl<T> iterator = new DoublyLinkedListIteratorImpl<>();

    @Override
    public void addFirst(T element) {
        Node<T> f = first;
        Node<T> newNode = new Node<>(element, f, null);
        first = newNode;
        current = first;
        if (f == null){
            last = newNode;
        }else{
            f.previous = newNode;
        }
        count++;
    }

    @Override
    public void addLast(T element) {
        Node<T> l = last;
        Node<T> newNode = new Node<>(element, null, l);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        count++;
    }

    @Override
    public void remove() {

    }

    @Override
    public void insert(T element) {
        try {
            Node<T> newNode = new Node<>(element, current, current.previous);
            current.previous.next = newNode;
            current.previous = newNode;
            count++;
        }catch (NullPointerException e){
            System.out.println(e.getMessage() + " 2");
        }
    }

    @Override
    public void showList() {
        Node<T> node = first;
        for (int i = 0; i < count; i++){
            System.out.println(node.value);
            node = node.next;
        }
    }

    class Node<T>{
        T value;
        Node<T> next;
        Node<T> previous;

        public Node(T value, Node<T> next, Node<T> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

    class DoublyLinkedListIteratorImpl<T> implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public boolean hasPrevious() {
            return current.previous != null;
        }

        @Override
        public void next() {
            try {
                current = current.next;
            }catch (NullPointerException e){
                System.out.println(e.getMessage() + " 1");
            }
        }

        @Override
        public void previous() {
            current = current.previous;
        }

        @Override
        public T getNext() {
            return (T) current.value;
        }

        @Override
        public T getPrevious() {
            return (T) current.value;
        }
    }


}
