/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //    4  
    //   2 7  
    // 3 1 9 6 
    
    //       4  
    //     7   2  
    //   1  3    6  9 
    // 7 6 2 3  7 8 9 2 

    // Recursively replace left subtree with the right subtree
    public TreeNode invertTree(TreeNode root) {
        // Base case, no node
        if (root == null) return root;
        // Recursively swap children
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}