package com.company;

/*
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.


Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 */

class Trie {

    public class TreeNode {
        TreeNode[] children = new TreeNode[26];
        boolean isWord = false;

        public TreeNode() {}

        public void insert(char[] charArray, int pos) {
            if (pos >= charArray.length) {
                isWord = true;
                return;
            }
            int idx = charArray[pos] - 'a';
            if (children[idx] == null) {
                children[idx] = new TreeNode();
            }
            children[idx].insert(charArray, ++pos);
        }

        public boolean search(char[] charArray, int pos) {
            if (pos >= charArray.length) {
                return isWord;
            }
            int idx = charArray[pos] - 'a';
            if (children[idx] == null) {
                return false;
            } else {
                return children[idx].search(charArray, ++pos);
            }
        }

        public boolean startWith(char[] charArray, int pos) {
            if (pos >= charArray.length) {
                return true;
            }
            int idx = charArray[pos] - 'a';
            if (children[idx] == null) {
                return false;
            } else {
                return children[idx].startWith(charArray, ++pos);
            }
        }
    }

    TreeNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        root.insert(word.toCharArray(), 0);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return root.search(word.toCharArray(), 0);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return root.startWith(prefix.toCharArray(), 0);
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insert("apple");
        System.out.println(t.search("apple"));   // return True
        System.out.println(t.search("app"));     // return False
        System.out.println(t.startsWith("app")); // return True
        t.insert("app");
        System.out.println(t.search("app"));     // return True
    }
}