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
    
}
