Problem Statement
Given an array nums and an integer k,
split the array into k or fewer subarrays.

Return the minimum possible largest sum among those subarrays.
Example
Input:
nums = [7,2,5,10,8]
k = 2
Output:
18
Explanation:
Possible split:
[7,2,5]  [10,8]
Largest sum = 18




Key Insight

We search the minimum largest sum.
Range:
min = max(nums)
max = sum(nums)

Because:
A subarray must contain at least the largest number
At most we could take the whole array

 Feasibility Check
For a candidate maxSum:
Create subarrays greedily.
If current sum exceeds maxSum, start new subarray.
Count how many subarrays are needed.
If ≤ k → vali





class Solution {

    static final int MOD = 1_000_000_007;
    Integer[][][][] memo;

    public int numberOfStableArrays(int zero, int one, int limit) {
        memo = new Integer[zero + 1][one + 1][2][limit + 1];

        long ans = 0;

        if (zero > 0)
            ans = (ans + dfs(zero - 1, one, 0, 1, limit)) % MOD;

        if (one > 0)
            ans = (ans + dfs(zero, one - 1, 1, 1, limit)) % MOD;

        return (int) ans;
    }

    private int dfs(int z, int o, int last, int cnt, int limit) {

        if (z == 0 && o == 0) return 1;

        if (memo[z][o][last][cnt] != null)
            return memo[z][o][last][cnt];

        long res = 0;

        if (z > 0) {
            if (last == 0) {
                if (cnt < limit)
                    res += dfs(z - 1, o, 0, cnt + 1, limit);
            } else {
                res += dfs(z - 1, o, 0, 1, limit);
            }
        }

        if (o > 0) {
            if (last == 1) {
                if (cnt < limit)
                    res += dfs(z, o - 1, 1, cnt + 1, limit);
            } else {
                res += dfs(z, o - 1, 1, 1, limit);
            }
        }

        return memo[z][o][last][cnt] = (int)(res % MOD);
    }
}
