class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }

            map.put(ch, right);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

Why Math.max(left, map.get(ch) + 1)?

Consider:abba

If we simply write:left = map.get(ch) + 1;
then when processing the last 'a', left would incorrectly move backward, producing an invalid window.

Using:left = Math.max(left, map.get(ch) + 1);
ensures left never moves backward, preserving the sliding window.
