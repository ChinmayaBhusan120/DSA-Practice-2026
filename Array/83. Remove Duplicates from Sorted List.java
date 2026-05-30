


Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.



class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode curr = head;

        while (curr != null && curr.next != null) {

            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;   // remove duplicate
            } else {
                curr = curr.next;             // move forward
            }
        }

        return head;
    }
}
