Problem Statement

You are given an array weights where:
weights[i] = weight of ith package
Packages must be shipped in order.
You must ship all packages within days.
Return the minimum ship capacity required.

Example
Input:
weights = [1,2,3,4,5,6,7,8,9,10]
days = 5
Output:
15



Key Insight
We search minimum capacity.
Range of capacity:

min = max(weights)
max = sum(weights)

Why?

Ship must carry at least the heaviest package
At most it can carry everything in one day
Check Function

We simulate shipping:
if current load > capacity
    next day
Count days needed.
If days ≤ allowed days → capacity works.



CODE--------

class ShipPackages {

    public static int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = 0;

        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        int result = right;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (canShip(weights, mid, days)) {
                result = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return result;
    }

    private static boolean canShip(int[] weights, int capacity, int days) {

        int daysUsed = 1;
        int currentLoad = 0;

        for (int w : weights) {

            if (currentLoad + w > capacity) {
                daysUsed++;
                currentLoad = 0;
            }

            currentLoad += w;
        }

        return daysUsed <= days;
    }

    public static void main(String[] args) {

        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        System.out.println("Minimum Capacity: " +
                shipWithinDays(weights, days));
    }
}
