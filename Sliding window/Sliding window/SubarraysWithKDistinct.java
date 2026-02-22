
Problem Statement

Given an integer array nums and an integer k,
return the number of good subarrays of nums.

A good subarray contains exactly k distinct integers.

Example
Input: nums = [1,2,1,2,3], k = 2
Output: 7

CODE---->

import java.util.HashMap;

class SubarraysWithKDistinct {

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private static int atMost(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int count = 0;

        for (int right = 0; right < nums.length; right++) {

            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {

                map.put(nums[left], map.get(nums[left]) - 1);

                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }

                left++;
            }

            count += right - left + 1;
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,1,2,3};
        int k = 2;

        System.out.println("Result: " + subarraysWithKDistinct(nums, k));
    }
}
