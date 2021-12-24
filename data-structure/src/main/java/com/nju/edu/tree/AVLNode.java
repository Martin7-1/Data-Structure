package com.nju.edu.tree;

public class AVLNode {
    public int element;
    public AVLNode left;
    public AVLNode right;

    /**
     * 用一个节点来记录该节点的右子树 - 左子树的树高
     */
    private int height;

    public AVLNode(int element) {
        this(element, null, null);
    }

    public AVLNode(int element, AVLNode left, AVLNode right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    /**
     * 获得当前节点的树高
     */
    public static int getHeight(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}