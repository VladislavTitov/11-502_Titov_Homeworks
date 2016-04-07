import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    public static int[] readNumbers(String filename) throws FileNotFoundException{
        File file = new File("C:\\repo\\Semestrale2\\src\\main\\resources\\"+filename+".txt");
        Scanner scan = new Scanner(file);
        ArrayList<Integer> array = new ArrayList<Integer>();
        int i = 0;
        while (scan.hasNext()){
            array.add(scan.nextInt());
            i++;
        }
        int[] returnArray = new int[array.size()];
        for(int j = 0; j < array.size(); j++){
            returnArray[j] = array.get(j);
        }

        return returnArray;
    }
}