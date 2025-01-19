// Problem Name: Complete String
// Problem Link: https://www.naukri.com/code360/problems/complete-string_2687860

#include <bits/stdc++.h> 
class Node {
public:
    Node* links[26];
    bool flag = false;

    bool containsKey(char ch) {
        return links[ch - 'a'] != NULL;
    }

    Node* get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node* node) {
        links[ch - 'a'] = node;
    }

    void setFlag() {
        flag = true;
    }

    bool isEnd() {
        return flag;
    }
};

class Trie {
private:
    Node* root;
public:
    Trie() {
        root = new Node();
    }

    void insert(string word) {
        Node* node = root;
        for(int i = 0;i<word.size();i++) {
            if(!node->containsKey(word[i])) {
                node->put(word[i], new Node());
            }
            node = node->get(word[i]);
        }
        node->setFlag();
    }

    bool search(string word) {
        Node* node = root;
        for(int i = 0;i<word.size();i++) {
            if(node->containsKey(word[i])) {
                node = node->get(word[i]);
                if(!node->isEnd()) return false;
            } else {
                return false;
            }
        }
        return true;
    }
};

string completeString(int n, vector<string> &a){
    Trie trie;
    for(int i = 0;i<a.size();i++) {
        trie.insert(a[i]);
    }

    string ans = "";
    for(int i = 0;i<a.size();i++) {
        if(trie.search(a[i])) {
            if(a[i].size()>ans.size() || (a[i].size() == ans.size() && a[i]<ans)) {
                ans = a[i];
            }
        }
    }
    return (ans=="") ? "None" : ans; 
}