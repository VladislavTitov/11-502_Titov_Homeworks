import java.util.LinkedList;

public class BinarySearchTreeImpl implements BinarySearchTree {

    private  Node root;
    boolean searchTree = true;

    private Node insertNode(Node root, int element)
    {
        if (root == null) {
            root = new Node(element);
            /*
            root.setLeft(null);
            root.setRight(null);
            */
        } else if (element <= root.getData()) {
            root.setLeft(insertNode(root.getLeft(), element));
        } else {
            root.setRight(insertNode(root.getRight(), element));
        }

        return root;
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

    public void insert(int element) {
        this.root = insertNode(this.root, element);
    }

    public void show() {
        showRec(root, 0);
    }

    private void inOrder(Node root)
    {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getData() + " ");
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
