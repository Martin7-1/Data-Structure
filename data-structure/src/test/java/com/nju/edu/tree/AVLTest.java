package com.nju.edu.tree;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class AVLTest {

    AVLTree t;
    int[] actual;
    int[] expect;

    @Before
    public void setUp() {
        this.t = new AVLTree();
    }

    @Test
    public void test1() {
        t.insert(1);
        t.insert(2);
        t.insert(3);

        expect = Arrays.asList(1, 2, 3).stream().mapToInt(Integer::intValue).toArray();
        actual = t.inorderTraverse().stream().mapToInt(Integer::intValue).toArray();

        assertArrayEquals(expect, actual);
    }

    @Test
    public void test2() {
        t.insert(3);
        t.insert(2);
        t.insert(1);

        expect = Arrays.asList(1, 2, 3).stream().mapToInt(Integer::intValue).toArray();
        actual = t.inorderTraverse().stream().mapToInt(Integer::intValue).toArray();

        assertArrayEquals(expect, actual);
    }

    @Test
    public void test3() {
        t.insert(1);
        t.insert(2);
        t.insert(4);
        t.insert(3);

        expect = Arrays.asList(1, 2, 3, 4).stream().mapToInt(Integer::intValue).toArray();
        actual = t.inorderTraverse().stream().mapToInt(Integer::intValue).toArray();

        assertArrayEquals(expect, actual);
    }

    @Test
    public void test4() {
        t.insert(1);
        expect = Arrays.asList(1).stream().mapToInt(Integer::intValue).toArray();
        actual = t.inorderTraverse().stream().mapToInt(Integer::intValue).toArray();
        assertArrayEquals(expect, actual);

        t.insert(26);
        expect = Arrays.asList(1, 26).stream().mapToInt(Integer::intValue).toArray();
        actual = t.inorderTraverse().stream().mapToInt(Integer::intValue).toArray();
        assertArrayEquals(expect, actual);

        t.insert(3);
        expect = Arrays.asList(1, 3, 26).stream().mapToInt(Integer::intValue).toArray();
        actual = t.inorderTraverse().stream().mapToInt(Integer::intValue).toArray();
        assertArrayEquals(expect, actual);

        t.insert(23);
        expect = Arrays.asList(1, 3, 23, 26).stream().mapToInt(Integer::intValue).toArray();
        actual = t.inorderTraverse().stream().mapToInt(Integer::intValue).toArray();
        assertArrayEquals(expect, actual);

        t.insert(4);
        expect = Arrays.asList(1, 3, 4, 23, 26).stream().mapToInt(Integer::intValue).toArray();
        actual = t.inorderTraverse().stream().mapToInt(Integer::intValue).toArray();
        assertArrayEquals(expect, actual);

        t.insert(24);
        expect = Arrays.asList(1, 3, 4, 23, 24, 26).stream().mapToInt(Integer::intValue).toArray();
        actual = t.inorderTraverse().stream().mapToInt(Integer::intValue).toArray();
        assertArrayEquals(expect, actual);

        t.insert(25);
        expect = Arrays.asList(1, 3, 4, 23, 24, 25, 26).stream().mapToInt(Integer::intValue).toArray();
        actual = t.inorderTraverse().stream().mapToInt(Integer::intValue).toArray();
        assertArrayEquals(expect, actual);
    }
    
}
