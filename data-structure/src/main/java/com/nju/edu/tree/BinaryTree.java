package com.nju.edu.tree;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树的四种遍历
 * @author Martin
 */
public class BinaryTree<T extends Comparable<? extends T>> {
    BinaryNode<T> root;

    public BinaryTree(BinaryNode<T> root) {
        this.root = root;
    }

    public BinaryTree() {
        this(null);
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
     * 不使用递归而使用栈来完成中序遍历
     * @return 中序遍历顺序的list
     */
    public List<T> inorderStack() {
        Deque<BinaryNode<T>> stack = new LinkedList<>();
        BinaryNode<T> node = root;
        List<T> res = new ArrayList<>();

        while (true) {
            while (node != null) {
                stack.push(node);
                // 不断将左子树节点压入栈，因为中序遍历是从左子树的叶子节点开始的
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                res.add(node.element);
                node = node.right;
            } else {
                break;
            }
        }

        return res;
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