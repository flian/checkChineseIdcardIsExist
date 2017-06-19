package org.foy.ds;

/**
 * 简单的构建字典树的栗子:大概10s左右
 * User: Foy Lian
 * Date: 2017-06-19
 * Time: 8:53
 */
public class TrieTree {
    final int MAX_SIZE = 11;//[0-9,x]身份证一共就0-9,和x
    public TrieTreeNode root;

    public class TrieTreeNode {
        int nCount;//记录该字符出现次数
        char ch; //记录该字符
        TrieTreeNode[] child;

        public TrieTreeNode() {
            nCount = 1;
            child = new TrieTreeNode[MAX_SIZE];
        }

    }

    private int letterPos(char c) {
        if ('x' == c || 'X' == c) {
            return 10;
        }
        return c - '0';
    }

    //字典树的插入和构建
    public void createTrie(TrieTreeNode node, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        char[] letters = str.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int pos = letterPos(letters[i]);
            if (node.child[pos] == null) {
                node.child[pos] = new TrieTreeNode();
            } else {
                node.child[pos].nCount++;
            }
            node.ch = letters[i];
            node = node.child[pos];
        }
    }

    //字典树的查找
    public int findCount(TrieTreeNode node, String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        char[] letters = str.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int pos = letterPos(letters[i]);
            if (node.child[pos] == null) {
                return 0;
            } else {
                node = node.child[pos];
            }
        }
        return node.nCount;
    }

}
