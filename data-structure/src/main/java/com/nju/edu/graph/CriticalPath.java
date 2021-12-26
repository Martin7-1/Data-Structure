package com.nju.edu.graph;

import java.util.ArrayList;
import java.util.List;

import com.nju.edu.graph.NodeTable.Edge;
import com.nju.edu.graph.NodeTable.Vertex;

public class CriticalPath {

    NodeTable nodeTable;
    int size = nodeTable.getSize();
    private List<Vertex> criticalPath = new ArrayList<>();

    public CriticalPath(NodeTable nodeTable) {
        this.nodeTable = nodeTable;
    }

    public void getCriticalPath() {
        int i;
        float e, l;
        Vertex dest;

        float[] ve = new float[size];
        float[] vl = new float[size];

        // 首先正向推进，将ve全部设置为0
        for (i = 0; i < size; i++) {
            ve[i] = 0.0f;
        }
        for (i = 0; i < size; i++) {
            // 正向传播计算所有事件的可能最早发生时间
            Edge p = nodeTable.get(i).firstNeighbor;
            while (p != null) {
                dest = p.dest;
                if (ve[i] + p.weight > ve[dest.data]) {
                    ve[dest.data] = ve[i] + p.weight;
                }
                p = p.next;
            }
        }

        // 更新vl，全部变为汇点的值
        for (i = 0; i < size; i++) {
            vl[i] = ve[size - 1];
        }

        // 同理方法，反向传播计算
        for (i = size - 2; i >= 0; i--) {
            Edge p = nodeTable.get(i).firstNeighbor;
            while (p != null) {
                dest = p.dest;
                if (vl[dest.data] - p.weight < vl[i]) {
                    vl[i] =vl[dest.data] - p.weight;
                }
                p = p.next;
            }
        }

        // output
        for (i = 0; i < size; i++) {
            Edge p = nodeTable.get(i).firstNeighbor;
            while (p != null) {
                dest = p.dest;
                e = ve[i];
                l = vl[dest.data] - p.weight;
                // l == e 代表是关键路径上的一点
                if (l == e) {
                    criticalPath.add(nodeTable.get(i));
                }
                p = p.next;
            }
        }
    }
    
}
