
It scans the string from right to left, extracts each word, and appends it to the answer.




Complexity
Time: O(n)
Space: O(n) (for the output string only)



class Solution {
    public String reverseWords(String s) {

        StringBuilder ans = new StringBuilder();

        int i = s.length() - 1;

        while (i >= 0) {

            // Skip spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            if (i < 0)
                break;

            int j = i;

            // Find the start of the word
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }

            // Append the word
            ans.append(s.substring(j + 1, i + 1));
            ans.append(" ");

            i = j;
        }

        // Remove the extra trailing space
        ans.setLength(ans.length() - 1);

        return ans.toString();
    }
}
