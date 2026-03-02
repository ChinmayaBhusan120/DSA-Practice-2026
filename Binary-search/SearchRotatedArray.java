

Problem Statement
You are given a sorted array that has been rotated at some pivot.

Example:
Original: [0,1,2,4,5,6,7]
Rotated:  [4,5,6,7,0,1,2]

Given nums and target, return its index.
If not found → return -1.
Example
Input:
nums = [4,5,6,7,0,1,2]
target = 0
Output:
4


Key Insight
At every step:
One half is always sorted.
We check:
If left half is sorted
Else right half is sorted
Then decide which side to search



class SearchRotatedArray {

    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[left] <= nums[mid]) {

                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }
            // Right half is sorted
            else {

                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        System.out.println("Index: " + search(nums, target));
    }
}
