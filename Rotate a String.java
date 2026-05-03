Key Idea

If goal is a rotation of s, then:
 goal must be a substring of (s + s)

 Why this works?
Example:
s = "abcde"
s + s = "abcdeabcde"

All possible rotations of s:

abcde
bcdea
cdeab
deabc
eabcd

 All of them appear inside "abcdeabcde"

Approach
Check lengths → must be equal
Concatenate: s + s
Check if goal is inside it


CODE------>>>>>>>>>>>>


class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1) + s.charAt(0); // shift
            if (s.equals(goal)) return true;
        }

        return false;
    }
}
