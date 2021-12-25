package com.nju.edu.tree;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ThreadTest {

    ThreadTree<Integer> tree;
    int[] actual;
    int[] expect;

    @Test
    public void test1() {
        ThreadNode<Integer> root = new ThreadNode<Integer>(0);
        root.leftChild = new ThreadNode<>(1);
        root.rightChild = new ThreadNode<>(2);
        tree = new ThreadTree<>(root);
        actual = tree.inorderThread().stream().mapToInt(Integer::intValue).toArray();
        List<Integer> list = Arrays.asList(1, 0, 2);
        expect = list.stream().mapToInt(Integer::intValue).toArray();

        assertArrayEquals(expect, actual);
    }

    @Test
    public void test2() {
        ThreadNode<Integer> root = new ThreadNode<Integer>(0);
        root.leftChild = new ThreadNode<>(1);
        root.leftChild.leftChild = new ThreadNode<Integer>(3);
        root.leftChild.rightChild = new ThreadNode<Integer>(4);
        root.rightChild = new ThreadNode<>(2);
        root.rightChild.rightChild = new ThreadNode<Integer>(5);
        tree = new ThreadTree<>(root);
        actual = tree.inorderThread().stream().mapToInt(Integer::intValue).toArray();
        List<Integer> list = Arrays.asList(3, 1, 4, 0, 2, 5);
        expect = list.stream().mapToInt(Integer::intValue).toArray();

        assertArrayEquals(expect, actual);
    }

    @Test
    public void test3() {
        ThreadNode<Integer> root = new ThreadNode<Integer>(0);
        root.leftChild = new ThreadNode<>(1);
        root.leftChild.leftChild = new ThreadNode<Integer>(3);
        root.leftChild.rightChild = new ThreadNode<Integer>(4);
        root.leftChild.rightChild.leftChild = new ThreadNode<Integer>(7);
        root.rightChild = new ThreadNode<>(2);
        root.rightChild.rightChild = new ThreadNode<Integer>(5);
        root.rightChild.rightChild.leftChild = new ThreadNode<Integer>(6);
        tree = new ThreadTree<>(root);
        actual = tree.inorderThread().stream().mapToInt(Integer::intValue).toArray();
        List<Integer> list = Arrays.asList(3, 1, 7, 4, 0, 2, 6, 5);
        expect = list.stream().mapToInt(Integer::intValue).toArray();

        assertArrayEquals(expect, actual);
    }
    
}
