import java.util.Scanner;

public class SetsArrayImpl implements Sets{

    private int[] id;

    private final static int DEFAULT_SIZE = 50;

    public SetsArrayImpl(){
        id = new int [DEFAULT_SIZE];
        for (int i = 0; i < DEFAULT_SIZE; i++){
            id[i]=i;
        }

    }

    public void readAndShow(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0; i<n;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (findSet(a) != findSet(b)) {
                unionBySetsNames(findSet(a), findSet(b));
                System.out.println(a + " " + b);
            } else {
                for (int j = 0; j < DEFAULT_SIZE; j++) {
                    if (id[j] == findSet(a)) {
                        System.out.print(j+" ");
                    }
                }
                System.out.println(" ");
            }

        }
    }


    public int findSet(int element){
        return id[element];
    }

    public void unionBySetsNames(int A, int B) {
        for (int i = 0; i< id.length; i++){
            if (id[i]==B){
                id[i]=A;
            }
        }

    }
}
