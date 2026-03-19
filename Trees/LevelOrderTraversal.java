
Binary Tree Level Order Traversal
 Problem Statement

Given the root of a binary tree, return the level order traversal of its nodes' values.
Traversal happens level by level from left to right.
Example

Tree:

        3
       / \
      9   20
         /  \
        15   7

Output:
[[3],[9,20],[15,7]
]
 Key Idea

We use a Queue.
Steps:
1️⃣ Push root into queue
2️⃣ Process nodes level by level
3️⃣ For each level:

record node values
add children to queue

Algorithm
Queue ← root

while queue not empty
    process all nodes in current level
    add their children





import java.util.*;

class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);
            }

            result.add(level);
        }

        return result;
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
Space Complexity:O(n)
