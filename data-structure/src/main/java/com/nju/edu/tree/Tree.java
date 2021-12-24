package com.nju.edu.tree;

/**
 * 树的左子女，右兄弟表示法
 * @author Martin
 */
public class Tree<T extends Comparable<? extends T>> {

    TreeNode<T> root;
    TreeNode<T> current; 

    public Tree(TreeNode<T> root) {
        this.root = root;
        // current指向当前的节点
        current = root;
    }

    /**
     * 插入子女节点
     * @param val 新节点的值
     */
    public void insertChild(T val) {
        TreeNode<T> newNode = new TreeNode<>(val);

        if (current.firstChild == null) {
            // 如果当前节点还没有子女节点
            current.firstChild = newNode;
        } else {
            // 如果当前节点已经有了子女节点
            // 那么我们就找到当前子女节点的nextSibling
            TreeNode<T> child = current.firstChild;
            while (child.nextSibling != null) {
                child = child.nextSibling;
            }

            child.nextSibling = newNode;
        }
    }
    
}
