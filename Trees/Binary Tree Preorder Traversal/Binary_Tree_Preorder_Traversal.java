//Problem Name: Binary Tree Preorder Traversal
//Problem Link: https://leetcode.com/problems/binary-tree-preorder-traversal/description/

//Approach-1: Recursive
class Solution {
    public void dfsTraversal(TreeNode root, List<Integer> ans) {
        if(root == null) return;
        ans.add(root.val);
        dfsTraversal(root.left, ans);
        dfsTraversal(root.right, ans);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfsTraversal(root, ans);
        return ans;
    }
}

//Approach-2: Iterative (using Stack)
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()) {
            TreeNode node = st.pop();
            ans.add(node.val);
            if(node.right!=null) st.push(node.right);
            if(node.left!=null) st.push(node.left);
        }
        return ans;
    }
}