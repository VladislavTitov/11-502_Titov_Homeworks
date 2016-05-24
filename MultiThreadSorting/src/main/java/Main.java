import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        RWThread thread1 = new RWThread("Thr1", "1");
        RWThread thread2 = new RWThread("Thr2", "2");
        RWThread thread3 = new RWThread("Thr3", "3");
        RWThread thread4 = new RWThread("Thr4", "4");

        thread1.thread.join();
        thread2.thread.join();
        thread3.thread.join();
        thread4.thread.join();

        DoublyLinkedList<Human> listHumans = DoublyLinkedList.merge(DoublyLinkedList.merge(thread1.getList(), thread2.getList()), DoublyLinkedList.merge(thread3.getList(), thread4.getList()));

        Iterator<Human> iterator = listHumans.iterator;
        while (iterator.hasNext()){
            System.out.println(iterator.getNext().getName()+ " " + iterator.getNext().getAge());
            iterator.next();
        }



    }
}
