Problem Statement

Given the root of a binary tree, determine if it is height-balanced.
A binary tree is balanced if:
| heiht(left subtree) - height(right subtree) | ≤ 1

for every node.

Example (Balanced)
        3
       / \
      9   20
         /  \
        15   7

Output:true
Example (Not Balanced)
        1
       /
      2
     /
    3

Output:false

 Key Idea

At every node we check:

height(left)
height(right)

If the difference is greater than 1, the tree is not balanced.

 Optimization Trick
Instead of calculating height separately many times,
we combine balance check + height calculation in one DFS.

Return:-1  → tree is not balanced
height → if balanced


CODE----->>>>>

class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int left = height(node.left);
        if (left == -1) return -1;

        int right = height(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) {
            return -1;
        }
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

        return 1 + Math.max(left, right);
    }
}

Complexity-
Time Complexity:O(n)
Space Complexity:O(h)

Where:
n = nodes
h = tree height
