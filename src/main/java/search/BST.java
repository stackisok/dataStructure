package search;

/**
 * 二叉搜索树
 *
 * 要求对于任意一个节点，其值不小于左子树的任何节点，且不大于右子树的任何节点
 * 不可以有相同元素
 */
public class BST {

    Node root;

    public BST(int i) {
        root = new Node(i, null);
    }

    public class Node {
        Node left;
        Node right;
        Node parent;
        int val;

        public Node(int val, Node parent) {
            this.val = val;
            this.parent = parent;
        }
    }

    /**
     * @Author: Wang Chenjun
     * @Description: 在树中寻找节点，找到则返回
     * @Date: 14:37 2018/9/20
     * @param target
     * @param node
     * @return search.BST.Node
     * @throws
     */
    public Node search(int target, Node node) {
        if (node == null) return null;
        return getNode(target, node);
    }
    public Node search(int target) {
        if (root == null) return null;
        return getNode(target, root);
    }

    private Node getNode(int target, Node node) {
        if (node.val > target)
            return search(target, node.left);
        else if (node.val < target)
            return search(target, node.right);
        else
            return node;
    }

    /**
     * @Author: Wang Chenjun
     * @Description: 插入
     * @Date: 14:37 2018/9/20
     * @param val
     * @return void
     * @throws
     */
    public void insert(int val) {
        Node parent = null;
        Node pos = root;
        while (pos != null) {
            parent = pos;
            if (pos.val > val) {
                pos = pos.left;
            } else if (pos.val < val) {
                pos = pos.right;
            }
        }
        if (parent.val > val) {
            parent.left = new Node(val, parent);
        } else if (parent.val < val) {
            parent.right = new Node(val, parent);
        }
    }

    /**
     * @Author: Wang Chenjun
     * @Description: 根据val值删除节点
     * @Date: 14:37 2018/9/20
     * @param val
     * @return void
     * @throws
     */
    public void remove(int val) {

        Node findNode = search(val, root);
        remove(findNode);

    }
    /**
     * @Author: Wang Chenjun
     * @Description: 根据节点删除节点
     * @Date: 14:38 2018/9/20
     * @param node
     * @return void
     * @throws
     */
    public void remove(Node node) {
        Node parent = node.parent;
        if (node.left == null && node.right == null) {//当要删除的节点没有左右孩子则直接删除
            if (parent == null) {//仅剩一个root节点时候
                root = null;
                return;
            }
            if (parent.left == node)
                parent.left = null;
            else
                parent.right = null;

        } else if (node.left != null && node.right != null) {
            //当要删除的节点既有左孩子又有右孩子则找后继
            Node successor = findSuccessor(node);
            //然后删除后继节点
            remove(successor);
            //把要删除的节点值替换为后继节点的值
            node.val = successor.val;
        } else {//当要删除的节点只有一个孩子时（左孩子或者右孩子），将他的孩子替换他的位置
            Node replace = null;
            //将孩子节点保存在替换节点
            if (node.left != null)
                replace = node.left;
            else
                replace = node.right;
            //将删除节点双亲指向删除节点的引用，改成指向替换节点

            //当删除节点不是根节点时候
            if (parent != null) {
                if (parent.left == node)
                    parent.left = replace;
                else
                    parent.right = replace;
                //将替换节点的双亲替换成要删除节点的双亲
                replace.parent = parent;
            } else {
                root = replace;
            }
        }

    }

    /**
     * @Author: Wang Chenjun
     * @Description: 寻找后继节点
     * @Date: 14:43 2018/9/20
     * @param node
     * @return search.BST.Node
     * @throws
     */
    private Node findSuccessor(Node node) {
        Node p = node.right;

        while (p.left != null) {
            p = p.left;
        }

        return p;
    }

    /**
     * 0
     *   2
     *  1  3
     *        5
     *       4 6
     *             7
     *
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        BST bst = new BST(0);
        bst.insert(2);
        bst.insert(1);
        bst.insert(3);
        bst.insert(5);
        bst.insert(4);
        bst.insert(6);
        bst.insert(7);
        Node searchNode = bst.search(9);
        if (searchNode != null) {
            System.out.println(searchNode.val);
            System.out.println(searchNode.parent.val);
        } else {
            System.out.println("未找到");
        }
        bst.remove(1);
        bst.remove(2);
        bst.remove(3);
        bst.remove(4);
        bst.remove(5);
        bst.remove(6);
        bst.remove(7);
        bst.remove(0);
        System.out.println(1);

    }
}
