package ru.itis.inform;

public class Main{
    public static void main(String[]args){
        Graph g = new GraphMatrixImpl();

        int n = 0;
        g.addPoint();
        n++;
        g.addPoint();
        n++;
        g.addPoint();
        n++;

        g.addEdge(0, 1, 3);
        g.addEdge(1, 2, 2);
        g.addEdge(0, 2, 300);




        g.runFloyd(n);

        g.showGraph();
        g.showGraph1();
    }
}
