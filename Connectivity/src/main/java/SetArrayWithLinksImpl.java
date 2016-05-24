import java.util.Scanner;

public class SetArrayWithLinksImpl implements Sets {

    int[] id;

    public SetArrayWithLinksImpl(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        id = new int[n];
        initId(id);
        int p;
        int q;
        int border = 0;
        while (border != -1){
            p = scanner.nextInt();
            q = scanner.nextInt();
            int t = findSet(p);
            int j = findSet(q);
            if (t != j) {
                System.out.println(p +" "+ q);
                unionBySetsNames(q, p);
            }
            border = scanner.nextInt();
        }

    }

    private void initId(int[] id){
        for (int i = 0; i < id.length; i++) {
            id[i]=i;
        }
    }



    public int findSet(int p) {
        int t  = p;
        while (t!= id[t]){
            t = id[t];
        }
        return t;
    }

    public void unionBySetsNames(int setA, int setB) {
        id[setB]= setA;
    }

    public static void main(String[] args) {
        //SetArrayWithLinksImpl set = new SetArrayWithLinksImpl();

        SetsArrayImpl setsArray = new SetsArrayImpl();
        setsArray.readAndShow();
    }
}
