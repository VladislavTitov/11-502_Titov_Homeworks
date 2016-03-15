public class DoublyLinkedList<T extends Comparable> implements List<T>{

    Node<T> first;
    Node<T> last;
    int count = 0;
    Node<T> current;
    Iterator<T> iterator = new DoublyLinkedListIteratorImpl();

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

        this.current = this.first;
        count++;
    }

    @Override
    public void remove() {

    }

    @Override
    public void clear() {
        this.first = this.last = null;
        this.current = first;
        this.count = 0;
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
    public void append(DoublyLinkedList<T> list) {
        list.last.next = this.first;
        this.first.previous = list.last;
        this.first = list.first;
        this.current = this.first;
        list.count += this.count;
    }

    public static <T extends Comparable> DoublyLinkedList merge(DoublyLinkedList<T> a, DoublyLinkedList<T> b){
        DoublyLinkedList<T> mergeList = new DoublyLinkedList();
        T aValue = (T) a.iterator.getNext();
        T bValue = (T) b.iterator.getNext();

        while (a.iterator.hasNext() && b.iterator.hasNext()) {
            switch (aValue.compareTo(bValue)) {
                case -1: {
                    mergeList.addLast(aValue);
                    a.iterator.next();
                    if(a.iterator.hasNext()) {
                        aValue = (T) a.iterator.getNext();
                    }else{
                        aValue = null;
                    }

                }
                break;
                case 0: {
                    mergeList.addLast(aValue);
                    mergeList.addLast(bValue);

                    a.iterator.next();
                    b.iterator.next();


                    if(a.iterator.hasNext()) {
                        aValue = (T) a.iterator.getNext();
                    }else{
                        aValue = null;
                    }
                    if(b.iterator.hasNext()) {
                        bValue = (T) b.iterator.getNext();
                    }else{
                        bValue = null;
                    }

                }
                break;
                case 1: {
                    mergeList.addLast(bValue);
                    b.iterator.next();
                    if(b.iterator.hasNext()) {
                        bValue = (T) b.iterator.getNext();
                    }else{
                        bValue = null;
                    }

                }
                break;
            }
        }

        while (a.iterator.hasNext()){
            mergeList.addLast(a.iterator.getNext());
            a.iterator.next();
        }

        while (b.iterator.hasNext()){
            mergeList.addLast(b.iterator.getNext());
            b.iterator.next();
        }


        return mergeList;
    }

    public static <T extends Comparable> DoublyLinkedList mergeSort(DoublyLinkedList<T> sortList){
        DoublyLinkedList<T>[] stack = new DoublyLinkedList[32];
        for (int i = 0; i < 32; i++){
            stack[i] = new DoublyLinkedList<>();
        }
        int stackPos = 0;
        while (sortList.iterator.hasNext()){
            stack[stackPos].addLast(sortList.iterator.getNext());
            sortList.iterator.next();
            stackPos++;
            while (stackPos > 1 && stack[stackPos - 1].count == stack[stackPos - 2].count){
                stack[stackPos - 2] =  merge(stack[stackPos -1], stack[stackPos -2]);
                stack[stackPos - 1].clear();
                stackPos--;
            }
        }

        while (stackPos > 1){
            stack[stackPos - 2] =  merge(stack[stackPos -1], stack[stackPos -2]);
            stackPos--;
        }
        if (stackPos>0){
            return stack[0];
        }else return null;
    }

    @Override
    public void showList() {
        this.current = this.first;
        while (iterator.hasNext()){
            System.out.println(iterator.getNext());
            iterator.next();
        }
    }

    class Node<E> {
        private E value;
        Node<E> next;
        Node<E> previous;

        public Node(E value, Node<E> next, Node<E> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public E getValue(){
            return value;
        }
    }

    class   DoublyLinkedListIteratorImpl implements Iterator<T> {

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
            return current.value;
        }

        @Override
        public T getPrevious() {
            return current.previous.value;
        }

        public void back(){
            current = first;
        }

    }


}
