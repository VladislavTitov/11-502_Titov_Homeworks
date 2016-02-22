package ru.itis.inform;

public class GraphMatrixImpl implements Graph, DirectedGraph {

    private final int MAX_POINT = 15;
    private int[][] graf;
    public int points;   // public нужен, чтобы в тесте установить любое значение, так это поле должно быть private!
    private int maxSize;
    private int[][] dMatrix;

    public GraphMatrixImpl(){
        initGraph(MAX_POINT);
    }
    public GraphMatrixImpl(int maxSize){
        initGraph(maxSize);
    }

    private void initGraph(int maxSize){
        this.maxSize = maxSize;
        this.points = 0;
        this.graf = new int[maxSize][maxSize];
        this.dMatrix = new int[maxSize][maxSize];
    }

    public void addPoint(){
        if(points<maxSize) {
            points++;
        }else throw new IllegalArgumentException();
    }

    public void addDirectedEdge(int i, int j, int weight){
        if(i < points && j < points) {
            graf[i][j] = weight;
            dMatrix[i][j] = weight;
        }else throw new IllegalArgumentException();
    }

    public void addEdge(int i, int j, int weight){
        if(i < points && j < points) {
            graf[i][j] = weight;
            graf[j][i] = weight;
            dMatrix[i][j] = weight;
            dMatrix[j][i] = weight;
        }else throw new IllegalArgumentException();
    }

    @Override
    public void runFloyd(int n) {
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++){
                    if (dMatrix[i][j] < (dMatrix[i][k] + dMatrix[k][j])){
                        dMatrix[i][j] = dMatrix[i][j];
                    }else{
                        dMatrix[i][j] = dMatrix[i][k] + dMatrix[k][j];
                    }
                }
            }
        }
    }

    public void showGraph() {
        for (int i = 0; i < points; i++) {
            for (int j = 0; j < points - 1; j++) {
                System.out.print(graf[i][j] + ",  ");
            }
            System.out.println(graf[i][points - 1]);
        }
    }

    public void showdMatrix() {
        for (int i = 0; i < points; i++) {
            for (int j = 0; j < points - 1; j++) {
                System.out.print(dMatrix[i][j] + ",  ");
            }
            System.out.println(dMatrix[i][points - 1]);
        }
    }

}
