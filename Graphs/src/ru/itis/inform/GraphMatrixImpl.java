package ru.itis.inform;

class GraphMatrixImpl implements Graphs {

    private final int MAX_POINT = 15;
    private int[][] graf;
    private int points;
    private int maxSize;

    GraphMatrixImpl(){
        initGraph(MAX_POINT);
    }
    GraphMatrixImpl(int maxSize){
        initGraph(maxSize);
    }

    private void initGraph(int maxSize){
        this.maxSize = maxSize;
        this.points = 0;
        this.graf = new int[maxSize][maxSize];
    }

    public void addPoint(){
        if(points<maxSize) {
            points++;
        }else throw new IllegalArgumentException();
    }

    public void addEdge(int i, int j, int weight){
        if(i < points && j < points) {
            graf[i][j] = weight;
            graf[j][i] = weight;
        }else throw new IllegalArgumentException();
    }

    public void showGraph() {
        for (int i = 0; i < points; i++) {
            for (int j = 0; j < points - 1; j++) {
                System.out.print(graf[i][j] + ",  ");
            }
            System.out.println(graf[i][points - 1]);
        }
    }

    private int[][] dMatrix = new int[maxSize][maxSize];

    @Override
    public void runFloyd(int n) {
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; i++){
                for (int k = 0; k < n; k++){
                    dMatrix[i][j] = graf[i][j] < (graf[i][k] + graf[k][j]) ? graf[i][j] : graf[i][k] + graf[k][j];
                }
            }
        }
    }

    public void showGraph1() {
        for (int i = 0; i < points; i++) {
            for (int j = 0; j < points - 1; j++) {
                System.out.print(dMatrix[i][j] + ",  ");
            }
            System.out.println(dMatrix[i][points - 1]);
        }
    }

}
