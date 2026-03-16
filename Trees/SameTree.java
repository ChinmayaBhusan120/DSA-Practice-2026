Problem Statement

Given the roots of two binary trees p and q, determine whether they are identical.

Two trees are considered the same if:
They have the same structure
Nodes ave the same values

Example

Tree 1

    1
   / \
  2   3

Tree 2

    1
   / \
  2   3

Output:

true


Key Idea

We compare both trees recursively.
At every step:
If both nodes are null → same
If one is null → not same
If values differ → not same

Recursively check:
left subtree
right subtree



CODE-------

class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}


Complexity

Time Complexity:O(n)
Space Complexity:O(h)

Where:
n = number of nodes
h = height of tree



