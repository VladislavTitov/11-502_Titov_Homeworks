package ru.itis.inform;

public interface DirectedGraph {

    void addPoint();
    void addDirectedEdge(int a, int b, int weight);
    void showGraph();
    void runFloyd(int n);

    void showdMatrix();

}
