package com.damonyuan.symmetric_tree;

public class Test {
    public static void isSymmetric() {
    	TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        
        Solution s = new Solution();
        boolean result = s.isSymmetric(node);

        System.out.printf("is symmetric: " + result + "\n");
    }
}
