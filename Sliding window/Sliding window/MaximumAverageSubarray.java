Maximum Average Subarray I
🧠 Problem Statement
Given an integer array nums and integer k,
find the contiguous subarray of length k that has the maximum average value.
Return the maximum average.

Example
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75
Subarray: [12, -5, -6, 50]


Core Idea
Instead of calculating average every time:
1️⃣ Maintain window sum
2️⃣ Slide window
3️⃣ Track max sum
4️⃣ Return maxSum / k


class MaximumAverageSubarray {

    public static double findMaxAverage(int[] nums, int k) {

        int windowSum = 0;

        // First window
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }

        int maxSum = windowSum;

        // Slide window
        for (int i = k; i < nums.length; i++) {

            windowSum += nums[i];
            windowSum -= nums[i - k];

            maxSum = Math.max(maxSum, windowSum);
        }

        return (double) maxSum / k;
    }

    public static void main(String[] args) {

        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;

        System.out.println("Max Average: " + findMaxAverage(nums, k));
    }
}
