import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class QuickHull {
    private ArrayList<Point> points = new ArrayList<Point>();
    int count = 0;
    private LinkedList<Point> hullPoints = new LinkedList<Point>();

    public void runStage1() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:\\repo\\QuickHull\\src\\main\\resources\\Points.txt"));
        int leftmostX;
        int rightmostX;
        Point leftmostPoint = null;
        Point rightmostPoint = null;
        if (scanner.hasNextLine()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points.add(new Point(x, y));
            count++;
            leftmostX = x;
            rightmostX = x;
        } else throw new IllegalArgumentException();
        while (scanner.hasNextLine()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points.add(new Point(x, y));
            count++;
            if (x < leftmostX) {
                leftmostX = x;
            } else if(x > rightmostX){
                rightmostX = x;
            }
        }
        for (int i = 0; i < count; i++) {
            if (points.get(i).getX() == leftmostX) {
                leftmostPoint = points.get(i);
            } else if (points.get(i).getX() == rightmostX) {
                rightmostPoint = points.get(i);
            }
        }
        if (leftmostPoint != null & rightmostPoint != null) {
            hullPoints.addLast(leftmostPoint);
            hullPoints.addLast(rightmostPoint);
            runNextStages(leftmostPoint, rightmostPoint);
        } else throw new IllegalArgumentException();
    }

    private void runNextStages(Point l, Point r) {
        findLowerSubset(l, r);
        findUpperSubset(l, r);
    }

    private void findUpperSubset(Point left, Point right) {
        left.setFlag();
        right.setFlag();
        Point vector = calcVector(left, right);
        int maxY = points.get(0).getY();
        Point maxPoint = null;
        boolean border = false;
        for (int i = 0; i < count; i++) {
            boolean line = (points.get(i).getX() - left.getX()) * vector.getY() - (points.get(i).getY() - left.getY()) * vector.getX() <= 0;
            /*if (left.getY() >= right.getY()){
                border = line;
            }else{
                border = !line;
            }*/
            if (line) {
                if (points.get(i).isFlag()) {
                    if (points.get(i).getY() > maxY) {
                        maxY = points.get(i).getY();
                        maxPoint = points.get(i);
                    }
                }
            }
        }
        if (maxPoint == null){
            return;
        }else if(maxPoint.getY() == left.getY() & maxPoint.getY() == right.getY()){
            maxPoint.setFlag();
            hullPoints.addLast(maxPoint);
            for (int i = 0; i < count; i++){
                if (points.get(i).getY() == maxPoint.getY()){
                    if (points.get(i).isFlag()) {
                        points.get(i).setFlag();
                        hullPoints.addLast(points.get(i));
                    }
                }
            }
            return;
        }else{
            maxPoint.setFlag();
            hullPoints.addLast(maxPoint);
            Point leftVector = calcVector(left, maxPoint);
            Point rightVector = calcVector(maxPoint, right);
            for (int i = 0; i < count; i++){
                boolean equLine1 = (points.get(i).getX() - left.getX())* vector.getY() - (points.get(i).getY() - left.getY()) * vector.getX() > 0;
                boolean equLine2 = (points.get(i).getX() - maxPoint.getX())*rightVector.getY() - (points.get(i).getY() - maxPoint.getY())*rightVector.getX()<0;
                if (border & equLine1 & equLine2){
                    points.get(i).setFlag();
                }
            }
            findUpperSubset(left, maxPoint);
            findUpperSubset(maxPoint, right);
        }


    }

    private void findLowerSubset(Point left, Point right) {
        left.setFlag();
        right.setFlag();
        Point vector = calcVector(left, right);
        int minY = points.get(0).getY();
        Point minPoint = null;
        boolean border = false;
        for (int i = 0; i < count; i++) {
            boolean line = (points.get(i).getX() - left.getX()) * vector.getY() - (points.get(i).getY() - left.getY()) * vector.getX() >= 0;
            if (line) {
                if (points.get(i).isFlag()) {
                    if (points.get(i).getY() < minY) {
                        minY = points.get(i).getY();
                        minPoint = points.get(i);
                    }
                }
            }
        }
        if (minPoint == null){
            return;
        }else if(minPoint.getY() == left.getY() & minPoint.getY() == right.getY()){
            minPoint.setFlag();
            hullPoints.addLast(minPoint);
            for (int i = 0; i < count; i++){
                if (points.get(i).getY() == minPoint.getY()){
                    if (points.get(i).isFlag()) {
                        points.get(i).setFlag();
                        hullPoints.addLast(points.get(i));
                    }
                }
            }
            return;
        }else{
            minPoint.setFlag();
            hullPoints.addLast(minPoint);
            Point leftVector = calcVector(left, minPoint);
            Point rightVector = calcVector(minPoint, right);
            for (int i = 0; i < count; i++){
                boolean equLine1 = (points.get(i).getX() - left.getX())* vector.getY() - (points.get(i).getY() - left.getY()) * vector.getX() < 0;
                boolean equLine2 = (points.get(i).getX() - minPoint.getX())*rightVector.getY() - (points.get(i).getY() - minPoint.getY())*rightVector.getX()<0;
                if (border & equLine1 & equLine2){
                    points.get(i).setFlag();
                }
            }
            findLowerSubset(left, minPoint);
            findLowerSubset(minPoint, right);
        }
    }

    private Point calcVector(Point l, Point r) {
        Point vector = new Point(r.getX() - l.getX(), r.getY() - l.getY());
        return vector;
    }

    public void printHull(){
        for (int i = 0; i < hullPoints.size(); i++){
            System.out.print(hullPoints.get(i).getX() + " ");
            System.out.println(hullPoints.get(i).getY());
        }
    }

}
