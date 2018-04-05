/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrefixTree;

import java.util.ArrayList;

/**
 *
 * @author Anh Bui
 */
public class PrefixTree {

    private TrieNode curNode;
    private ArrayList a;                                                        // Lưu trữ kết quả từ gợi ý

    public void createA() {
        a = new ArrayList();
    }

    public TrieNode getCurNode() {                                              // Nút hiện tại sau khi dùng phương thức find 
        return this.curNode;                                                    // thuận tiện cho việc in ra kết quả gợi ý
    }

    public void insertWord(TrieNode root, String word) {                        // create tree
        char[] letters = word.toCharArray();
        curNode = root;
        for (int i = 0; i < letters.length; i++) {
            if (curNode.links[letters[i]] == null) {
                curNode.links[letters[i]] = new TrieNode(letters[i]);
            }
            curNode = curNode.links[letters[i]];
        }
        curNode.fullWord = true;
    }

    public boolean find(TrieNode root, String word) { // search
        char[] letters = word.toCharArray();
        curNode = root;
        for (int i = 0; i < letters.length; i++) {
            if (curNode.links[letters[i]] == null) {
                return false;
            }
            curNode = curNode.links[letters[i]];
        }
        return true;
    }

    public ArrayList result(TrieNode root, int level, char[] branch, String search) {
        if (root == null) {
            return a;
        }
        for (int i = 0; i < root.links.length; i++) {
            branch[level] = root.letter;
            result(root.links[i], level + 1, branch, search);
        }
        if (root.fullWord) {
            String s = search;
            for (int i = 1; i <= level; i++) {
                s = s + branch[i];
            }
            a.add(s);
        }
        return a;
    }
}
