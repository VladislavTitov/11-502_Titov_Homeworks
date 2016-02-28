import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArrayList<E> {

    private final int MAX_AGE = 150;
    private Object[] array;
    private int count;

    public ArrayList() {
        this.array = new Object[MAX_AGE];
    }

    public void add(){
        
    }

    class HumanReaderWriter<T> {

        public void readHuman(){

            try {

                Scanner scanner = new Scanner(new File("C:\\repo\\LexicSort\\src\\main\\resources\\Humans.txt"));



            }catch (FileNotFoundException e){
                System.out.println(e.getMessage() + "scanner");
            }

        }

    }

}
