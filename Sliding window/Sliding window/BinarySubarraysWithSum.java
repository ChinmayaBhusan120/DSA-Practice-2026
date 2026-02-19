problem Statement
You are given a binary array nums (only 0s and 1s)
and an integer goal.
Return the number of non-empty subarrays with sum = goal.


Example:
Input: nums = [1,0,1,0,1], goal = 2
Output: 4
Valid subarrays:
[1,0,1]
[1,0,1,0]
[0,1,0,1]
[1,0,1]
 Why This Is Important
Tricky sliding window
Uses mathematical trick
Very common interview variation
 Key Trick
Instead of directly counting:
exactly(goal)
We compute:
atMost(goal) - atMost(goal - 1)
Because:
Exactly K = AtMost(K) - AtMost(K-1)

This is a VERY powerful pattern.

CODE---------

class BinarySubarraysWithSum {

    public static int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private static int atMost(int[] nums, int goal) {

        if (goal < 0) return 0;

        int left = 0;
        int sum = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum > goal) {
                sum -= nums[left];
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1,0,1,0,1};
        int goal = 2;

        System.out.println("Result: " + numSubarraysWithSum(nums, goal));
    }
}
