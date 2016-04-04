public class Node {
    private int number;
    private int value;
    private Node next;

    public Node(int number, int value, Node next) {
        this.number = number;
        this.value = value;
        this.next = next;
    }

    public int getNumber() {
        return number;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
