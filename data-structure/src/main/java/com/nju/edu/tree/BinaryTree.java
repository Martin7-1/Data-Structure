package com.nju.edu.tree;

import java.util.List;
import java.util.ArrayList;

public class BinaryTree<T extends Comparable<? extends T>> {
    BinaryNode<T> root;

    public BinaryTree(BinaryNode<T> root) {
        this.root = root;
    }

    /**
     * 前序遍历遍历树
     * @return 前序遍历的顺序，递归解法
     */
    public List<T> preorderTraverse() {
        List<T> res = new ArrayList<>();
        preorderTraverse(this.root, res);

        return res;
    }

    private void preorderTraverse(BinaryNode<T> node, List<T> list) {
        if (node == null) {
            return;
        }

        list.add(node.element);
        inorderTraverse(node.left, list);
        inorderTraverse(node.right, list);
    }

    /**
     * 中序遍历遍历树
     * @return 中序遍历的结果
     */
    public List<T> inorderTraverse() {
        List<T> res = new ArrayList<>();
        inorderTraverse(root, res);

        return res;
    }

    private void inorderTraverse(BinaryNode<T> node, List<T> list) {
        if (node == null) {
            return;
        }

        inorderTraverse(node.left, list);
        list.add(node.element);
        inorderTraverse(node.right, list);
    }

    /**
     * 后序遍历遍历树
     * @return 后序遍历的结果
     */
    public List<T> postorderTraverse() {
        List<T> list = new ArrayList<>();
        postorderTraverse(root, list);

        return list;
    }

    private void postorderTraverse(BinaryNode<T> node, List<T> list) {
        if (node == null) {
            return;
        }

        postorderTraverse(node.left, list);
        postorderTraverse(node.right, list);
        list.add(node.element);
    }

    /**
     * 层级遍历遍历树
     * @return 层级遍历的结果
     */
    public List<T> levelorderTraverse() {
        return null;
    }
    
}