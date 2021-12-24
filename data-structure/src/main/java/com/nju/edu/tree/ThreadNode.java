package com.nju.edu.tree;

public class ThreadNode<T extends Comparable<? extends T>> {
    T element;
    ThreadNode<T> leftChild;
    ThreadNode<T> rightChild;

    /**
     * 增加一个boolean字段判断该节点中的左右子女节点存的是线索还是真正的子女
     */
    boolean leftThread;
    boolean rightThread;

    public ThreadNode(T val) {
        this.element = val;
        leftThread = false;
        rightThread = false;
    }

    public ThreadNode(T val, ThreadNode<T> leftChild, ThreadNode<T> rightChild) {
        this.element = val;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        // duplicate, 会自动设成false;
        this.leftThread = false;
        this.rightThread = false;
    }
}