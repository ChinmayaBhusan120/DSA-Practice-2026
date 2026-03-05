
Problem Statement

Koko has piles of bananas.
She eats k bananas per hour.
Return the minimum k such that she finishes all bananas within h hours.

Example
Input:
piles = [3,6,7,11]
h = 8
Output:
4
 ey Idea
We are NOT searching array index.
We search possible eating speed k.
Range of k:
1 → max(piles)
Binary search this range.
 Check Function
For each speed k:
hours += ceil(pile / k)

If hours ≤ h → valid speed
Else → too slow

CODE----->>>>>

class KokoEatingBananas {

    public static int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int result = right;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (canFinish(piles, mid, h)) {
                result = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return result;
    }

    private static boolean canFinish(int[] piles, int speed, int h) {

        int hours = 0;

        for (int pile : piles) {
            hours += Math.ceil((double)pile / speed);
        }

        return hours <= h;
    }

    public static void main(String[] args) {

        int[] piles = {3,6,7,11};
        int h = 8;

        System.out.println("Min Speed: " + minEatingSpeed(piles, h));
    }
}
