import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        QuickHull qh = new QuickHull();
        qh.runStage1();
        qh.printHull();

    }
}
