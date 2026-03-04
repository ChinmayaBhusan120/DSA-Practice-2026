Problem Statement

A peak element is an element that is greater than its neighbors.
Given an array nums, find any peak element and return its index.

You may assume:
nums[-1] = -∞
nums[n] = -∞
Example
Input: nums = [1,2,3,1]
Output: 2
Peak = 3
Another Example
Input: nums = [1,2,1,3,5,6,4]
Output: 5
Peak = 6

Key Insight

Check the slope:
If
nums[mid] < nums[mid + 1]
→ Peak is on the right side
Else
→ Peak is on the left side (including mid)
Because the array must eventually go down.













class FindPeakElement {

    public static int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,1};
        System.out.println("Peak Index: " + findPeakElement(nums));
    }
}
