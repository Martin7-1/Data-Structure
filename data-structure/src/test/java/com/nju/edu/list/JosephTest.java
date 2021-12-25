package com.nju.edu.list;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class JosephTest {

    private int[] expect;
    private int[] actual;
    private Joseph test = new Joseph(); 

    @Test
    public void test1() {
        actual = test.josephProblem(8, 3).stream().mapToInt(Integer::intValue).toArray();
        List<Integer> ans = Arrays.asList(3, 6, 1, 5, 2, 8, 4, 7);
        expect = ans.stream().mapToInt(Integer::intValue).toArray();

        assertArrayEquals(expect, actual);
    }

    @Test
    public void test2() {
        actual = test.josephProblem(9, 5).stream().mapToInt(Integer::intValue).toArray();
        List<Integer> ans = Arrays.asList(5, 1, 7, 4, 3, 6, 9, 2, 8);
        expect = ans.stream().mapToInt(Integer::intValue).toArray();

        assertArrayEquals(expect, actual);
    }
}
