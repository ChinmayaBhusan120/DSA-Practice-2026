Problem Statement

Given the root of a binary tree and an integer targetSum,
return true if the tree has a root-to-leaf path such that:

sum of node values = targetSum
Otherwise return false.

Example

Tree:

        5
       / \
      4   8
     /   / \
    11  13  4
   /  \
  7    2

Target Sum:22

Valid path:5 → 4 → 11 → 2

Output:true
 Key Idea

We use DFS recursion.
At each node: remainingSum = targetSum - node.val

If we reach a leaf node and:
remainingSum == node.val
Then a valid path exists.

 Algorithm
if node is null → return false
if leaf node AND node.val == targetSum
    return true

return check left subtree OR right subtree




CODE------>>>>>>>


class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        int remaining = targetSum - root.val;

        return hasPathSum(root.left, remaining) ||
               hasPathSum(root.right, remaining);
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
h = tree height
