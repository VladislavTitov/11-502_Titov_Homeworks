import java.util.Iterator;
import java.util.LinkedList;

public class HashTable {
    private LinkedList<Integer>[] table;
    private int prime = 11;

    public HashTable(int[] array) {
        table = new LinkedList[array.length];
        initTable();
        calcHashCode(array);
    }

    private void initTable(){
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<Integer>();
        }
    }

    private void calcHashCode(int[] array){

        /*int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min){
                min = array[i];
            }
        }
        int prime = findPrimeNumber(min);*/

        for (int i = 0; i < array.length; i++) {
            table[getKey(array[i], prime)].add(array[i]);
        }


    }

    private int getKey(int data, int primeNum){
        return data % primeNum;
    }

    public void find(int data){
        int key = getKey(data, prime);
        if (table[key].size() == 0){
            System.out.println("Don't have this element!");
            return;
        }else if (table[key].size() == 1){
            System.out.println(table[key].peek());
            return;
        }else{
            Iterator<Integer> iterator= table[key].iterator();
            while (iterator.hasNext()){
                int value = iterator.next().intValue();
                if (value == data){
                    System.out.println(value);
                    return;
                }
            }
        }
    }

    public void delete(int data){
        int key = getKey(data, prime);
        if (table[key].size() == 0){
            System.out.println("Don't have this element!");
            return;
        }else if (table[key].size() == 1){
            System.out.println(table[key].poll());
            return;
        }else{
            Iterator<Integer> iterator= table[key].iterator();
            int i = 0;
            System.out.println("Beginning iteration");
            while (iterator.hasNext()){
                Integer item = iterator.next();
                int value = item.intValue();
                if (value == data){
                    System.out.println(value);
                    iterator.remove();
                }
                i++;
            }
            System.out.println("Finishing iteration\n");
        }
    }





   /* private int findPrimeNumber(int data){
        for(int i=0; ; ++i){
            if(isPrime(data-i)){
                return data-i;
            }
        }
    }

    private boolean isPrime(int number){
        for(int i = 2; i*i <= number; i++){
            if(number % i == 0) {
                return false;
            }
        }
        return number>=2;
    }*/

}
