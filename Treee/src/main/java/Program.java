public class Program {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTreeImpl();

        int array[] = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }

        tree.show();

        tree.inOrderPrint();
        //tree.isSearchTreePrint();
        //tree.runIsLevelSum();
    }

}
