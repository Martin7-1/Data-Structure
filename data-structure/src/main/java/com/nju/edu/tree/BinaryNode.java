package com.nju.edu.tree;

public class BinaryNode<T extends Comparable<? extends T>> {

    public T element;
    public BinaryNode<T> left;
    public BinaryNode<T> right;

    public BinaryNode() {
        this(null, null, null);
    }

    public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(T element) {
        this(element, null, null);
    }
}