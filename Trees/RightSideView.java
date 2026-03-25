Problem Statement

Given the root of a binary tree, imagine standing on the right side of the tree.
Return the values of the nodes you can see ordered from top to bottom.

Example

Tree:

        1
       / \
      2   3
       \   \
        5   4

Right side view:

[1, 3, 4]

Because from the right side you see:

Level 1 → 1
Level 2 → 3
Level 3 → 4
 Key Idea
    We use Level Order Traversal (BFS).

At each level:

Process all nodes
The last node of that level is visible from the right side

Algorithm
Use Queue
Process nodes level by level
Record last node of each level







import java.util.*;

class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if (i == size - 1) {
                    result.add(node.val);
                }

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);
            }
        }

        return result;
    }
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
}
