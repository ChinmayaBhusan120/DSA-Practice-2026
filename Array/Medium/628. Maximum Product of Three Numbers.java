The maximum product of 3 numbers can come from only two possibilities:

The three largest numbers
Example: [1,2,3,4]
Product = 4 × 3 × 2 = 24
The two smallest (most negative) numbers and the largest number
Because negative × negative = positive
Example: [-10,-10,5,2]
Product = (-10) × (-10) × 5 = 500

So the answer is:max(largest1×largest2×largest3,smallest1×smallest2×largest1)


Method 1 (Easy) - Sorting
Algorithm
Sort the array.
Compute
Last three elements.
First two elements and last element.
Return the maximum.



CODE------->>>>>>>>>>>>



class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int option1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int option2 = nums[0] * nums[1] * nums[n - 1];
        return Math.max(option1, option2);
    }
}

Complexity
Time: O(n log n)
Space: O(1)

ORRRRRRRRRR

Method 2 (Optimal) - One Pass

Instead of sorting, keep track of:
Largest
Second Largest
Third Largest

and
Smallest
Second Smallest

Complexity
Time: O(n)
Space: O(1)
    
    class Solution {
    public int maximumProduct(int[] nums) {

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums) {

            // Update largest three
            if (num >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num >= max2) {
                max3 = max2;
                max2 = num;
            } else if (num >= max3) {
                max3 = num;
            }

            // Update smallest two
            if (num <= min1) {
                min2 = min1;
                min1 = num;
            } else if (num <= min2) {
                min2 = num;
            }
        }

        return Math.max(max1 * max2 * max3,
                        max1 * min1 * min2);
    }
}
