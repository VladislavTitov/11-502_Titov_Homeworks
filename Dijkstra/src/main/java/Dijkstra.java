public class Dijkstra {
    private final int INF = Integer.MAX_VALUE/2;
    private int vNum;
    int[][] graph;
    public Dijkstra(int[][] graph) {
        this.graph = graph;
        this.vNum = graph.length;
    }

    void dijkstra(int start) {
        boolean[] used = new boolean [vNum];
        int[] dist = new int [vNum];
        fill(dist, INF);
        dist[start] = 0;
        for (; ; ) {
            int v = -1;
            for (int nv = 0; nv < vNum; nv++) {
                if (!used[nv] && dist[nv] < INF && (v == -1 || dist[v] > dist[nv]))
                    v = nv;
            }
            if (v == -1) break;
            used[v] = true;
            for (int nv = 0; nv < vNum; nv++) {
                if (!used[nv] && graph[v][nv] < INF) {
                    dist[nv] = min(dist[nv], dist[v] + graph[v][nv]);
                }
            }
        }

        for (int i =0; i < vNum; i++) {
            System.out.println(dist[i]);
        }
    }

    private void fill(int[] mas, int a){
        for (int i =0; i < mas.length; i++) {
            mas[i] = a;
        }
    }

    private int min(int a, int b){
        if (a<=b){
            return a;
        }else{
            return b;
        }
    }
}
