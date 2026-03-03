Problem Statement
Given a sorted array that has been rotated,
find the minimum element.
No duplicates.

Example
Input:  [3,4,5,1,2]
Output: 1
Input:  [4,5,6,7,0,1,2]
Output: 0


key Insight

At any time:
If nums[mid] > nums[right]
→ Minimum is in right half
Else
→ Minimum is in left half (including mid)

We shrink the search space


class FindMinimumRotated {

    public static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }



Why right = mid (not mid - 1)?

Because mid might be the minimum.
So we must keep it.
Complexity
Time → O(log n)
Space → O(1)

