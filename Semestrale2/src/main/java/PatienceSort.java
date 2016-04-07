import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;

public class PatienceSort {
    private int[] storeNumbers;
    private LinkedList<LinkedList<Integer>> piles = new LinkedList<LinkedList<Integer>>();
    private int iteration = 0;

    public PatienceSort(String filename) throws FileNotFoundException{
        this.storeNumbers = Reader.readNumbers(filename);
    }

    public void formPiles(){
        for (int i = 0; i < storeNumbers.length; i++){
            int k = binarySearch(piles, storeNumbers[i]);
            if (k == piles.size()){
                LinkedList<Integer> newPile = new LinkedList<Integer>();
                newPile.addFirst(storeNumbers[i]);
                piles.addLast(newPile);
            }else{
                piles.get(k).addFirst(storeNumbers[i]);
            }
            iteration++;
        }
    }

    public void sortWithTree(){
        BinarySearchTreeImpl sortTree = new BinarySearchTreeImpl();
        for (int i = 0; i < piles.size(); i++) {
            for (int j = 0; j < piles.get(i).size(); j++) {
                sortTree.insert(piles.get(i).get(j));
                iteration++;
            }
        }

        /*Iterator<LinkedList<Integer>> iterator = piles.iterator();
        while(iterator.hasNext()){
            Iterator<Integer> pilesIterator = iterator.next().iterator();
            while (pilesIterator.hasNext()){
                sortTree.insert(pilesIterator.next());
            }
        }*/

        iteration += sortTree.inOrderPrint();
        System.out.print(iteration + " ");
    }

    private int binarySearch(LinkedList<LinkedList<Integer>> piles, int key){
        int l, r, m;
        l = -1;
        r = piles.size();
        while (l < r-1){
            m = (l + r)/2;
            if (piles.get(m).getFirst() < key){
                l = m;
            }else
                r = m;
            iteration++;
        }
        return r;
    }

    public LinkedList<LinkedList<Integer>> getPiles() {
        return piles;
    }
}
