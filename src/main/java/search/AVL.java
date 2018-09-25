package search;

public class AVL {
    Node root;
    public class  Node {
        int val;
        Node left;
        Node right;
        Node parent;
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
    public void balanceTree(Node position) {

        Node parent = position.parent;
        if (parent == null)
            return;
        int beforeHeight = parent.hight;
        int left = 0, right = 0;
        if (parent.left == null) {
            left = -1;
        } else {
            left = parent.left.hight;
        }
        if (parent.right == null) {
            right = -1;
        } else {
            right = parent.right.hight;
        }

        parent.hight = left > right ? left + 1 : right + 1;
        int afterHeight = parent.hight;

        if (beforeHeight == afterHeight) {
            return;
        } else {
            //高度变化调整
            if (left - right == 2) {
                //LL
                int ll = -1, lr = -1;
                if (parent.left.left != null) {
                    ll = parent.left.left.hight;
                }
                if (parent.left.right != null) {
                    lr = parent.left.right.hight;
                }
                if (ll > lr)
                    llAdjust(parent);
                //LR
                if (lr > ll) {

                    lrAdjust(parent);
                }

            } else if (right - left == 2) {
                int rr = -1, rl = -1;
                if (parent.right.left != null) {
                    rl = parent.right.left.hight;
                }
                if (parent.right.right != null) {
                    rr = parent.right.right.hight;
                }
                //RR
                if (rr > rl)
                    rrAdjust(parent);
                //RL
                if (rl > rr)
                    rlAdjust(parent);
            } else {
                balanceTree(position.parent);
            }
        }
    }

    private void rlAdjust(Node position) {
        rrAdjust(position.right);
        llAdjust(position.parent.parent);
    }

    private void rrAdjust(Node position) {
        Node parent = position.parent;
        Node fix1 = position.right,fix2 = position;
        if (parent == null) { //根结点
            root = position.right;
            position.right.parent = null;
        } else {
            if (parent.right == position) {
                parent.right = position.right;
            } else {
                parent.left = position.right;
            }
            position.right.parent = parent;
        }
        Node  b = position.right.left;
        position.right.left = position;
        position.parent = position.right;
        position.right = b;
        if (b != null)
            b.parent = position;

        fix2.hight = height(fix2);
        fix1.hight = height(fix1);
    }

    private void lrAdjust(Node position) {
        llAdjust(position.left);
        rrAdjust(position.parent.parent);
    }

    private void llAdjust(Node position) {
        Node parent = position.parent;
        Node fix1 = position.left,fix2 = position;
        if (parent == null) { //根结点
            root = position.left;
            position.left.parent = null;
        } else {
            if (parent.left == position) {
                parent.left = position.left;
            } else {
                parent.right = position.left;
            }
            position.left.parent = parent;
        }
        Node  b = position.left.right;
        position.left.right = position;
        position.parent = position.left;
        position.left = b;
        if (b != null)
            b.parent = position;

        fix2.hight = height(fix2);
        fix1.hight = height(fix1);

    }

    int height(Node n) {
        int l = -1, r = -1;
       if (n.left != null)
           l = n.left.hight;
       if (n.right != null)
           r = n.right.hight;

        return l > r ? l + 1 : r + 1;
    }

    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
            return;
        }
        Node temp = root;
        Node parent = null;
        while (temp != null) {
            parent = temp;
            if (val > temp.val)
                temp = temp.right;
            else
                temp = temp.left;
        }
        if (val > parent.val) {
            Node position = new Node(val);
            parent.right = position;
            position.parent = parent;
            balanceTree(position);
        } else {
            Node position = new Node(val);
            parent.left = position;
            position.parent = parent;
            balanceTree(position);
        }
    }
    public void remove(int val) {

        Node node = search(val);
        remove(node);
    }

    public Node successor(Node node) {
        Node successor = node.right;
        while (successor.left != null) {
            successor = successor.left;
        }
        return successor;
    }
    private void remove(Node node) {
        if (node.left == null && node.right == null) {
            Node parent = node.parent;
            if (parent == null) //根节点
                root = null;
            else
                balanceRemoveNode(node, parent);
        } else if (node.left != null && node.right != null) {
            Node successor = successor(node);
            node.val = successor.val;
            Node parent = successor.parent;
            balanceRemoveNode(successor, parent); //因为是后继所以一定有parent
        } else {
            Node parent = node.parent;
            Node replace = node.left == null? node.left : node.right;
            if (parent.left == node) {
                parent.left = replace;
            } else {
                parent.right = replace;
            }
            replace.parent = parent;
            balanceTree(parent);
        }
    }

    private void balanceRemoveNode(Node successor, Node parent) {
        if (parent.left == successor) {
            parent.left = null;
            balanceTree(parent);
        } else {
            parent.right = null;
            balanceTree(parent);
        }
    }

    public Node search(int val) {
        Node n = root;
        if (root == null) {
            return null;
        }
        while (n != null) {
            if (n.val > val)
                n = n.left;
            else if (n.val < val)
                n = n.right;
            else
                return n;
        }
        return null;
    }

    public static void main(String[] args) {
        AVL avl = new AVL();
        avl.insert(2);
        avl.insert(1);
        avl.insert(4);
        avl.insert(3);
        avl.insert(5);
        avl.insert(6);
        avl.insert(7);
        avl.remove(4);
        Node search = avl.search(5);
        System.out.println(1);
    }
}
