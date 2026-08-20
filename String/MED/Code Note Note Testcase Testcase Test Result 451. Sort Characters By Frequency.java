class Solution {
    public String frequencySort(String s) {

        // 1. Count frequency
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // 2. Put characters into a list
        ArrayList<Character> list = new ArrayList<>(map.keySet());

        // 3. Sort based on frequency
        list.sort((a, b) -> map.get(b) - map.get(a));

        // 4. Build answer
        StringBuilder ans = new StringBuilder();

        for (char ch : list) {
            int freq = map.get(ch);

            for (int i = 0; i < freq; i++) {
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}
