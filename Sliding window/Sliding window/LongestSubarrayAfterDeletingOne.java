Problem Statement
Given a binary array nums,
you must delete exactly one element.
Return the length of the longest subarray containing only 1’s after deleting one element

Example
Input: nums = [1,1,0,1]
Output: 3
Delete the 0, remaining longest 1's = 3.


Core Idea--->
We maintain a window that contains at most one zero.
If zeros > 1 → shrink window.
Since we must delete one element,
final answer = window size - 1

CODE

  
class LongestSubarrayAfterDeletingOne {
    public static int longestSubarray(int[] nums) {

        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {

            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        int[] nums = {1,1,0,1};
        System.out.println("Result: " + longestSubarray(nums));
    }
}


Why right - left (not +1)?
Because:
We must delete one element.
Windo size = right - left + 1
After deleting one → window size - 1
Which equals:
