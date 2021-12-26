package com.nju.edu.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 拓扑排序
 * @author Martin
 */
public class TopologicalSort {

    private static List<Character> ans = new ArrayList<>();

    /**
     * 顶点类
     */
    public static class Vertex {
        /**
         * 记录顶点的入度
         */
        int inNumber;
        char element;
        Edge firstNeighbor;

        public Vertex(int inNumber, char element, Edge firstNeighbor) {
            this.inNumber = inNumber;
            this.element = element;
            this.firstNeighbor = firstNeighbor;
        }
    }

    /**
     * 边类
     */
    public static class Edge {
        /**
         * 权重
         */
        int weight;
        /**
         * 出度指向的顶点
         */
        int destVertex;
        Edge next;

        public Edge(int weight, int destVertex, Edge next) {
            this.weight = weight;
            this.destVertex = destVertex;
            this.next = next;
        }
    }

    /**
     * 拓扑排序
     * @param graph 图
     * @return true if the graph has cycle, false otherwise
     */
    public static boolean topological(List<Vertex> graph) {
        int outVertices = 0;
        // 用栈来存储入度为0的点的个数
        Deque<Vertex> stack = new LinkedList<>();
        for (Vertex vertex : graph) {
            if (vertex.inNumber == 0) {
                stack.push(vertex);
            }
        }

        // 开始进行拓扑排序
        // 栈中每弹出一个入度为0的顶点，就将图中这个顶点的出边和这个顶点全部删除
        // 然后更新图中剩余顶点的入度，并将入度为0的顶点重新压入栈中
        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();
            ans.add(vertex.element);
            // 统计已经排好序的顶点的个数，用来判断有没有cycle
            outVertices++;
            Edge edge = vertex.firstNeighbor;
            while (edge != null) {
                // 获得该条边的目标顶点
                Vertex destVertex = graph.get(edge.destVertex);
                destVertex.inNumber--;
                // 判断入度是否为0，是0就入栈
                if (destVertex.inNumber == 0) {
                    stack.push(destVertex);
                }
                // 遍历下一条边
                edge = edge.next;
            }
        }

        if (outVertices == graph.size()) {
            return true;
        }
        
        return false;
    }

    public static List<Character> getList() {
        return ans;
    }
    
}
