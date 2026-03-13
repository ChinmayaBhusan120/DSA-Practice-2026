# 🌳 Binary Tree Pattern

## 🧠 Overview

A **Binary Tree** is a hierarchical data structure where each node has at most two children:

- Left child
- Right child
Example:

```
        3
       / \
      9   20
         /  \
        15   7
```

TreeNode Structure (Java)
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}


Binary Tree Traversals-

Tree traversal means visiting every node of the tree in a specific order.

1️⃣ Inorder Traversal
Left → Root → Right

Example:

    2
   / \
  1   3

Inorder: 1 2 3
2️⃣ Preorder Traversal
Root → Left → Right

Example:

    2
   / \
  1   3

Preorder: 2 1 3
3️⃣ Postorder Traversal
Left → Right → Root

Example:

    2
   / \
  1   3

Postorder: 1 3 2
4️⃣ Level Order Traversal (BFS)

Traversal happens level by level.

Example:

        3
       / \
      9   20
         /  \
        15   7

Level Order:

3 → 9 → 20 → 15 → 7

This traversal uses a Queue (Breadth First Search).
Common Binary Tree Problems

Some important problems you will find in this folder:

Maximum Depth of Binary Tree
Binary Tree Traversals
Same Tree
Symmetric Tree
Diameter of Binary Tree
Binary Tree Level Order Traversal
Lowest Common Ancestor


Time Complexity

Tree Traversal	O(n)
Search	O(n)
Space (Recursion stack)	O(h)

Where:
n = number of nodes
h = height of the tree
