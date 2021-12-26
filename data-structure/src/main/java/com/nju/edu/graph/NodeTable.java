package com.nju.edu.graph;

/**
 * 图的领接表表示形式
 * @author Martin
 */
public class NodeTable {
    // 有一个顶点表，每个格子有一个链表来指向相邻的边
    private Vertex[] nodeTable;
    private static final int DEFAULT_CAPACITY = 10;

    public NodeTable() {
        this(DEFAULT_CAPACITY);
    }

    public NodeTable(int capacity) {
        nodeTable = new Vertex[capacity];
        for (int i = 0; i < capacity; i++) {
            // 初始化，防止空指针报错，这里可以用对象池模式来进行管理
            nodeTable[i] = new Vertex(-1, null);
            nodeTable[i].firstNeighbor = new Edge();
        }
    }

    public static class Vertex {
        int data;
        Edge firstNeighbor;

        public Vertex() {

        }

        public Vertex(int data, Edge firstNeighbor) {
            this.data = data;
            this.firstNeighbor = firstNeighbor;
        }
    }

    public static class Edge {
        Edge next;
        Vertex dest;
        /**
         * 权重
         */
        int weight;

        public Edge() {

        }

        public Edge(Edge next, Vertex dest, int weight) {
            this.next = next;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public Vertex get(int index) {
        return this.nodeTable[index];
    }

    public int getSize() {
        return this.nodeTable.length;
    }
}
