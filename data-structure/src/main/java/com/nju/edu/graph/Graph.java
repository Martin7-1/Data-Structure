package com.nju.edu.graph;

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
}
