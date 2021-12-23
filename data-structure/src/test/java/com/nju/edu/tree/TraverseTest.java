package com.nju.edu.tree;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TraverseTest {

    private static BinaryTree<Integer> tree;
    private int[] expect;
    private int[] actual;
    
    @BeforeClass
    public static void setUp() {
        tree = new BinaryTree<>();
    }

    @Before
    public void clear() {
        tree = new BinaryTree<>();
    }

    @Test
    public void inorderTest1() {
        BinaryNode<Integer> root = new BinaryNode<Integer>(0);
        root.left = new BinaryNode<>(1);
        root.right = new BinaryNode<>(2);
        tree.root = root;
        actual = tree.inorderTraverse().stream().mapToInt(Integer::intValue).toArray();
        List<Integer> list = Arrays.asList(1, 0, 2);
        expect = list.stream().mapToInt(Integer::intValue).toArray();

        assertArrayEquals(expect, actual);
    }

    @Test
    public void preorderTest1() {
        BinaryNode<Integer> root = new BinaryNode<Integer>(0);
        root.left = new BinaryNode<>(1);
        root.right = new BinaryNode<>(2);
        root.left.left = new BinaryNode<>(3);
        tree.root = root;
        actual = tree.preorderTraverse().stream().mapToInt(Integer::intValue).toArray();
        List<Integer> list = Arrays.asList(0, 1, 3, 2);
        expect = list.stream().mapToInt(Integer::intValue).toArray();

        assertArrayEquals(expect, actual);
    }
}
