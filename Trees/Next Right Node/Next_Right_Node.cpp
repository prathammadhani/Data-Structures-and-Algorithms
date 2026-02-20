//Problem Name: Next Right Node
//Problem Link: https://www.geeksforgeeks.org/problems/next-right-node/1 

class Solution {
  public:
    Node* nextRightNode(Node *root, int key) {
        Node* ans = new Node(-1);
        if(root == NULL) return ans;
        queue<Node*> q;
        q.push(root);
        while(!q.empty()) {
            int sz = q.size();
            vector<Node*> level;
            for(int i = 0;i<sz;i++) {
                Node* node = q.front();
                q.pop();
                if(node->left!=NULL) q.push(node->left);
                if(node->right!=NULL) q.push(node->right);
                level.push_back(node);
            }
            int ind = -1;
            for(int i = 0;i<level.size();i++) {
                Node* temp = level[i];
                if(temp->data == key) {
                    ind = i;
                    break;
                }
            }
            if(ind>-1 && ind+1<level.size()) {
                ans = level[ind+1];
                break;
            }
        }
        return ans;
    }
    Node *nextRight(Node *root, int key) {
        // code here
        return nextRightNode(root, key);
    }
};