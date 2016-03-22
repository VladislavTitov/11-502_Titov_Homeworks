import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;

public class ConvexHull {
    private ArrayList<Point> arrPoints = new ArrayList<Point>();
    private int count = 0;
    private int minY;
    private int maxminX;
    LinkedList<Point> pointList = new LinkedList<Point>();

    public void readPoints() throws FileNotFoundException{
        Scanner scan = new Scanner(new File("C:\\repo\\ConvexHull\\src\\main\\resources\\Points.txt"));
        if (scan.hasNextLine()) {
            maxminX = scan.nextInt();
            minY = scan.nextInt();
            arrPoints.add(new Point(maxminX, minY));
            count++;
        }
        while (scan.hasNextLine()){
            int x = scan.nextInt();
            int y = scan.nextInt();
            if (x > maxminX){
                maxminX = x;
            }
            if (y < minY){
                minY = y;
            }
            arrPoints.add(new Point(x, y));
            count++;
        }
    }

    public void runJarvis(){

        Point p1 = null;
        for (int i = 0; i < count; i++){
            if (arrPoints.get(i).getY() == minY){
                if (arrPoints.get(i).getX() <= maxminX){
                    p1 = arrPoints.get(i);
                    arrPoints.set(i, arrPoints.get(0));
                    arrPoints.set(0, p1);

                    maxminX = arrPoints.get(i).getX();
                }
            }
        }
        pointList.addLast(p1);
        pointList.addLast(findP2(p1));
        alsoJarvis();

    }

    private void alsoJarvis(){
        int i =1;
        int v = -1;
        do {
            double maxcos = -2;
            Point vec1 = new Point(arrPoints.get(i).getX() - arrPoints.get(i - 1).getX(), arrPoints.get(i).getY() - arrPoints.get(i - 1).getY());
            if (i - 1 != 0) {
                arrPoints.get(i-1).setFlag();
            }
            for (int j = 0; j < count; j++) {
                double d;
                double dMax = 0;
                if (!arrPoints.get(j).isFlag()) {
                    Point vec2 = new Point(arrPoints.get(j).getX() - arrPoints.get(i).getX(), arrPoints.get(j).getY() - arrPoints.get(i).getY());
                    d = Math.sqrt(vec2.getX()*vec2.getX() + vec2.getY()*vec2.getY());
                    double cos = calcCos(vec1, vec2);
                    if (cos > maxcos) {
                        maxcos = cos;
                        v = j;
                        dMax = d;
                    }else if (cos == maxcos){
                        if (d > dMax){
                            v = j;
                            dMax = d;
                        }
                    }
                }
            }
            pointList.addLast(arrPoints.get(v));
            if ((v != i + 1) & (i + 1 < count) & pointList.getLast() != arrPoints.get(0)) {
                Point pV = arrPoints.get(v);
                arrPoints.set(v, arrPoints.get(i+1));
                arrPoints.set(i+1, pV);
            }
            i++;
        }while (pointList.getLast() != arrPoints.get(0));
    }

    private Point findP2(Point minny){
        int v = -1;
        double maxcos = -2;
        Point vector1 = new Point(1, 0);
        Point vector2;
        Point p2;
        for (int i = 0; i < count; i++){
            vector2 = new Point(arrPoints.get(i).getX() - minny.getX(), arrPoints.get(i).getY() - minny.getY());
            double cos = calcCos(vector1, vector2);
            if (cos > maxcos){
                maxcos = cos;
                v = i;
            }
        }
        p2 = arrPoints.get(v);
        arrPoints.set(v, arrPoints.get(1));
        arrPoints.set(1, p2);
        return arrPoints.get(1);
    }

    private double calcCos(Point vector1, Point vector2){
        double modV1 = Math.sqrt(vector1.getX()*vector1.getX() + vector1.getY()*vector1.getY());
        double modV2 = Math.sqrt(vector2.getX()*vector2.getX() + vector2.getY()*vector2.getY());
        double cos =  (vector1.getX()*vector2.getX() + vector1.getY()*vector2.getY())/(modV1*modV2);
        return cos;
    }

    public void writePoints(){
        for (int i = 0; i < pointList.size() - 1; i++){
            System.out.print("(" + pointList.get(i).getX() + ", ");
            System.out.println(pointList.get(i).getY() + ")");
        }
    }
}
