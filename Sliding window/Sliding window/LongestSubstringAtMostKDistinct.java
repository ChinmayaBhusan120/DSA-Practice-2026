Steps:
1️⃣ Expand window using right pointer
2️⃣ Add character to HashMap (frequency tracking)
3️⃣ If distinct characters > k → shrink window
4️⃣ Update maximum length

🔁 Key Condition
while (map.size() > k)
If distinct characters exceed k,
remove characters from the left until valid



import java.util.HashMap;
class LongestSubstringAtMostKDistinct {

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {

        if (k == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            // Expand window
            char rightChar = s.charAt(right);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);

            // Shrink window if distinct characters exceed k
            while (map.size() > k) {

                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                left++;
            }

            // Update maximum valid window
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {

        String s = "eceba";
        int k = 2;

        System.out.println("Result: " + lengthOfLongestSubstringKDistinct(s, k));
    }
}
