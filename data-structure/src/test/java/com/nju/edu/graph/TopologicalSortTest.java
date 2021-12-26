package com.nju.edu.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.nju.edu.graph.TopologicalSort.Edge;
import com.nju.edu.graph.TopologicalSort.Vertex;

import org.junit.Test;

public class TopologicalSortTest {

    private List<Vertex> graph = new ArrayList<>();
    private String expect;
    private String actual;

    @Test
    public void test1() {
        graph.clear();
        Edge edge1 = new Edge(10, 1,null);
        Edge edge2 = new Edge(10, 2,null);
        Vertex a = new Vertex(0, 'A', edge1);
        Vertex b = new Vertex(1, 'B', edge2);
        Vertex c = new Vertex(1, 'C', null);
        graph.add(a);
        graph.add(b);
        graph.add(c);
        expect = "ABC";

        assertTrue(TopologicalSort.topological(graph));
        actual = TopologicalSort.getList().stream().map(String::valueOf).collect(Collectors.joining());
        assertEquals(expect, actual);
    }
    
}
