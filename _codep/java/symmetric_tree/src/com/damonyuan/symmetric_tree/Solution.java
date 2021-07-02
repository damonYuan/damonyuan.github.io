/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 *}
 */
package com.damonyuan.symmetric_tree;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return mirror(root.left, root.right);
    }

    private boolean mirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }

        if (a != null && b != null && a.val == b.val && mirror(a.left, b.right) && mirror(a.right, b.left)) {
            return true;
        }
        
        return false;
    }
}
