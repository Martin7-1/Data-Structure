package com.nju.edu.sort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort implements Sort {

    private int[] arr;
    private List<Integer> list = new ArrayList<>();

    public BubbleSort(List<Integer> list) {
        arr = list.stream().mapToInt(Integer::intValue).toArray();
    }

    public BubbleSort(int len) {
        arr = new int[len];
    }

    /**
     * 添加元素
     * @param element 新的元素
     */
    public void addElement(int element) {
        this.list.add(element);
    }

    /**
     * 停止添加元素
     */
    public void shutdown() {
        arr = list.stream().mapToInt(Integer::intValue).toArray();
    }

    @Override
    public void sort() {
        bubbleSort(arr, arr.length);
        
    }

    @Override
    public void sort(int[] arr) {
        bubbleSort(arr, arr.length);
    }

    private void bubbleSort(int[] arr, int len) {
        for (int i = 0; i < len - 1; i++) {
            // 检查前len-1个元素即可
            // 最后i个元素是已经排序好的
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public int[] getArr() {
        return this.arr;
    }
    
}
