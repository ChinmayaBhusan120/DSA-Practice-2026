Problem Statement

Given a sorted array nums and a target value,
return the starting and ending position of the target.

If not found → return [-1, -1].

Example
Input:
nums = [5,7,7,8,8,10]
target = 8

Output:
[3,4]



Key Idea
We run Binary Search twice:
1️⃣ Find first occurrence
2️⃣ Find last occurrence



CODE------>>>>>

class FirstLastPosition {

    public static int[] searchRange(int[] nums, int target) {

        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[]{first, last};
    }

    private static int findFirst(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        int index = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            if (nums[mid] == target) {
                index = mid;
            }
        }

        return index;
    }

    private static int findLast(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        int index = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

            if (nums[mid] == target) {
                index = mid;
            }
        }

        return index;
    }

    public static void main(String[] args) {

        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        int[] result = searchRange(nums, target);

        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }
}
