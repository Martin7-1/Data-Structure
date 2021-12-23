package com.nju.edu.tree;

public class MakeTree {

    BinaryNode<Character> root;

    public MakeTree(String pre, String in) {
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
            node = new BinaryNode<>(pre.charAt(0));
            // 找到中序遍历里的根节点
            while (in.charAt(inPos) != pre.charAt(0)) {
                inPos++;
            }
            // 左子树
            preTemp = pre.substring(1, inPos + 1);
            inTemp = in.substring(0, inPos);
            makeTree(preTemp, inTemp, node.left);

            // 右子树
            preTemp = pre.substring(inPos + 1);
            // 注意这里中序遍历要跳过根节点
            inTemp = in.substring(inPos + 1);
            makeTree(preTemp, inTemp, node.right);
        }
    }
    
}
