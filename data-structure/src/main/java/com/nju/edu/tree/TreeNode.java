package com.nju.edu.tree;

/**
 * 树的左子女，右兄弟表示法下的树的节点
 * @author Martin
 */
public class TreeNode<T extends Comparable<? extends T>> {

    T element;
    /**
     * 子女节点，相当于左子树
     */
    TreeNode<T> firstChild;
    /**
     * 兄弟节点，相当于右子树
     */
    TreeNode<T> nextSibling;

    public TreeNode(T element) {
        this.element = element;
    }

    public TreeNode(T element, TreeNode<T> firstChild, TreeNode<T> nextSibling) {
        this.element = element;
        this.firstChild = firstChild;
        this.nextSibling = nextSibling;
    }
}
