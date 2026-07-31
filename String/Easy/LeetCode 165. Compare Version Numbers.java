Approach (Two Pointers - O(1) Extra Space)

Instead of splitting the strings into arrays, we can traverse both version strings using two pointers.

Algorithm
Initialize two pointers i and j for both strings.
Read one revision number at a time until '.' or end of string.
Compare the two revision numbers.
If num1 > num2, return 1.
If num1 < num2, return -1.
Move both pointers past the '.'.
Continue until both strings are completely processed.
If all revisions are equal, return 0.


  
CODE--->>>>>>>>>>.
Complexity
Time: O(n + m)
Space: O(1)


class Solution {
    public int compareVersion(String version1, String version2) {

        int i = 0, j = 0;
        int n = version1.length();
        int m = version2.length();

        while (i < n || j < m) {

            int num1 = 0;
            while (i < n && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i) - '0');
                i++;
            }

            int num2 = 0;
            while (j < m && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j) - '0');
                j++;
            }

            if (num1 > num2)
                return 1;

            if (num1 < num2)
                return -1;

            i++;
            j++;
        }

        return 0;
    }
}
