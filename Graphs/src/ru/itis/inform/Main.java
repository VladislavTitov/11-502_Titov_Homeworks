package ru.itis.inform

public class Main{
    public static void main(String[]args){
        IGraphs g = new Graph();

        g.addPoint();
        g.addPoint();
        g.addPoint();
        g.addPoint();
        g.addPoint();

        g.addEdge(0, 2, 3);
        g.addEdge(0, 3, 2);
        g.addEdge(3, 4, 5);
        g.addEdge(2, 1, 1);
        g.addEdge(2, 4, 2);

        g.showGraph();
    }
}
