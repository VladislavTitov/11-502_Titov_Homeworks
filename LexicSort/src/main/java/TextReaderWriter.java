import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextReaderWriter {

    public TextReaderWriter() {
    }


    DoublyLinkedList<String> listOfString = new DoublyLinkedList<String>();
    int k;

    public void readWord(){

        Scanner scanner = new Scanner("C:\\repo\\LexicSort\\src\\main\\resources\\Humans.txt");
        String word;

        if (scanner.hasNextInt()){
            k = scanner.nextInt();
        }

        while(scanner.hasNext()){

            word = scanner.next();
            listOfString.addLast(word);

        }

    }

    class TextSort{

        public void sortWords(){
            for (int m = k; k > 0; k--){
                ArrayList<DoublyLinkedList> arrayList = new ArrayList<DoublyLinkedList>(26);

                while (listOfString.iterator.hasNext()){
                    int s = (int) listOfString.iterator.getNext().charAt(m) - 97;
                    if (arrayList.get(s) == null){
                        DoublyLinkedList<String> words = new DoublyLinkedList<String>();
                        words.addFirst(listOfString.iterator.getNext());
                        arrayList.add(words, s);
                    }else{

                    }
                }
            }
        }

    }

    public void writeWord() throws IOException{
        FileWriter writer = new FileWriter("C:\\repo\\LexicSort\\src\\main\\resources\\SortedHumans.txt");
        while (listOfString.iterator.hasNext()){
            writer.write(listOfString.iterator.getNext() + " ");
            writer.write("\n");
            listOfString.iterator.next();
        }
        writer.flush();
    }
}
