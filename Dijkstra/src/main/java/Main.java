public class Main {

    public static void main(String[] args) {
        final int INF = Integer.MAX_VALUE / 2;
        int[][] graph = new int[][]{
                {0, 3, 10, 2},
                {INF, 0, 2, INF},
                {INF, INF, 0, INF},
                {INF, INF, 4, 0}
        };
        Dijkstra alg = new Dijkstra(graph);
        alg.dijkstra(0);
    }
}
