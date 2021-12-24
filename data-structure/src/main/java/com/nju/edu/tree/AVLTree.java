package com.nju.edu.tree;

import java.util.ArrayList;
import java.util.List;

public class AVLTree {
    private AVLNode root;

    public AVLTree() {
        this.root = null;
    }

    /**
     * 在AVL树中插入一个节点，注意调整高度
     * @param val 要插入的节点的值
     */
    public void insert(int val) {
        root = insert(val, root);
    }

    /**
     * 在AVL树中删除一个节点，注意调整高度
     * @param val 要删除的节点的值
     */
    public void remove(int val) {
        root = remove(val, root);
    }

    /**
     * test method
     * @return 中序遍历的顶点顺序
     */
    public List<Integer> inorderTraverse() {
        List<Integer> list = new ArrayList<>();
        inorderTraverse(list, root);

        return list;
    }

    /**
     * test method
     * @param list 中序遍历的顶点顺序
     * @param node 当前节点
     */
    private void inorderTraverse(List<Integer> list, AVLNode node) {
        if (node == null) {
            return;
        }

        inorderTraverse(list, node.left);
        list.add(node.element);
        inorderTraverse(list, node.right);
    }

    /**
     * 私有的插入方法，用于在AVL树中插入一个节点
     * @param val 要插入的节点的值
     * @param node 当前节点
     */
    private AVLNode insert(int val, AVLNode node) {
        if (node == null) {
            node = new AVLNode(val);
        } else if (node.element > val) {
            // 此时说明新建的节点应该在node的左子树上
            node.left = insert(val, node.left);
            // 判断高度并调整
            if (AVLNode.getHeight(node.left) - AVLNode.getHeight(node.right) > 1) {
                // 说明我们需要调整高度
                // 判断时左内还是左外，这决定了我们是要用单旋还是双旋
                if (node.left.element > val) {
                    // 说明是左外
                    node = rotateWithLeftChild(node);
                } else {
                    node = doubleRotateWithLeftChild(node);
                }
            }
        } else if (node.element < val) {
            // 此时说明插入的节点应该在node的右子树上
            node.right = insert(val, node.right);
            // 调整高度
            if (AVLNode.getHeight(node.right) - AVLNode.getHeight(node.left) > 1) {
                // 调整高度
                if (node.right.element < val) {
                    // 右外
                    node = rotateWithRightChild(node);
                } else {
                    node = doubleRotateWithRightChild(node);
                }
            }
        }

        // 更新高度
        node.setHeight(Math.max(AVLNode.getHeight(node.left), AVLNode.getHeight(node.right)) + 1);
        return node;
    }

    /**
     * 左单旋, 适用于左外的场景
     * @param node 要旋转的节点
     */
    private AVLNode rotateWithLeftChild(AVLNode node) {
        AVLNode temp = node.left;
        node.left = temp.right;
        temp.right = node;

        // 调整高度

        node.setHeight(Math.max(AVLNode.getHeight(node.right), AVLNode.getHeight(node.left)) + 1);
        temp.setHeight(Math.max(AVLNode.getHeight(temp.left), AVLNode.getHeight(node)) + 1);

        return temp;
    }

    /**
     * 左双旋，适用于左内的场景
     * @param node 要旋转的节点
     */
    private AVLNode doubleRotateWithLeftChild(AVLNode node) {
        // 其实是一次右单旋 + 一次左单旋
        node.left = rotateWithRightChild(node.left);
        return rotateWithLeftChild(node);
    }

    /**
     * 右单旋，适用于右外的场景
     * @param node 要旋转的节点
     */
    private AVLNode rotateWithRightChild(AVLNode node) {
        AVLNode temp = node.right;
        node.right = temp.left;
        temp.left = node;

        // 更新高度
        // 高度的获得我们可以递归获得
        node.setHeight(Math.max(AVLNode.getHeight(node.left), AVLNode.getHeight(node.right)) + 1);
        temp.setHeight(Math.max(AVLNode.getHeight(temp.right), AVLNode.getHeight(node)) + 1);

        return temp;
    }

    /**
     * 右内旋，其实是一次左单旋 + 右单旋
     * @param node 要旋转的节点
     */
    private AVLNode doubleRotateWithRightChild(AVLNode node) {
        node.right = rotateWithLeftChild(node.right);

        return rotateWithRightChild(node);
    }

    /**
     * AVL树的删除
     * @param val 要删除的节点的值
     * @param node 当前的节点
     */
    private AVLNode remove(int val, AVLNode node) {
        // 与二叉搜索树一样有三种情况
        // 分别是删叶子节点，单个子节点，两个子节点
        return null;
    }
}