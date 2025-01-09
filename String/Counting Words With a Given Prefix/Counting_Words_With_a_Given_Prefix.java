// Problem Name: Counting Words With a Given Prefix
// Problem Link: https://leetcode.com/problems/counting-words-with-a-given-prefix/description/ 

// Approach - 1: Brute Force
class Solution {
    public int prefixCount(String[] words, String pref) {
        int n = words.length;
        int m = pref.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = 0, k = 0;
            boolean flag = true;
            if (words[i].length() >= m) {
                while (j < words[i].length() && k < m) {
                    if (words[i].charAt(j) != pref.charAt(k)) {
                        flag = false;
                        break;
                    }
                    j++;
                    k++;
                }
                if (flag)
                    ans++;
            }
        }
        return ans;
    }
}

// Approach - 2: Built-In Methods
class Solution {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                ans++;
            }
        }
        return ans;
    }
}

// Approach - 3: Trie
class Node {

    Node[] links = new Node[26];
    int countPrefix = 0;
    boolean flag = false;

    public boolean containsKey(Character ch) {
        return (links[ch - 'a'] != null);
    }

    public Node get(Character ch) {
        return links[ch - 'a'];
    }

    public void put(Character ch, Node node) {
        links[ch - 'a'] = node;
    }

    public void setEndFlag() {
        flag = true;
    }

    public boolean isEnd() {
        return flag;
    }

    public void increasePrefixCount() {
        countPrefix++;
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
            if(node.containsKey(word.charAt(i)) == false) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
            node.increasePrefixCount();
        }
        node.setEndFlag();
    }

    public int getPrefixCount(String prefix) {
        Node node = root;
        for(int i = 0;i<prefix.length();i++) {
            if(node.containsKey(prefix.charAt(i)) == false) {
                return 0;
            }
            node = node.get(prefix.charAt(i));
        }
        return node.countPrefix;
    }
}

class Solution {
    public int prefixCount(String[] words, String pref) {
        Trie trie = new Trie();
        for(String word : words) {
            trie.insert(word);
        }
        return trie.getPrefixCount(pref);
    }
}