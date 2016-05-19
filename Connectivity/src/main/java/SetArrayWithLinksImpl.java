import java.util.Scanner;

public class SetArrayWithLinksImpl implements Sets {

    public void enterLinks(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] id = new int[n];
        initId(id);
        int p;
        int q;
        int border = 0;
        while (border != -1){
            p = scanner.nextInt();
            q = scanner.nextInt();
            int t = findSet(p, id);
            int j = findSet(q, id);
            if (t != j) {
                System.out.println(p +" "+ q);
                unionBySetsNames(q, p, id);
            }
            border = scanner.nextInt();
        }

    }

    private void initId(int[] id){
        for (int i = 0; i < id.length; i++) {
            id[i]=i;
        }
    }



    public int findSet(int p, int[] id) {
        int t  = p;
        while (t!= id[t]){
            t = id[t];
        }
        return t;
    }

    public void unionBySetsNames(int setA, int setB, int[] id) {
        id[setB]= setA;
    }

    public static void main(String[] args) {
        SetArrayWithLinksImpl set = new SetArrayWithLinksImpl();
        set.enterLinks();
    }
}
