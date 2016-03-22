import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ConvexHull conHull = new ConvexHull();
        conHull.readPoints();
        conHull.runJarvis();
        conHull.writePoints();
    }
}
