Problem Statement

You are given:
bloomDay[i] → the day the ith flower blooms
m → number of bouquets needed
k → number of adjacent flowers required per bouquet
Retrn the minimum number of days needed to make m bouquets.
If impossible → return -1.

Example
Input:
bloomDay = [1,10,3,10,2]
m = 3
k = 1
Output:
3


Key Insight
We search days.

Range:
min = 1
max = max(bloomDay)

Binary search this range.
 Feasibility Check
For a given day:
Count how many bouquets we can make.
Rule:
flower bloomed if bloomDay[i] ≤ day
We need k consecutive flowers.


CODE--------



class MinDaysBouquets {

    public static int minDays(int[] bloomDay, int m, int k) {

        if ((long)m * k > bloomDay.length) return -1;

        int left = 1;
        int right = 0;

        for (int day : bloomDay) {
            right = Math.max(right, day);
        }

        int result = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                result = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return result;
    }

    private static boolean canMake(int[] bloomDay, int m, int k, int day) {

        int bouquets = 0;
        int flowers = 0;

        for (int bloom : bloomDay) {

            if (bloom <= day) {
                flowers++;

                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }

        return bouquets >= m;
    }

    public static void main(String[] args) {

        int[] bloomDay = {1,10,3,10,2};
        int m = 3;
        int k = 1;

        System.out.println("Minimum Days: " +
                minDays(bloomDay, m, k));
    }
}
