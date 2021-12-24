package com.nju.edu.tree;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BSTTest {

    BinarySearchTree t;

    @Before
    public void setUp() {
        t = new BinarySearchTree();
    }

    @Test
    public void findMaxTest() {
        t.insert(1);
        t.insert(2);
        t.insert(3);

        assertEquals(3, t.findMax());
    }

    @Test
    public void findMinTest() {
        t.insert(7);
        t.insert(1);
        t.insert(0);
        t.insert(2);
        t.insert(8);
        t.insert(3);
        t.insert(9);

        assertEquals(0, t.findMin());
    }

    @Test
    public void removeTest() {
        t.insert(7);
        t.insert(1);
        t.insert(0);
        t.insert(2);
        t.insert(8);
        t.insert(3);
        t.insert(9);

        assertEquals(9, t.findMax());
        t.remove(9);
        assertEquals(8, t.findMax());
        t.remove(8);
        assertEquals(7, t.findMax());
    }
    
}
