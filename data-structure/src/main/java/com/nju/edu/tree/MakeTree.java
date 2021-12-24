package com.nju.edu.tree;

import java.util.ArrayList;
import java.util.List;

public class MakeTree {

    BinaryNode<Character> root;

    public MakeTree(String pre, String in) {
        root = new BinaryNode<>();
        makeTree(pre, in, root);
    }

    private void makeTree(String pre, String in, BinaryNode<Character> node) {
        int inPos = 0;
        String preTemp;
        String inTemp;

        if (pre.length() == 0) {
            node = null;
            return;
        } else {
            // 必须先让root指向一个对象，否则传进来的引用新建对象是无法被root所指到的
            node.element = pre.charAt(0);
            // 找到中序遍历里的根节点
            while (in.charAt(inPos) != pre.charAt(0)) {
                inPos++;
            }
            // 左子树
            preTemp = pre.substring(1, inPos + 1);
            inTemp = in.substring(0, inPos);
            if (preTemp.length() != 0) {
                node.left = new BinaryNode<>();
            }
            makeTree(preTemp, inTemp, node.left);

            // 右子树
            preTemp = pre.substring(inPos + 1);
            // 注意这里中序遍历要跳过根节点
            inTemp = in.substring(inPos + 1);
            if (preTemp.length() != 0) {
                node.right = new BinaryNode<>();
            }
            makeTree(preTemp, inTemp, node.right);
        }
    }

    /**
     * 后序遍历，测试方法
     * 
     * @return
     */
    public List<Character> postorderTraverse() {
        List<Character> ans = new ArrayList<>();
        postorderTraverse(root, ans);
        return ans;
    }

    /**
     * 后序遍历的递归方法
     * 
     * @param node 当前遍历的节点
     * @param list 后序遍历存储的list
     */
    private void postorderTraverse(BinaryNode<Character> node, List<Character> list) {
        if (node == null) {
            return;
        }

        postorderTraverse(node.left, list);
        postorderTraverse(node.right, list);
        list.add(node.element);
    }

}
