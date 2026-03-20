Problem Statement

The diameter of a binary tree is the length of the longest path between any two nodes in the tree.
The path may or may not pass through the root.

Example
        1
       / \
      2   3
     / \
    4   5

Longest path:

4 → 2 → 1 → 3

Diameter =3 edges
  
 Key Idea

At every node:
              diameter = height(left) + height(right)

We compute height using DFS recursion.

While computing height we update the maximum diameter.

 Important Trick

Height function returns: 1 + max(leftHeight, rightHeight)

But while computing it we update:

diameter = max(diameter, leftHeight + rightHeight)


CODE------>>>>>


class DiameterBinaryTree {

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        height(root);
        return diameter;
    }

    private int height(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
  omplexity

Time Complexity:O(n)

Space Complexity:O(h)

Where:
n = nodes
h = tree height
}
