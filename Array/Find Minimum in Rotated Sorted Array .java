class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                // Min is in the right half (excluding mid)
                left = mid + 1;
            } else {
                // Min is in the left half (including mid)
                right = mid;
            }
        }
        return nums[left];
    }
}
