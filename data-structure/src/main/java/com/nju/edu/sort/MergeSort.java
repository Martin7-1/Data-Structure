package com.nju.edu.sort;

import java.util.List;
import java.util.ArrayList;

public class MergeSort implements Sort{
    
    private int[] arr;
    private List<Integer> list = new ArrayList<>();

    public MergeSort(List<Integer> list) {
        arr = list.stream().mapToInt(Integer::intValue).toArray();
    }

    public MergeSort(int len) {
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
        int[] tempArr = new int[arr.length];
        mergeSort(arr, tempArr, 0, arr.length - 1);
    }

    @Override
    public void sort(int[] arr) {
        int[] tempArr = new int[arr.length];
        mergeSort(arr, tempArr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int[] tempArr, int left, int right) {
        // 分而治之
        if (left < right) {
            int center = (right + left) / 2;
            mergeSort(arr, tempArr, left, center);
            mergeSort(arr, tempArr, center + 1, right);
            // 将排好序的两段合并
            merge(arr, tempArr, left, center + 1, right);
        }
    }

    private void merge(int[] arr, int[] tempArr, int left, int right, int rightEnd) {
        int leftEnd = right - 1;
        int tempPos = left;
        int elementNumber = rightEnd - left + 1;
        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] < arr[right]) {
                // 此时说明应该将左半边的元素先放入暂存的数组中
                tempArr[tempPos++] = arr[left++];
            } else {
                tempArr[tempPos++] = arr[right++];
            }
        }

        // 此时是右半部分已经都拷贝完的情况
        while (left <= leftEnd) {
            tempArr[tempPos++] = arr[left++];
        }
        // 此时是左半部分已经都拷贝完的情况
        while (right <= rightEnd) {
            tempArr[tempPos++] = arr[right++];
        }

        // 将暂存数组拷贝回arr
        for (int i = 0; i < elementNumber; i++, rightEnd--) {
            arr[rightEnd] = tempArr[rightEnd];
        }
    }

    public int[] getArr() {
        return this.arr;
    }
}
