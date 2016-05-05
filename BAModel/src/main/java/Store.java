import java.util.Random;

public class Store {
    private int[][] graph;
    private int[] degrees;
    private int degreeSum;
    private int count;
    private final int MAX_COUNT = 25;

    public Store() {
        this.graph = new int[MAX_COUNT][MAX_COUNT];
        this.degrees = new int[MAX_COUNT];
        this.count = 2;
        graph[0][1] = 1;
        graph[1][0] = 1;
        this.degrees[0] = 1;
        this.degrees[1] = 1;
        this.degreeSum = 2;
    }

    public void add(){
        Random random = new Random();
        for (int i = 2; i < MAX_COUNT; i++) {
            for (int j = 0; j < count; j++) {
                double p = (double)degrees[j]*100 / (double)degreeSum;
                int r = random.nextInt(100);
                if (r<=p){
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                    degrees[i] += 1;
                    degrees[j] += 1;
                    degreeSum += 2;
                }
            }
            count++;
        }
    }

    public void show(){
        for (int i = 0; i < MAX_COUNT; i++) {
            for (int j = 0; j < MAX_COUNT; j++) {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }
}
