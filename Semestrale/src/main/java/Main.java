public class Main {
    public static void main(String[] args) {
        int [] vector = {1, 2, 0, 4, 5, 0, 1, 6, 7, 1};
        int [] vectorForTest = {0, 1, 2, 3, 1, 1, 2};
        VectorCode vectorCode = new VectorCode(vector);
        VectorCode vectorCodeTest = new VectorCode(vectorForTest);

        //vectorCode.insert(1, 9);

        //vectorCode.insert(10, 1);

        //vectorCode.delete(3);
        //vectorCode.delete(2);
        //vectorCode.delete(19);
        //System.out.println(vectorCode.scalarProduct(vectorCodeTest));


        vectorCode.sum(vectorCodeTest).printList();
        System.out.println();


        //int [] decVec = vectorCode.vectorSum().decode();

        //vectorCode.mult(1, 100);
        int[] decVec = vectorCode.decode();

        for (int i : decVec) {
            System.out.print(i+ " ");
        }
        System.out.println();

        vectorCode.printList();

    }
}
