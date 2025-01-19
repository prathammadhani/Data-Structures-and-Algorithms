// Problem Name: Complete String
// Problem Link: https://www.naukri.com/code360/problems/complete-string_2687860

import java.util.*;
import java.io.*; 

class Node {
  public Node[] links = new Node[26];
  public boolean flag = false;

  public boolean containsKey(Character ch) {
    return links[ch - 'a'] != null;
  }

  Node get(Character ch) {
    return links[ch - 'a'];
  }

  public void put(Character ch, Node node) {
    links[ch - 'a'] = node;
  }

  public void setFlag() {
    flag = true;
  }

  public boolean isEnd() {
    return flag;
  }
}

class Trie {
  private Node root;

  Trie() {
    root = new Node();
  }

  public void insert(String word) {
    Node node = root;
    for(int i = 0;i<word.length();i++) {
      if(!node.containsKey(word.charAt(i))) {
        node.put(word.charAt(i), new Node());
      }
      node = node.get(word.charAt(i));
    }
    node.setFlag();
  }

  public boolean checkIfPrefixExist(String word) {
    Node node = root;
    for(int i = 0;i<word.length();i++) {
      if(node.containsKey(word.charAt(i))) {
        node = node.get(word.charAt(i));
        if(!node.isEnd()) return false;
      } else {
        return false;
      }
    }
    return true;
  }
}
class Solution {

  public static String completeString(int n, String[] a) {
    Trie trie = new Trie();
    for(int i = 0;i<a.length;i++) {
      trie.insert(a[i]);
    }

    String ans = "";
    for(int i = 0;i<a.length;i++) {
      if(trie.checkIfPrefixExist(a[i])) {
        if(a[i].length() > ans.length()) {
          ans = a[i];
        } else if (a[i].length() == ans.length() && a[i].compareTo(ans)<0) {
          ans = a[i];
        }
      }
    }

    return (ans == "") ? "None" : ans;
  }
}