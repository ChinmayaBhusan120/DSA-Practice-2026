
Problem Statement

You are given:
stalls[] → positions of stalls
k → number of cows
Place the cows in stalls such that the minimum distance between any two cows is maximized.
Return the largest minimum distance.

Example
Input:
stalls = [1,2,4,8,9]
k = 3
Output:
3

Explanation:
We can place cows at:
1 , 4 , 8
Minimum distance = 3



Key Insight

We search the distance between cows.

Range:

min distance = 1
max distance = stalls[n-1] - stalls[0]

Binary search this range.



Feasibility Check

For a given distance d:
Try placing cows greedily.
Place first cow at first stall.
Then place next cow if:
current_position - last_position ≥ d
If we can place all cows → valid.


CODE----->>>>>>


import java.util.Arrays;

class AggressiveCows {

    public static int maxDistance(int[] stalls, int k) {

        Arrays.sort(stalls);

        int left = 1;
        int right = stalls[stalls.length - 1] - stalls[0];

        int result = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (canPlace(stalls, k, mid)) {
                result = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return result;
    }

    private static boolean canPlace(int[] stalls, int k, int distance) {

        int cows = 1;
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {

            if (stalls[i] - lastPosition >= distance) {
                cows++;
                lastPosition = stalls[i];
            }

            if (cows >= k) return true;
        }

        return false;
    }

    public static void main(String[] args) {

        int[] stalls = {1,2,4,8,9};
        int k = 3;

        System.out.println("Maximum Distance: " +
                maxDistance(stalls, k));
    }
}
