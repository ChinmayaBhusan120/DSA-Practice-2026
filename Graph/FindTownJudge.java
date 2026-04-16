PROBLEM
🔹 Find the Town Judge
🧠 Key Idea (VERY IMPORTANT)

Instead of building full graph, think smart:

👉 Judge properties:

Judge trusts nobody → outgoing = 0
Everyone trusts judge → indegree = n - 1
🧠 Trick (Best Approach)

We use one array:
trustScore[i]

👉 For each trust [a, b]:

a trusts someone → trustScore[a]--
b is trusted → trustScore[b]++
🎯 Final Condition
Judge → trustScore[i] == n - 1





class FindTownJudge {

    public int findJudge(int n, int[][] trust) {

        int[] trustScore = new int[n + 1];

        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];

            trustScore[a]--; // trusts someone
            trustScore[b]++; // trusted
        }

        for (int i = 1; i <= n; i++) {
            if (trustScore[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
