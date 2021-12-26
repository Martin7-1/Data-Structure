package com.nju.edu.disj;

public class DisjSet {

    /**
     * 数组中存放负数的代表是树根，且该数的绝对值-1代表其高度(树根高度为0)
     */
    private int[] parent;

    public DisjSet(int elementNumber) {
        this.parent = new int[elementNumber];
        for (int i = 0; i < elementNumber; i++) {
            // 每个点此时都是一个树根
            parent[i] = -1;
        }
    }

    /**
     * 合并两个等价类
     * @param root1 等价类一的代表，树的根
     * @param root2 等价类二的代表，树的跟
     */
    public void union(int root1, int root2) {
        // 优化，将树高低的接到树高高的上面
        if (parent[root2] < parent[root1]) {
            // 说明root2所在等价类的树高比较高
            // 将root1接到root2上面
            parent[root1] = root2;
        } else if (parent[root1] > parent[root2]) {
            parent[root2] = root1;
        } else {
            // 如果两个高度相等，需要对高度进行加一
            parent[root2] = root1;
            parent[root1]--;
        }
    }

    /**
     * 找到某个元素所在等价类的代表，即所在树的树根
     * @param x 目标元素
     * @return x所在等价类的树根
     */
    public int find(int x) {
        // 优化查找，每次查找都把路径上的点的父节点变成根节点
        if (parent[x] < 0) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }
    
}
