package com.nju.edu.list;

public class MyLinkedList {
    
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode() {
            this(0, null);
        }

        public ListNode(int val) {
            this(val, null);
        }
    }

    ListNode head;
    int curLen;

    public MyLinkedList() {
        // 初始化，这里的head是一个头指针
        head = new ListNode();
        curLen = 0;
    }
    
    public int get(int index) {
        // 获得索引为index的节点的值
        // 如果索引 >= curLen 说明无效
        if (index >= curLen || index < 0) {
            return -1;
        }

        int count = 0;
        // temp指向索引为0的节点
        ListNode temp = head.next;
        while (count < index && temp.next != null) {
            temp = temp.next;
            count++;
        }

        return temp.val;
    }
    
    public void addAtHead(int val) {
        // 在头指针之后加一个节点即可
        ListNode node = new ListNode(val, head.next);
        head.next = node;
        curLen++;
    }
    
    public void addAtTail(int val) {
        // 在尾部加一个节点
        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = new ListNode(val);
        curLen++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index == curLen) {
            addAtTail(val);
            curLen++;
            return;
        } else if (index <= 0) {
            addAtHead(val);
            curLen++;
            return;
        } else if (index > curLen) {
            // 无效的插入
            return;
        }

        int count = 0;
        // 我们需要获得的是index-1的节点
        ListNode temp = head.next;

        while (count < index - 1) {
            temp = temp.next;
            count++;
        }

        ListNode node = new ListNode(val, temp.next);
        temp.next = node;
        curLen++;
    }
    
    public void deleteAtIndex(int index) {
        // 我们需要获得的同样是index-1的节点
        if (index >= curLen || index < 0) {
            return;
        }

        // 判断要删除的是不是头节点
        if (index == 0) {
            head.next = head.next.next;
            curLen--;
            return;
        }

        int count = 0;
        ListNode temp = head.next;

        while (count < index - 1) {
            temp = temp.next;
            count++;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        } else {
            // 删除最后一个节点
            temp.next = null;
        }
        curLen--;
    }
}
