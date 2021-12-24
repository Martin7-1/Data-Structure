package com.nju.edu.tree;

/**
 * 二叉搜索树
 * 
 * @author Martin
 */
public class BinarySearchTree {

    /**
     * 二叉搜索树的根节点
     */
    private BinaryNode<Integer> root;

    public BinarySearchTree() {
        root = null;
    }

    /**
     * 清空二叉搜索树，Java的垃圾回收机制让我们不用自己释放内存
     */
    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 寻找值为x的节点
     * 
     * @param x 值为x
     * @return true if x is in the binary search tree, false otherwise
     */
    public boolean find(int x) {
        return find(x, root);
    }

    /**
     * 找到二叉搜索树中的最小值
     * 
     * @return 最小值
     */
    public int findMin() {
        return elementAt(findMin(root));
    }

    /**
     * 找到二叉搜索树的最大值
     * 
     * @return 最大值
     */
    public int findMax() {
        return elementAt(findMax(root));
    }

    /**
     * 将值为x的节点插入二叉搜索树中
     * 
     * @param x 值为x的顶点
     */
    public void insert(int x) {
        root = insert(x, root);
    }

    /**
     * 去除二叉搜索树中值为x的顶点
     * 
     * @param x 值为x的顶点
     */
    public void remove(int x) {
        root = remove(x, root);
    }

    /**
     * 按照中序遍历的顺序将x输出
     */
    public void printTree() {
        // TODO
    }

    private int elementAt(BinaryNode<Integer> node) {
        if (node != null) {
            return node.element;
        }

        return -1;
    }

    /**
     * 寻找二叉搜索树中是否有值为x的顶点
     * @param x 值为x的顶点
     * @param node 当前的节点
     * @return x
     */
    private boolean find(int x, BinaryNode<Integer> root) {
        BinaryNode<Integer> node = root;

        while (node != null){
            if (node.element > x) {
                node = node.left;
            } else if (node.element < x) {
                node = node.right;
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * 递归法找二叉搜索树中的最小值
     * @param node 节点
     * @return 最小值
     */
    private BinaryNode<Integer> findMin(BinaryNode<Integer> node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        }
        
        return findMin(node.left);
    }

    /**
     * 非递归法找到二叉搜索树中的最大值
     * @param node 节点
     * @return 最大值
     */
    private BinaryNode<Integer> findMax(BinaryNode<Integer> node) {
        if (node != null) {
            while (node.right != null) {
                node = node.right;
            }
        }

        return node;
    }

    /**
     * 在二叉搜索树中插入值
     * @param x 插入的值x
     * @param root 根节点
     * @return 新的根节点
     */
    private BinaryNode<Integer> insert(int x, BinaryNode<Integer> root) {
        if (root == null) {
            root = new BinaryNode<Integer>(x);
        } else if (root.element > x) {
            root.left = insert(x, root.left);
        } else if (root.element < x) {
            root.right = insert(x, root.right);
        }

        return root;
    }

    /**
     * 删除二叉搜索树中值为x的节点
     * @param x 要删除的节点的值
     * @param root 根节点
     * @return 新的根节点
     */
    private BinaryNode<Integer> remove(int x, BinaryNode<Integer> root) {
        // 首先我们需要找到这个节点
        if (root == null) {
            return root;
        }

        if (root.element > x) {
            // 当前节点值比x大，递归向左搜索
            root.left = remove(x, root.left);
        } else if (root.element < x) {
            // 当前节点值比x小，递归向右搜索
            root.right = remove(x, root.right);
        } else {
            // 有3种情况
            // 1. x是叶子节点，直接删除
            // 2. x有一个子节点，则将x的唯一子节点上移，删除当前节点
            // 3. x有两个子节点，则可以删除左子树的最大值或右子树的最小值，让该值替代当前x的值
            if (root.left != null && root.right != null) {
                // 第三种情况
                // 找左子树的最大值
                BinaryNode<Integer> max = findMax(root.left); 
                root.element = max.element;
                root.left = remove(root.element, root.left);
            } else {
                root = (root.left == null) ? root.right : root.left; 
            }
        }

        return root;
    }

}
