Key Observation

Suppose
a = "abcd" (length = 4)
b = "cdabcdab" (length = 8)

To cover b, we need at least
ceil(len(b) / len(a))
repetitions.

However, b may start near the end of one repetition and continue into the next.

So we only need to check:

Minimum repetitions
Minimum + 1 repetitions
No need to check more than that.

  
Algorithm
Keep appending a until the built string length is at least b.length().
Check if b is a substring.
If not, append one more a.
Check again.
If still not found, return -1.




Time: O(m + n)
Space: O(m + n)




class Solution {
    public int repeatedStringMatch(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        if (sb.indexOf(b) != -1)
            return count;

        sb.append(a);

        if (sb.indexOf(b) != -1)
            return count + 1;

        return -1;
    }
}
