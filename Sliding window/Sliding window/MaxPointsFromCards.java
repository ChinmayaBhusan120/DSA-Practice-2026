Problem Statement
You are given an array cardPoints and an integer k.
You can take exactly k cards from:
Eithe start
Or end
Return the maximum score you can obtain.
Example
Input:
cardPoints = [1,2,3,4,5,6,1], k = 3
Output:
12
Take [6,5,1]



Key Insight (Important)
Instead of picking k cards,
Think as:
Remove a subarray of size (n - k) with minimum sum.
Because:
Total Sum - Minimum Subarray of size (n - k)

That gives maximum score.



CODE------>>>>>

class MaxPointsFromCards {

    public static int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        int totalSum = 0;
        for (int num : cardPoints) {
            totalSum += num;
        }

        if (k == n) return totalSum;

        int windowSize = n - k;
        int windowSum = 0;

        // First window
        for (int i = 0; i < windowSize; i++) {
            windowSum += cardPoints[i];
        }

        int minSum = windowSum;

        // Slide window
        for (int i = windowSize; i < n; i++) {
            windowSum += cardPoints[i];
            windowSum -= cardPoints[i - windowSize];

            minSum = Math.min(minSum, windowSum);
        }

        return totalSum - minSum;
    }

    public static void main(String[] args) {

        int[] cards = {1,2,3,4,5,6,1};
        int k = 3;

        System.out.println("Max Score: " + maxScore(cards, k));
    }
}
