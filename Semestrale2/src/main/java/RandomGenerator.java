import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;


public class RandomGenerator {
    private Random a = new Random();
    private int n = a.nextInt(7900)+100;
    private ArrayList<Integer> randomArray;
    private int countOfArrays = a.nextInt(10)+20;
    private Writer w = new Writer();
    private int [] sizes = new int [countOfArrays];
    public RandomGenerator() throws FileNotFoundException{
        for (int z = 0; z < countOfArrays; z++) {

            randomArray = new ArrayList<Integer>(n);
            String fileName = "s"+z ;

            for (int i = 0; i < n; i++) {
                int number = a.nextInt(10000);
                randomArray.add(i,number);
            }
            sizes[z] = n;
            w.write(randomArray, fileName);
            n+=70;
        }
    }

    public int[] getSizes(){
        return sizes;
    }
    public void show(){
        for (int i=0; i< randomArray.size();i++){
            System.out.println(randomArray.get(i));
        }
    }
    public int size(){
        return randomArray.size();
    }
    public Integer get(int i){
        return randomArray.get(i);
    }
    public void set(int index, Integer a){
        randomArray.set(index, a);
    }

    public int getCountOfArrays() {
        return countOfArrays;
    }
}
