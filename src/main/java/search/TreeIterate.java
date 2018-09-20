package search;

import java.util.Stack;

public class TreeIterate {

    private Node root;
    public class Node {
        Node left;
        Node right;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public void preOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node p = root;
        while(p != null || !stack.isEmpty()) {
            while (p != null) {
                System.out.println(p.val);
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.right;
            }
        }
    }

    public void midOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node p = root;
        while(p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                System.out.println(p.val);
                p = p.right;
            }
        }
    }

    public void behOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node p = root;
        stack.push(root);
        Node prev = null;
        while(!stack.isEmpty()) {
            Node peek = stack.peek();
            if ((peek.left == null && peek.right == null) || (prev != null && (peek.left == prev || peek.right == prev))) {
                stack.pop();
                System.out.println(peek.val);
                prev = peek;
            } else {
                if (peek.right != null) {
                    stack.push(peek.right);
                }
                if (peek.left != null) {
                    stack.push(peek.left);
                }
            }

        }
    }



    public void createTree(int[] objs) {
        root = new Node(objs[0]);//将第一个作为根节点
        createTree(objs, root, 0);
    }
    public void createTree(int[] objs, Node node, int index) {
        if (index * 2 + 1 < objs.length) {
            node.left = new Node(objs[index * 2 + 1]);
            createTree(objs, node.left, index * 2 + 1);
        }
        if (index * 2 + 2 < objs.length) {
            node.right = new Node(objs[index * 2 + 2]);
            createTree(objs, node.right, index * 2 + 2);
        }
    }

        public static void main(String[] args) {
            TreeIterate bst = new TreeIterate();
            int[] objs={0,1,2,3,4,5,6,7};
            bst.createTree(objs);
//            bst.preOrder(bst.root);
//            bst.midOrder(bst.root);
            bst.behOrder(bst.root);

        }
}
