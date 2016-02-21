package ru.itis.inform;

public class LinkedList<T> implements List<T> {
    private Node<T> first;

    private int count;

    public LinkedList() {
        this.first = null;
        this.count = 0;
    }




    class LinkedListIteratorImpl<T> implements Iterator<T> {

        Node<T> current;

        public LinkedListIteratorImpl(Node<T> first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }
        public boolean hasPrevious() {
            return current.getPrevious() != null;
        }

        @Override
        public void next() {
            if (hasNext()){
                current = current.getNext();
            }else throw new IllegalArgumentException();
        }

        @Override
        public void previous() {
            if (hasPrevious()){
                current = current.getPrevious();
            }else throw new IllegalArgumentException();
        }

        @Override
        public T peekNext() {
            if (hasNext()){
                return current.getValue();
            }else throw new IllegalArgumentException();  //Написать ошибку!
        }

        @Override
        public T peekPrevious() {
            if (hasPrevious()){
                return current.getPrevious().getValue();
            }else throw new IllegalArgumentException();   //Написать ошибку!
        }


        @Override
        public void insert(T element) {
            Node<T> insNode = new Node<>(element);

            insNode.setPrevious(current.getPrevious());
            current.getPrevious().setNext(insNode);

            insNode.setNext(current);
            current.setPrevious(insNode);

            count++;
        }

        public void back(){
            while (hasPrevious()){
                previous();
            }
        }
    }




    // Когда добавляете, учтите, что еще есть previous
    public void add(T element) {
        Node<T> newNode = new Node(element);
        newNode.setPrevious(null);
        if (first == null) {
            this.first = newNode;
        } else {
            newNode.setNext(this.first);
            this.first.setPrevious(newNode);
            this.first = newNode;
        }
        count++;
    }

    /*@Override
    public void remove(T element) {
        Node node = this.first;
        for(int i = 0; i < count - 2; i++) {
            if(i == 0 && node.getValue() == element) {
                first = node.getNext();
                return;
            }

            if(node.getNext().getValue() == element) {
                if(i == 0) {
                    first = node;
                    return;
                } else if (i == count - 1) {
                    node.setNext(null);
                    return;
                } else {
                    node.setNext(node.getNext().getNext());
                    return;
                }
            }

            node = node.getNext();
        }
        count--;
    }*/

    public LinkedListIteratorImpl<T> iterator = new LinkedListIteratorImpl<>(first);


}
