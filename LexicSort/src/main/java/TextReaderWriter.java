import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextReaderWriter {

    public TextReaderWriter() {
    }



    TextSorter sorter = new TextSorter();

    DoublyLinkedList<String> listOfString = new DoublyLinkedList<String>();
    int k =0;

    public void readWord() throws IOException{

        Scanner scanner = new Scanner(new File("C:\\repo\\LexicSort\\src\\main\\resources\\Humans.txt"));
        String word;

        while(scanner.hasNext()){

            word = scanner.next();
            listOfString.addLast(word);
            int l = word.length();
            if (l > k){
                k = l;
            }

        }

    }

    class TextSorter{


        public void sortWords(){

            for (int m = k; m > 0; m--){
                ArrayList<DoublyLinkedList> arrayList = new ArrayList<DoublyLinkedList>(26);
                listOfString.iterator.back();
                while (listOfString.iterator.hasNext()){
                    if(listOfString.current.getValue() != null) {
                        int s = (int) listOfString.iterator.getNext().charAt(m - 1) - 97;
                        if (arrayList.get(s) == null) {
                            DoublyLinkedList<String> words = new DoublyLinkedList<String>();
                            words.addFirst(listOfString.iterator.getNext());
                            arrayList.add(words, s);
                        } else {
                            arrayList.get(s).addLast(listOfString.iterator.getNext());
                        }
                    }

                    listOfString.iterator.next();
                }

                listOfString.clear();
                listOfString.addLast(null);

                for (int i = 26; i > 0; i--){
                    if (arrayList.get(i - 1) != null) {
                        listOfString.append(arrayList.get(i - 1));
                    }else continue;
                }

            }
        }

    }

    public void writeWord() throws IOException{
        FileWriter writer = new FileWriter("C:\\repo\\LexicSort\\src\\main\\resources\\SortedHumans.txt");
        listOfString.iterator.back();
        while (listOfString.iterator.hasNext()){
            if (listOfString.current.getValue() != null) {
                writer.write(listOfString.iterator.getNext() + " ");
                writer.write("\n");
            }
            listOfString.iterator.next();
        }
        writer.flush();
    }
}
