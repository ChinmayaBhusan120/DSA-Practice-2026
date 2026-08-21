class Solution {
    public int beautySum(String s) {
        int totalBeauty = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;
                
                int maxF = 0;
                int minF = Integer.MAX_VALUE;
                
                for (int f : freq) {
                    if (f > 0) {
                        maxF = Math.max(maxF, f);
                        minF = Math.min(minF, f);
                    }
                }
                totalBeauty += (maxF - minF);
            }
        }
        return totalBeauty;
    }
}
