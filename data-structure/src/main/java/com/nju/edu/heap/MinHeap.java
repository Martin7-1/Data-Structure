package com.nju.edu.heap;

public class MinHeap {
    
    private static final int DEFAULT_CAPACITY = 100;
    private int curSize;
    private int[] arr;


    public MinHeap() {
        this(DEFAULT_CAPACITY);
    }

    public MinHeap(int capacity) {
        // 堆顶从索引1开始
        this.arr = new int[capacity + 1];
        curSize = 0;
    }

    public void insert(int val) throws OverflowException {
        if (isFull()) {
            throw new OverflowException("the capacity is full!");
        }
        int hole = ++curSize;
        for (; hole > 1 && val < arr[hole / 2]; hole /= 2) {
            // 不断寻找父节点
            // 上滤
            arr[hole] = arr[hole / 2];
        }
        arr[hole] = val;
    }

    public int findMin() {
        return arr[1];
    }

    public int deleteMin() {
        if (isEmpty()) {
            return -1;
        }

        int minValue = findMin();
        // 将完全二叉树
        arr[1] = arr[curSize--];
        percolateDown(1);
        return minValue;
    }

    public boolean isEmpty() {
        return curSize == 0;
    }

    public boolean isFull() {
        return curSize == arr.length - 1;
    }

    public void makeEmpty() {
        curSize = 0;
    }

    /**
     * 堆的下滤操作
     * @param hole 洞
     */
    private void percolateDown(int hole) {
        int child;
        int temp = arr[hole];
        for (; 2 * hole <= curSize; hole = child) {
            child = hole * 2;
            // 需要比较左子树和右子树哪个比较小
            // 下滤需要替换小的
            // 但要判断有没有右子树
            if (child != curSize && arr[child + 1] < arr[child]) {
                child++;
            }
            if (arr[child] < arr[hole]) {
                arr[hole] = arr[child];
            } else {
                // 说明已经到了该到的位置
                break;
            }
        }
        arr[hole] = temp;
    }

    /**
     * 逐一插入构建heap
     */
    private void buildHeap() {
        for (int i = curSize / 2; i > 0; i--) {
            percolateDown(i);
        }
    }
}
