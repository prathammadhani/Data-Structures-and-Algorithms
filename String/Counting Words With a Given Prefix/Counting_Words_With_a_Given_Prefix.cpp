// Problem Name: Counting Words With a Given Prefix
// Problem Link: https://leetcode.com/problems/counting-words-with-a-given-prefix/description/ 

// Approach - 1: Brute Force
class Solution {
public:
    int prefixCount(vector<string>& words, string pref) {
        int n = words.size();
        int m = pref.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = 0, k = 0;
            bool flag = true;
            if (words[i].size() >= pref.size()) {
                while (j < words[i].size() && k < pref.size()) {
                    if (words[i][j] != pref[k]) {
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
};

// Approach - 2: Built-In Methods
class Solution {
public:
    int prefixCount(vector<string>& words, string pref) {
        int ans = 0;
        int n = words.size();
        for (int i = 0; i < n; i++) {
            if (words[i].substr(0, pref.size()) == pref)
                ans++;
        }
        return ans;
    }
};

// Approach - 3: Trie
class Node {
public:
    Node* links[26];
    int countPrefix = 0;
    bool flag = false;

    bool containsKey(char ch) {
        return (links[ch-'a'] != NULL);
    }

    Node* get(char ch) {
        return links[ch-'a'];
    }

    void put(char ch, Node* node) {
        links[ch-'a'] = node;
    }

    void setEndFlag() {
        flag = true;
    }

    bool isEnd() {
        return flag;
    }

    void increasePrefixCount() {
        countPrefix++;
    }
};

class Trie {
private: Node* root;
public:
    Trie() {
        root = new Node();
    }
    
    void insert(string& word) {
        Node* node = root;
        for(int i = 0;i<word.size();i++) {
            if(!node->containsKey(word[i])) {
                node->put(word[i],new Node());
            }
            node = node->get(word[i]);
            node->increasePrefixCount();
        }
        node->setEndFlag();
    }

    int getPrefixCount(string& prefix) {
        Node* node = root;
        for(int i = 0;i<prefix.size();i++) {
            if(node->containsKey(prefix[i])) {
                node = node->get(prefix[i]);
            } else {
                return 0;
            }
        }
        return node->countPrefix;
    }
};

class Solution {
public:
    int prefixCount(vector<string>& words, string pref) {
        Trie* trie = new Trie();
        for(string word : words) {
            trie->insert(word);
        }
        return trie->getPrefixCount(pref);
    }
};