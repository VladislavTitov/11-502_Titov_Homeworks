import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RWThread implements Runnable{
    String threadname;
    String filename;
    Thread thread;
    HumansReaderWriter humansRW;
    DoublyLinkedList<Human> list;

    public RWThread(String threadname, String filename) {
        this.threadname = threadname;
        this.filename = "C:\\repo\\MultiThreadSorting\\src\\main\\resources\\" + filename +".txt";
        humansRW = new HumansReaderWriter();
        this.thread = new Thread(this, threadname);
        thread.start();
    }

    public void run(){
        humansRW.readHuman(filename);
        list = humansRW.returnHumanList();

    }

    public DoublyLinkedList<Human> getList(){
        return list;
    }
}
