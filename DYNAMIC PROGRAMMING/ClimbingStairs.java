Problem Statement

You are climbing a staircase.
Each time you can take 1 or 2 steps
There are n steps

👉 Return number of distinct ways to reach the top

Example
Input: n = 3
Output: 3

Ways:
1 + 1 + 1
1 + 2
2 + 1
🧠 Key Insight

This is exactly:  f(n) = f(n-1) + f(n-2)  (Same as Fibonacci)


 Why?

To reach step n:

Come from n-1 (1 step)
Come from n-2 (2 steps)



CODE------>>>>>>>>>


class Solution {

    public int climbStairs(int n) {

        if (n <= 2) return n;

        int prev2 = 1;
        int prev1 = 2;
        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
