package com.nju.edu.tree;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * 根据前序遍历和中序遍历来生成一棵二叉树
 * @author Martin
 */
public class MakeTreeTest {

    String pre;
    String in;
    MakeTree tree;
    String expect;
    String actual;

    @Test
    public void makeTreeTest1() {
        pre = "ABDCEGFHI";
        in = "DBAEGCHFI";
        tree = new MakeTree(pre, in);

        // 根据后序遍历来比对
        // 转换一个character的list到string
        List<Character> chars = tree.postorderTraverse();
        actual = chars.stream().map(String::valueOf).collect(Collectors.joining());
        expect = "DBGEHIFCA";

        assertEquals(expect, actual);
    }

    @Test
    public void makeTreeTest2() {
        pre = "ABCDEFG";
        in = "CBEDGFA";
        tree = new MakeTree(pre, in);

        // 根据后序遍历来比对
        // 转换一个character的list到string
        List<Character> chars = tree.postorderTraverse();
        actual = chars.stream().map(String::valueOf).collect(Collectors.joining());
        expect = "CEGFDBA";

        assertEquals(expect, actual);
    }
    
}
