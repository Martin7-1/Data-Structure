package com.nju.edu.list;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class LinkedListTest {

    private static MyLinkedList linkedList;
    private static List<Integer> expect;
    private static List<Integer> actual;

    @BeforeClass
    public static void setUp() {
        expect = new ArrayList<>();
        actual = new ArrayList<>();
    }

    @Test
    public void test1() {
        linkedList = new MyLinkedList();
        expect.clear();
        actual.clear();
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.addAtIndex(3, 0);
        linkedList.deleteAtIndex(2);
        linkedList.addAtHead(6);
        linkedList.addAtTail(4);
        int actual = linkedList.get(4);
        linkedList.addAtHead(4);
        linkedList.addAtIndex(5, 0);
        linkedList.addAtHead(6);
        int expect = 4;

        assertEquals(expect, actual);
    }

    @Test
    public void test2() {
        linkedList = new MyLinkedList();
        expect.clear();
        actual.clear();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);
        actual.add(linkedList.get(1));
        linkedList.deleteAtIndex(0);
        actual.add(linkedList.get(0));

        expect.add(2);
        expect.add(2);

        for (int i = 0; i < expect.size(); i++) {
            assertEquals(expect.get(i), actual.get(i));
        }
    }

    @Test
    public void test3() {
        linkedList = new MyLinkedList();
        expect.clear();
        actual.clear();
        linkedList.addAtIndex(0, 10);
        linkedList.addAtIndex(0, 20);
        linkedList.addAtIndex(1, 30);
        int actual = linkedList.get(0);

        assertEquals(20, actual);
    }

    @Test
    public void test4() {
        linkedList = new MyLinkedList();
        expect.clear();
        actual.clear();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1, 2);
        actual.add(linkedList.get(1));
        linkedList.deleteAtIndex(1);
        actual.add(linkedList.get(1));
        actual.add(linkedList.get(3));
        linkedList.deleteAtIndex(3);
        linkedList.deleteAtIndex(0);
        actual.add(linkedList.get(0));
        linkedList.deleteAtIndex(0);
        actual.add(linkedList.get(0));

        expect.add(2);
        expect.add(3);
        expect.add(-1);
        expect.add(3);
        expect.add(-1);

        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expect.get(i), actual.get(i));
        }
    }
    
}
