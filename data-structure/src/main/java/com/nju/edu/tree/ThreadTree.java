package com.nju.edu.tree;

import java.util.Deque;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class ThreadTree<T extends Comparable<? extends T>> {

    private ThreadNode<T> root;
    /**
     * 指向当前节点的一个指针
     */
    private ThreadNode<T> current;

    public ThreadTree(ThreadNode<T> root) {
        this.root = root;
        this.current = this.root;
        makeThread(root);
    }

    public void makeThread(ThreadNode<T> node) {
        // 双向队列模拟栈
        Deque<ThreadNode<T>> stack = new LinkedList<>();
        ThreadNode<T> p = node;
        ThreadNode<T> pre = null;

        while (true) {
            while (p != null) {
                stack.push(p);
                p = p.leftChild;
            }

            if (!stack.isEmpty()) {
                p = stack.pop();
                if (pre != null) {
                    if (pre.rightChild == null) {
                        pre.rightChild = p;
                        pre.rightThread = true;
                    }
                    if (p.leftChild == null) {
                        p.leftChild = pre;
                        p.leftThread = true;
                    }
                }

                pre = p;
                p = p.rightChild;
            } else {
                return;
            }
        }
    }

    /**
     * 用线索化树来进行中序的遍历
     */
    public List<T> inorderThread() {
        List<T> list = new ArrayList<>();
        ThreadNode<T> p;

        for (p = getFirst(); p != null; p = getNext()) {
            list.add(p.element);
        }

        return list;
    }

    /**
     * 获取中序遍历的第一个节点
     */
    private ThreadNode<T> getFirst() {
        while (current.leftChild != null && !current.leftThread) {
            current = current.leftChild;
        }

        return current;
    }

    /**
     * 获取中序遍历的下一个节点
     */
    private ThreadNode<T> getNext() {
        ThreadNode<T> p = current.rightChild;

        // 遍历右子树，如果右子树没有节点的话那么rightChild指向的就是中序遍历的下一个节点
        // 也是从p的左子树开始遍历的
        if (p != null && !current.rightThread) {
            while (p.leftChild != null && !p.leftThread) {
                p = p.leftChild;
            }
        }

        current = p;
        return current;
    }
}