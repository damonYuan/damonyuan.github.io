#include <stdio.h>
#include "SymmetricTree.h"

int main(int argc, char *argv[]) {
    TreeNode root;
    root.val = 1;
    TreeNode left;
    left.val = 2;
    left.left = NULL;
    left.right = NULL;
    TreeNode right;
    right.val = 2;
    right.left = NULL;
    right.right = NULL;
    root.left = &left;
    root.right = &right;

    if (isSymmetric(&root))
    {
    	printf("isSymmetric: true \n");
    } else {
    	printf("isSymmetric: false \n");
    }
    return(0);
}
