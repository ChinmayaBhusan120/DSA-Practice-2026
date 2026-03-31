Problem Statement

Given the root of a binary tree, return the zigzag level order traversal.

Level 1 → left to right
Level 2 → right to left
Level 3 → left to right
and so on…
Example
Tree:

        3
       / \
      9   20
         /  \
        15   7

Output:[[3],[20,9],[15,7]]
    
🧠 Key Idea
We use BFS (Queue) like normal level order, but:

 Alternate direction at each level

Use a flag:
leftToRight = true / false
    
Trick-Instead of reversing later, we insert:

If leftToRight → add at end
Else → add at beginning


CODE------>>>>>

    
class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {

            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if (leftToRight) {
                    level.addLast(node.val);
                } else {
                    level.addFirst(node.val);
                }

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);
            }

            result.add(level);
            leftToRight = !leftToRight;
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
Complexity

Time Complexity:O(n)

Space Complexity:O(n)
