//Problem Name: Next Right Node
//Problem Link: https://www.geeksforgeeks.org/problems/next-right-node/1 

class Solution {
    Node nextRightNode(Node root, int key) {
        Node ans = new Node(-1);
        if(root == null) return ans;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int sz = q.size();
            List<Node> level = new ArrayList<>();
            for(int i = 0;i<sz;i++) {
                Node node = q.poll();
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
                level.add(node);
            }
            Node[] newLevel = level.stream().toArray(Node[]::new);
            int ind = -1;
            for(int i = 0;i<newLevel.length;i++){
                if(newLevel[i].data == key) {
                    ind = i;
                    break;
                }
            }
            if(ind>-1 && ind+1<newLevel.length) {
                ans = newLevel[ind+1];
                break;
            }
        }
        return ans;
    }
    Node nextRight(Node root, int key) {
        return nextRightNode(root, key);
    }
}