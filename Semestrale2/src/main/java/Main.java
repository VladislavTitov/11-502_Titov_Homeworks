import com.sun.org.apache.regexp.internal.RE;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        RandomGenerator generator = new RandomGenerator();

        for (int i = 0; i < generator.getCountOfArrays(); i++) {

            System.out.print(generator.getSizes(i) + "    ");
            String filename = "s"+i;
            PatienceSort sorting = new PatienceSort(filename);

            long first = System.currentTimeMillis();

            sorting.formPiles();

            /*for (int i = 0; i < sorting.getPiles().size(); i++) {
                for (int j = 0; j < sorting.getPiles().get(i).size(); j++) {
                    System.out.print(sorting.getPiles().get(i).get(j) + " ");
                }
                System.out.println();
            }
            System.out.println();*/

            sorting.sortWithTree();

            long last = System.currentTimeMillis();

            System.out.println((last - first));
            //System.out.println();
        }
    }
}
