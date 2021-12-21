package com.nju.edu.graph;

import java.util.Arrays;

/**
 * 图
 * @author Martin7-1
 */
public class Graph {
    
    class Edge implements Comparable<Edge> {

        int src;
        int dest;
        int weight;

        @Override
        public int compareTo(Edge anotherEdge) {
            return this.weight - anotherEdge.weight;
        }
    }

    /**
     * a class to represent a subset for union-find
     * 这里可以用并查集
     */
    class subset {
        int parent;
        int rank;
    }

    int V, E;
    Edge[] edge;

    public Graph(int v, int e) {
        this.V = v;
        this.E = e;
        this.edge = new Edge[E];
        for (int i = 0; i < e; i++) {
            edge[i] = new Edge();
        }
    }

    /**
     * 找到元素i的一个子集合
     * TODO: 用并查集来实现, 封装在一个并查集类中
     * @param subsets 所有子集合
     * @param i 元素i
     * @return 该元素的树根(即该并查集的代表)
     */
    public int find(subset[] subsets, int i) {
        // find root and make root as parent of i
        // path compression -- 路径压缩
        if (subsets[i].parent != i) {
            // 将i到树根的所有顶点都连到树根上
            subsets[i].parent = find(subsets, subsets[i].parent);
        }

        return subsets[i].parent;
    }

    /**
     * 将x和y的子集合并
     * TODO: 封装到并查集类中
     * @param subsets 所有的子集
     * @param x 元素
     * @param y 元素
     */
    public void union(subset[] subsets, int x, int y) {
        // first, we need find the root of x and y
        int xRoot = find(subsets, x);
        int yRoot = find(subsets, y);

        // 采用高度合并的方式
        // 将树高低的合并到树高高的上面
        if (subsets[xRoot].rank < subsets[yRoot].rank) {
            // x的树高比y低，将x合并到y上面
            subsets[xRoot].parent = yRoot;
        } else if (subsets[xRoot].rank < subsets[yRoot].rank) {
            // y的树高比x低，将y合并到x上面
            subsets[yRoot].parent = xRoot;
        } else {
            // 两者树高一样，此时要将树高加一(rank++)
            subsets[yRoot].parent = xRoot;
            subsets[xRoot].rank++;
        }
    }

    /**
     * Kruskal算法生成最小生成树
     * 贪心思想，将所有边排序并在不会形成环的情况下从小到大加入图中
     * @return minimum weight of the MST
     */
    public int KruskalMST() {
        // 最小生成树有V-1条边
        Edge[] result = new Edge[V];
        int e = 0;

        for (int i = 0; i < V; i++) {
            result[i] = new Edge();
        }

        // 步骤一：对所有边进行排序
        // 这里可以通过拷贝一份边来排序，防止破坏原本图的结构
        Arrays.sort(edge);

        subset[] subsets = new subset[V];
        for (int i = 0; i < V; i++) {
            subsets[i] = new subset();
        }

        // 先将所有并查集的树根设置为自身
        for (int v = 0; v < V; v++) {
            subsets[v].parent = v;
            // 只有一个树根的情况高度为0
            subsets[v].rank = 0;
        }

        int index = 0;
        while (e < V - 1) {
            // 每次挑选最小的边
            Edge nextEdge = edge[index++];
            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);

            // 判断x和y是不是同一个并查集中，即判断该条边会不会形成环
            if (x != y) {
                result[e++] = nextEdge;
                // 将两个集合合并
                union(subsets, x, y);
            } else {
                // nothing to do
                // discard the edge
            }
        }

        System.out.println("Following are the edges in the constructed MST");
        int minimumWeight = 0;
        for (int i = 0; i < e; i++) {
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
            minimumWeight += result[i].weight;
        }

        System.out.println("Minium weight MST: " + minimumWeight);
        return minimumWeight;
    }
}
