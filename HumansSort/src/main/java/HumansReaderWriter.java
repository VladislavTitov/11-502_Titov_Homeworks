import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class HumansReaderWriter {

    ArrayList<DoublyLinkedList> arrayList = new ArrayList<>();

    public void readHuman(){

        try {

            Scanner scanner = new Scanner(new File("C:\\repo\\HumansSort\\src\\main\\resources\\Humans.txt"));

            if (scanner.hasNextLine()){

                String name = scanner.next();
                int age = scanner.nextInt();

                Human newHuman = new Human(name, age);

                if (arrayList.get(newHuman.getAge()) == null){
                    DoublyLinkedList<Human> humanList = new DoublyLinkedList<>();
                    humanList.addFirst(newHuman);
                    arrayList.add(humanList, newHuman.getAge());
                }else{
                    arrayList.get(newHuman.getAge()).addLast(newHuman);
                }

            }

        }catch (FileNotFoundException e){
            System.out.println(e.getMessage() + "scanner");
        }

    }

    public void writeHuman(){

        try(FileWriter writer = new FileWriter("C:\\repo\\HumansSort\\src\\main\\resources\\SortedHumans.txt")) {

            for (int i = 0; i < arrayList.MAX_AGE; i++){

                if (arrayList.get(i) != null){
                    while (arrayList.get(i).iterator.hasNext()){
                        String name = arrayList.get(i).iterator.getNext().getName();
                        int age = arrayList.get(i).iterator.getNext().getAge();

                        writer.write(name);
                        writer.write(age);

                    }
                }else throw new IllegalArgumentException();

            }
            writer.flush();

        }catch (IOException ex){
            System.out.println(ex.getMessage() + "writer");
        }

    }

}