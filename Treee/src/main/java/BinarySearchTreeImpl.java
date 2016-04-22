import java.util.LinkedList;

public class BinarySearchTreeImpl implements BinarySearchTree {

    private  Node root;
    boolean searchTree = true;
    private Node inRoot;

    public void insert(int element) {
        /*this.root = */
        insertNode(null, this.root, element);
        insert_case1(inRoot);

    }

    private Node insertNode(Node parent, Node root, int element) {
        if (root == null) {
            root = new Node(element);
            root.setLeft(null);
            root.setRight(null);
            root.setParent(parent);
            if (parent!=null) {
                if (root.getData() <= parent.getData()) {
                    parent.setLeft(root);
                } else {
                    parent.setRight(root);
                }
            }
            inRoot = root;
        } else if (element <= root.getData()) {
            root.setLeft(insertNode(root, root.getLeft(), element));
        } else {
            root.setRight(insertNode(root, root.getRight(), element));
        }
        return root;
    }


    private void insert_case1(Node n){
        if (n.getParent() == null){
            n.setColor('b');
            this.root = n;
        }else{
            insert_case2(n);
        }
    }

    private void insert_case2(Node n){
        if (n.getParent().getColor() == 'b'){
            return;
        }else{
            insert_case3(n);
        }
    }

    private void insert_case3(Node n){
        Node u = uncle(n);
        Node g;
        if ((u != null) && (u.getColor() == 'r')&&(n.getParent().getColor() == 'r')){
            n.getParent().setColor('b');
            u.setColor('b');
            g = grandparent(n);
            g.setColor('r');
            insert_case1(g);
        }else{
            insert_case4(n);
        }
    }

    private void insert_case4(Node n){
        Node g = grandparent(n);
        if ((n == n.getParent().getRight())&&(n.getParent() == g.getLeft())) {
            rotate_left(n.getParent());
            n = n.getLeft();
        }else if ((n == n.getParent().getLeft())&&(n.getParent() == g.getRight())){
            rotate_right(n.getParent());
            n = n.getRight();
        }
        insert_case5(n);
    }

    private void insert_case5(Node n){
        Node g = grandparent(n);
        n.getParent().setColor('b');
        g.setColor('r');
        if ((n == n.getParent().getLeft())&&(n.getParent() == g.getLeft())){
            rotate_right(g);
        }else{
            rotate_left(g);
        }
    }



    private Node grandparent(Node n){
        if ((n != null) && (n.getParent() != null)){
            return n.getParent().getParent();
        }else{
            return null;
        }
    }

    private Node uncle(Node n){
        Node g = grandparent(n);
        if (g == null){
            return null;
        }
        if (n.getParent() == g.getLeft()){
            return g.getRight();
        }else{
            return g.getLeft();
        }
    }

    private void rotate_left(Node n){
        Node pivot = n.getRight();
        pivot.setParent(n.getParent());
        if (n.getParent() != null) {
            if (n.getParent().getLeft() == n) {
                n.getParent().setLeft(pivot);
            } else {
                n.getParent().setRight(pivot);
            }
        }else{
            this.root = pivot;
        }

            n.setRight(pivot.getLeft());
            if (pivot.getLeft() != null){
                pivot.getLeft().setParent(n);
            }
            n.setParent(pivot);
            pivot.setLeft(n);
    }

    private void rotate_right(Node n){
        Node pivot = n.getLeft();
        pivot.setParent(n.getParent());
        if (n.getParent() != null){
            if(n.getParent().getLeft() == n){
                n.getParent().setLeft(pivot);
            }else{
                n.getParent().setRight(pivot);
            }
        }else{
            this.root = pivot;
        }

        n.setLeft(pivot.getRight());
        if (pivot.getRight() != null){
            pivot.getRight().setParent(n);
        }

        n.setParent(pivot);
        pivot.setRight(n);
    }


    public void show() {
        showRec(root, 0);
    }

    private void showRec(Node root, int level) {
        if (root != null) {
            showRec(root.getRight(), level + 1);

            for (int i = 0; i < level; i++) {
                System.out.print("--");
            }

            System.out.println(root.getData());

            showRec(root.getLeft(), level + 1);
        }
    }

    private void inOrder(Node root)
    {
        if (root != null) {
            inOrder(root.getLeft());
            //System.out.print(root.getData() + " ");
            inOrder(root.getRight());
        }
    }

    public void inOrderPrint() {
        inOrder(this.root);
    }

    private void isSearchTree(Node root){
        if (root != null) {
            if (root.getLeft() == null & root.getRight() != null) {
                searchTree = root.getData() < root.getRight().getData();
            } else if (root.getRight() == null & root.getLeft() != null) {
                searchTree = root.getLeft().getData() < root.getData();
            } else if (root.getLeft() != null & root.getRight() != null){
                searchTree = (root.getLeft().getData() < root.getData()) & (root.getData() < root.getRight().getData());
            }
            isSearchTree(root.getLeft());
            isSearchTree(root.getRight());
        }
    }

    public void isSearchTreePrint(){
        isSearchTree(this.root);
        System.out.println("\n Is tree searching? "+searchTree);
    }

    private boolean isLevelSum(Node root){
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.addLast(root);
        if (queue.get(0) == null){
            return false;
        }
        if (root.getLeft() == null & root.getRight() == null){
            return true;
        }
        int prelevelSum = 0;
        int levelSum = root.getData();
        int count = 1;
        while (count != 0){
            int precount = count;
            count = 0;
            prelevelSum = levelSum;
            levelSum = 0;
            for (int i = 0; i < precount; i++) {
                Node x = queue.poll();
                levelSum += x.getData();
                if (x.getLeft() != null){
                    queue.addLast(x.getLeft());
                    count++;
                }
                if (x.getRight() != null){
                    queue.addLast(x.getRight());
                    count++;
                }
            }
            if (prelevelSum > levelSum){
                return false;
            }
            System.out.println(true);
        }
        return true;
    }
    public void runIsLevelSum(){
        System.out.println("Is every level bigger? " + isLevelSum(this.root));
    }
}
