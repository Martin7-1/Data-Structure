package com.nju.edu.sort;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort implements Sort{
    
    private int[] arr;
    private List<Integer> list = new ArrayList<>();

    public InsertionSort(List<Integer> list) {
        arr = list.stream().mapToInt(Integer::intValue).toArray();
    }

    public InsertionSort(int len) {
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
        insertionSort(arr, arr.length);
        
    }

    @Override
    public void sort(int[] arr) {
        insertionSort(arr, arr.length);
    }

    private void insertionSort(int[] arr, int len) {
        // 将某个数插入到它应该插入的位置
        for (int i = 1; i < len; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > temp) {
                // 将比该元素大的元素都往后移动
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public int[] getArr() {
        return this.arr;
    }
}
