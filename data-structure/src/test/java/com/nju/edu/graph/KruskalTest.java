package com.nju.edu.graph;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class KruskalTest {

    private static Graph graph;
    private int expect;
    private int actual;

    @BeforeClass
    public static void setUp() {
        int v = 4;
        int e = 5;
        graph = new Graph(v, e);
    }

    @Test
    public void test1() {
        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        actual = graph.KruskalMST();
        expect = 19;

        assertEquals(expect, actual);
    }
    
}
