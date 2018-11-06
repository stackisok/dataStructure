package search;


import java.util.ArrayList;
import java.util.List;

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
    public void remove(int val) {

            root = remove(val, root);
    }

    Node findSuccessor(Node n) {
        if (n.right == null)
            return n;
        n = n.right;
        while (n.left != null)
            n = n.left;
        return n;
    }
    private Node remove(int val, Node node) {
        if (val > node.val) {
            node.right = remove(val, node.right);
            node = balance(node);
        } else if (val < node.val) {
            node.left = remove(val, node.left);
            node = balance(node);
        } else {
            if (node.left != null && node.right != null) {
                Node successor = findSuccessor(node);
                int temp = successor.val;
                successor.val = node.val;
                node.val = temp;
                node.right = remove(successor.val, node.right);
                return node;
            } else if (node.left != null || node.right != null){
                return node.left != null ? node.left : node.right;
            } else {
                return null;
            }
        }
        node.hight =  Math.max(getHight(node.left), getHight(node.right)) + 1;
        return node;
    }

    private Node balance(Node node) {
        Node left = node.left;
        Node right = node.right;
        if (getHight(node.left) - getHight(node.right) >= 2) {
            if (left.left.val > left.right.val) {
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


    public void BFS() {
        List<Node> list = new ArrayList<>();
        List<Node> list2 = new ArrayList<>();
        list.add(root);
        while (!isAllNull(list)) {
            list2 = new ArrayList<>();
            for (Node node : list) {
                if (node != null)
                    System.out.print(node.val + ",");
                else
                    System.out.print("null,");
                if (node == null) {

                }else{
                    if (node.left != null)
                        list2.add(node.left);
                    else
                        list2.add(null);
                    if (node.right != null)
                        list2.add(node.right);
                    else
                        list2.add(null);
                }
            }
            list = list2;
        }

    }
    public boolean isAllNull(List<Node> list) {

        for (Node n : list) {
            if (n != null)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        AVL2 avl2 = new AVL2();
        avl2.insert(3);
        avl2.insert(4);
        avl2.insert(1);
        avl2.insert(2);
        avl2.insert(5);
        avl2.insert(6);
        avl2.insert(7);
        avl2.insert(8);
        avl2.BFS();
        System.out.println();
        avl2.remove(2);
        avl2.BFS();
        avl2.remove(5);
        System.out.println();
        avl2.BFS();

    }
}
