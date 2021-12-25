package com.nju.edu.sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort implements Sort {

    private int[] arr;
    private List<Integer> list = new ArrayList<>();

    public QuickSort(List<Integer> list) {
        arr = list.stream().mapToInt(Integer::intValue).toArray();
    }

    public QuickSort(int len) {
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

    /**
     * 对当前保存的数组进行快速排序
     */
    @Override
    public void sort() {
        quickSort(arr, 0, arr.length - 1);
    }

    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序的私有方法，分而治之的思想
     * @param arr 待排序的数组
     * @param left 分区的左边界(含)
     * @param right 分区的右边界(含)
     */
    private void quickSort(int[] arr, int left, int right) {
        // 首先我们指定一个基准元
        if (left >= right) {
            return;
        }
        int pivot = arr[left];
        int i = left;
        int j = right;
        while (i != j) {
            while (arr[j] > pivot && i < j) {
                j--;
            }
            arr[i] = arr[j];
            while (arr[i] < pivot && i < j) {
                i++;
            }
            arr[j] = arr[i];
        }

        arr[i] = pivot;
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    public int[] getArr() {
        return this.arr;
    }
    
}
