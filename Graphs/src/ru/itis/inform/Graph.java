
class Graph implements IGraphs{

    private final int MAX_POINT = 100;
    private int[][] graf;
    private int points;
    private int maxSize;

    Graph(){
        initGraph(MAX_POINT);
    }
    Graph(int maxSize){
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


}
