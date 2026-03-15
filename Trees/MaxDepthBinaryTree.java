Problem Statement

Given the root of a binary tree,
return its maximum depth.

Depth = number of nodes along the longest path from root to leaf.

Example
Input Tree:

      3
     / \
    9   20
       /  \
      15   7

Output:

3

Key Idea

Depth of tree =
1 + max(depth(left), depth(right))
We compute depth recursively.




class MaxDepthBinaryTree {

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}


TreeNode Class
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

Complexity

Time → O(n)
Space → O(h) (height of tree)




