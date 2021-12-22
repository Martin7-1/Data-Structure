package com.nju.edu.graph;

public class MST {
    
    private static final int V = 5;

    /**
     * 找到与已有的点集相连的边的权重最小的顶点
     * @param key 权重数组
     * @param mstSet 是否处在MST中
     * @return 与已有MST集合的边的权重最小的顶点索引
     */
    public int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        
        for (int i = 0; i < V; i++) {
            if (mstSet[i] == false && key[i] < min) {
                min = key[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public void printMST(int[] parent, int[][] graph) {
        // 这里用的是领接矩阵来表示图
        System.out.println("Edge \tWeight");
        for (int i = 0; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    /**
     * Prim算法生成最小生成树
     * @param graph
     */
    public int prim(int[][] graph) {
        // 创建一个数组来存储已经在MST中的顶点
        int[] parent = new int[V];
        int[] key = new int[V];
        int minWeight = 0;

        boolean[] mstSet = new boolean[V];

        for (int i = 0; i < V; i++) {
            // 将权重首先都初始化为无穷
            // 因为此时还没有顶点加入MST集合
            // 所以我们认为没有边与一个空集相连，即所有边的权重都是无穷
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // 将第一个顶点放入mstSet中
        key[0] = 0;
        parent[0] = -1;

        for (int i = 0; i < V - 1; i++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                // 找到权重最小的边
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        for (int i = 0; i < key.length; i++) {
            minWeight += key[i];
        }
        
        return minWeight;
    }
}
