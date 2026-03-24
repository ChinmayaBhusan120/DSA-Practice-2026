
Problem Statement

Given a binary tree and two nodes p and q,
find their Lowest Common Ancestor (LCA).

The LCA is the lowest node in the tree that has both p and q as descendants.

Example

Tree:

        3
       / \
      5   1
     / \ / \
    6  2 0  8
      / \
     7   4

Example 1:

p = 5
q = 1

Output:3

Example 2:
p = 5
q = 4

Output 5
🧠 Key Idea

We traverse the tree using DFS recursion.

At each node:

1️⃣ If node is null → return null
2️⃣ If node equals p or q → return node
3️⃣ Recursively search left and right subtree

Cases
If left ≠ null AND right ≠ null → current node is LCA
If only one side returns a node → return that node



class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
Time Complexity:O(n)
Space Complexity:O(h)

Where:
n = number of nodes
h = tree height
