package com.nju.edu.graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrimTest {

    private int expect;
    private int actual;

    @Test
    public void test1() {
        MST t = new MST();
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                                    { 2, 0, 3, 8, 5 },
                                    { 0, 3, 0, 0, 7 },
                                    { 6, 8, 0, 0, 9 },
                                    { 0, 5, 7, 9, 0 } };
        // Print the solution
        actual = t.prim(graph);
        expect = 16;
        assertEquals(expect, actual);
    }
    
}
