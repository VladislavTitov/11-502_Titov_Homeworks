package ru.itis.inform;

public class Main {

    public static void main(String[] args) {
	    LinkedList list = new LinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        //list.remove(4);
        list.remove(1);
        //list.remove(2);

        list.showList();

    }
}
