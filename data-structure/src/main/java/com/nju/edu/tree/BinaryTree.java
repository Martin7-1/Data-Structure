package com.nju.edu.tree;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class BinaryTree<T extends Comparable<? extends T>> {
    BinaryNode<T> root;

    public BinaryTree(BinaryNode<T> root) {
        this.root = root;
    }

    public BinaryTree() {
        this(null);
    }

    public BinaryTree(String pre, String in) {
        // 用先序遍历和中序遍历来构造一棵树
        makeTree(pre, in);
    }

    /**
     * 根据中序遍历和先序遍历构建一棵二叉树
     * @param pre 先序遍历的节点顺序
     * @param in 中序遍历的节点顺序
     */
    private void makeTree(String pre, String in) {
        // TODO: 根据先序遍历和中序遍历构建一棵树   
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
        preorderTraverse(node.left, list);
        preorderTraverse(node.right, list);
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
        // 使用一个队列
        Deque<BinaryNode<T>> queue = new LinkedList<>();
        List<T> list = new ArrayList<>();
        BinaryNode<T> node = root;

        while (root != null) {
            list.add(node.element);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

            try {
                node = queue.getFirst();
            } catch (NoSuchElementException e) {
                break;
            }
        }

        return list;
    }
    
}