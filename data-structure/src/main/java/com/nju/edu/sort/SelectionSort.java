package com.nju.edu.sort;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort implements Sort {
    
    private int[] arr;
    private List<Integer> list = new ArrayList<>();

    public SelectionSort(List<Integer> list) {
        arr = list.stream().mapToInt(Integer::intValue).toArray();
    }

    public SelectionSort(int len) {
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
        selectionSort(arr, arr.length);
        
    }

    @Override
    public void sort(int[] arr) {
        selectionSort(arr, arr.length);
    }

    private void selectionSort(int[] arr, int len) {
        // 每次都选择当前位置的值放到当前位置
        for (int i = 0; i < len - 1; i++) {
            // 我们假设要排序的都是正数
            int minElement = Integer.MAX_VALUE;
            int j = i;
            int index = -1;
            while (j < len) {
                if (arr[j] < minElement) {
                    minElement = arr[j];
                    index = j;
                }
                j++;
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }

    public int[] getArr() {
        return this.arr;
    }
}
