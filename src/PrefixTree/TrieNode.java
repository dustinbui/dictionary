/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrefixTree;

/**
 *
 * @author Anh Bui
 */
public class TrieNode {

    char letter;
    TrieNode[] links;
    boolean fullWord;

    public TrieNode(char letter) {
        this.letter = letter;
        fullWord = false;
        links = new TrieNode[123];
    }
}
