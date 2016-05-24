/**
 * Created by titov on 02.03.2016.
 */
public class Main {
    public static void main(String[] args) {
        HumansReaderWriter humans = new HumansReaderWriter();
        humans.readHuman("C:\\repo\\HumansSort\\src\\main\\resources\\Humans.txt");
        System.out.println(humans.returnHumanList());
        humans.writeHuman("C:\\repo\\HumansSort\\src\\main\\resources\\SortedHumans.txt");
    }
}
