import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class HumansReaderWriter {

    ArrayList<DoublyLinkedList> arrayList = new ArrayList<DoublyLinkedList>();

    public void readHuman(String path){

        try{

            Scanner scanner = new Scanner(new File(path));

            while (scanner.hasNextLine()){

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

    public synchronized DoublyLinkedList<Human> returnHumanList(){
        DoublyLinkedList<Human> list = new DoublyLinkedList<>();
        for (int i = 0; i < arrayList.MAX_SIZE; i++) {
            if (arrayList.get(i) != null){
                while (arrayList.get(i).iterator.hasNext()){
                    list.addLast((Human) arrayList.get(i).iterator.getNext());
                    arrayList.get(i).iterator.next();
                }
            }
        }
        return list;
    }

    public void writeHuman(String path){

        try(FileWriter writer = new FileWriter(path)) {

            for (int i = 0; i < arrayList.MAX_SIZE; i++){

                if (arrayList.get(i) != null){
                    while (arrayList.get(i).iterator.hasNext()){
                        Iterator<Human> iterator = arrayList.get(i).iterator;
                        String name = iterator.getNext().getName();
                        int age = iterator.getNext().getAge();

                        System.out.print(name + " ");
                        System.out.println(age);

                        writer.write(name + " ");
                        writer.write(age + " ");
                        writer.write("\n");

                        iterator.next();
                    }
                }else continue;

            }
            writer.flush();

        }catch (IOException ex){
            System.out.println(ex.getMessage() + "writer");
        }

    }

}