package ru.itis.inform;

public interface Graphs {

    void addPoint();
    void addEdge(int a, int b, int weight);
    void showGraph();
    void runFloyd(int n);

    void showGraph1();
}
