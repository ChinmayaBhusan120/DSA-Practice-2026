Problem Statement

You are given two sorted arrays:

nums1
nums2

Return the median of the two sorted arrays.

The overall time complexity must be:
O(log (m + n)
  
Example
Input:
nums1 = [1,3]
nums2 = [2]
Output:
2.0


Key Idea

We perform binary search on the smaller array.
We try to partition both arrays so that:
Left side elements ≤ Right side elements
And both halves contain equal elements.

Partition Logic
We choose:
cut1 → partition in nums1
cut2 → partition in nums2

So that:

cut1 + cut2 = (n1 + n2 + 1) / 2

Then check if partition is valid

  
CODE------->>>>>


  
class MedianTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int n1 = nums1.length;
        int n2 = nums2.length;

        int left = 0;
        int right = n1;

        while (left <= right) {

            int cut1 = (left + right) / 2;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int r1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

            if (l1 <= r2 && l2 <= r1) {

                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }

            } else if (l1 > r2) {
                right = cut1 - 1;
            } else {
                left = cut1 + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        int[] nums1 = {1,3};
        int[] nums2 = {2};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
