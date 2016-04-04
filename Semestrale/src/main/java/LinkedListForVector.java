public class LinkedListForVector {
    private Node first;
    private Node last;
    private int count;

    LinkedListForVector(){
        this.first = null;
        this.last = null;
        this.count = 0;
    }

    public void addFirst(int number, int element){
        Node f = first;
        Node newNode = new Node(number, element, f);
        first = newNode;
        if (f == null){
            last = newNode;
        }
        count++;
    }

    public void addLast(int number, int element){
        Node l = last;
        Node newNode = new Node(number, element, null);
        last = newNode;
        if (l == null){
            first = newNode;
        }else{
            l.setNext(newNode);
        }
        count++;
    }

    public void show(){
        Node f = first;
        int i = 0;
        while (i < count) {
            System.out.println("(" + f.getNumber() + ", " + f.getValue() + ")");
            f = f.getNext();
            i++;
        }
    }

    public void remove(int pos){
        Node f = first;
        int i = 0;
        if (pos == first.getNumber()){
            first = first.getNext();
            return;
        }else while (i < count -1){
            if (pos == f.getNext().getNumber()){
                f.setNext(f.getNext().getNext());
                count--;
                return;
            }
            f = f.getNext();
            i++;
        }


    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public int getCount() {
        return count;
    }
}
