package com.nju.edu.sort;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class InsertionSortTest {

    int[] expect;
    int[] actual;
    private InsertionSort sort;

    @Test
    public void test1() {
        List<Integer> temp = Arrays.asList(46, 13, 55, 42, 94, 5, 17, 70, 82, 100);
        sort = new InsertionSort(temp);
        sort.sort();

        expect = Arrays.asList(5, 13, 17, 42, 46, 55, 70, 82, 94, 100).stream().mapToInt(Integer::intValue).toArray();
        actual = sort.getArr();

        assertArrayEquals(expect, actual);
    }

    @Test
    public void test2() {
        List<Integer> temp = Arrays.asList(87, 65, 21, 100, 120, 54, 165, 44, 32, 850, 121, 1, 23, 77);
        sort = new InsertionSort(temp);
        sort.sort();

        expect = Arrays.asList(1, 21, 23, 32, 44, 54, 65, 77, 87, 100, 120, 121, 165, 850).stream().mapToInt(Integer::intValue).toArray();
        actual = sort.getArr();

        assertArrayEquals(expect, actual);
    }
    
    @Test
    public void randomSortTest() {
        Random random = new Random();
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < 5000; i++) {
            int len = random.nextInt(100000);
            for (int j = 0; j < len; j++) {
                temp.add(random.nextInt(Integer.MAX_VALUE));
            }
            sort = new InsertionSort(temp);

            System.out.println();
            expect = temp.stream().mapToInt(Integer::intValue).toArray();
            Arrays.sort(expect);
            System.out.println("my insertion sort start time = " + System.currentTimeMillis());
            sort.sort();
            System.out.println("my insertion sort end time = " + System.currentTimeMillis());
            System.out.println();
            actual = sort.getArr();

            assertArrayEquals(expect, actual);
            temp.clear();
        }
    }
    
}
