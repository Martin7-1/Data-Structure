package com.nju.edu.list;

import java.util.ArrayList;
import java.util.List;

public class Joseph {

    /**
     * 约瑟夫问题的链表模拟解法
     * @param n 总人数
     * @param m 报数的数
     * @return 每一次被淘汰的人，第n个元素是剩下的人
     */
    public List<Integer> josephProblem(int n, int m) {
        List<Integer> ans = new ArrayList<>();
        ListNode head = initList(n);
        ListNode temp = head;
        int count;

        for (int i = 0; i < n - 1; i++) {
            count = 1;
            while (count != m - 1) {
                temp = temp.next;
                count++;
            }

            // 删除temp.next
            // 下一次从temp.next开始计数
            ans.add(temp.next.val);
            temp.next = temp.next.next;
            temp = temp.next;
        }

        ans.add(temp.val);

        return ans;
    }

    /**
     * 生成个数为n的循环链表
     * @param number 链表的节点数
     * @return 第一个节点
     */
    private ListNode initList(int number) {
        ListNode head = new ListNode(1);
        ListNode temp = head;

        for (int i = 2; i <= number; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        // 连接最后一个节点和头节点
        temp.next = head;

        return head;
    }
    
}
