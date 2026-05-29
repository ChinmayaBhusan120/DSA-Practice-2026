You are given an integer array nums.

You replace each element in nums with the sum of its digits.

Return the minimum element in nums after all replacements.

Example 1:
Input: nums = [10,12,13,14]
Output: 1


CODE---->>>>>


class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            min = Math.min(min, sum);
        }

        return min;
    }
}
