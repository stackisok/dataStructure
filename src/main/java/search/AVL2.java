package search;

public class AVL2 {

    Node root;
    public class  Node {
        int val;
        Node left;
        Node right;
        int hight;
        public Node(int val) {
            this(val, null, null);
        }
        public Node(int val, Node left, Node right) {
            this(val, left, right, 0);
        }
        public Node(int val, Node left, Node right, int hight) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.hight = hight;
        }
    }

    public void insert(int val) {

        if (root == null)
            root = new Node(val);
        else
            root = insert(val, root);
    }
    public Node insert(int val, Node node) {
        if (node == null)
            return new Node(val, null, null, 1);
        if (val > node.val)
            node.right = insert(val, node.right);
        else
            node.left = insert(val, node.left);

        node.hight =  Math.max(getHight(node.left), getHight(node.right)) + 1;
        if (getHight(node.left) - getHight(node.right) >= 2) {
            if (getHight(node.left.left) > getHight(node.left.right)) {
                node = rightRotate(node);
            } else {
                node.left = leftRotate(node.left);
                node = rightRotate(node);
            }

        } else if (getHight(node.right) - getHight(node.left) >= 2) {
            if (getHight(node.right.right) > getHight(node.right.left)) {
                node = leftRotate(node);
            } else {
                node.right = rightRotate(node.right);
                node = leftRotate(node);
            }
        }
        return node;
    }
    private int getHight(Node n) {
        return n == null ? 0 : n.hight;
    }
    private Node leftRotate(Node node) {
        Node res = node.right;
        Node temp = res.left;
        res.left = node;
        node.right = temp;
        node.hight = Math.max(getHight(node.left), getHight(node.right)) + 1;
        res.hight = Math.max(getHight(res.left), getHight(res.right)) + 1;
        return res;
    }
    private Node rightRotate(Node node) {
        Node res = node.left;
        Node temp = res.right;
        res.right = node;
        node.left = temp;
        node.hight = Math.max(getHight(node.left), getHight(node.right)) + 1;
        res.hight = Math.max(getHight(res.left), getHight(res.right)) + 1;
        return res;
    }

    public static void main(String[] args) {
        AVL2 avl2 = new AVL2();
        avl2.insert(1);
        avl2.insert(4);
        avl2.insert(2);
        avl2.insert(3);
        System.out.println(1);
    }
}
