package ru.itis.inform;

public class Main{
    public static void main(String[]args){
        GraphMatrixImpl g = new GraphMatrixImpl();

        int n = 0;
        g.addPoint();
        n++;
        g.addPoint();
        n++;
        g.addPoint();
        n++;

        g.addDirectedEdge(0, 1, 3);
        g.addDirectedEdge(1, 2, 2);
        g.addDirectedEdge(0, 2, 300);





        g.runFloyd(n);

        g.showGraph();
        g.showdMatrix();
    }
}
