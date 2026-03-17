
Problem Statement

Given the root of a binary tree, determine whether it is symmetric around its center.

A tree is symmetric if the left subtree is a mirror reflection of the right subtree.

Example (Symmetric)
        1
       / \
      2   2
     / \ / \
    3  4 4  3

Output:

true
Example (Not Symmetric)
        1
       / \
      2   2
       \   \
        3   3

Output:

false
🧠 Key Idea

We check if two subtrees are mirror images.

Mirror condition:

left.left  == right.right
left.right == right.left
🧠 Recursive Logic

Two trees are mirrors if:

1️⃣ Their values are equal
2️⃣ Left subtree mirrors right subtree
3️⃣ Right subtree mirrors left subtree









class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode curr = prev.next;

        for (int i = 0; i < right - left; i++) {

            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }
}



Complexity

Time Complexity:O(n)
Space Complexity:O(h)

Where:
n = number of nodes
h = tree height



