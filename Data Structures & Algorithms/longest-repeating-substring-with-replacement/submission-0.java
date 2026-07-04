class Solution {
    public int characterReplacement(String s, int k) {
        int ws = 0;
        int n = s.length();
        int maxFreqCharCount = 0;
        Map<Character, Integer> freq = new HashMap<>();
        int ans = 0;

        for (int we = 0; we < n; we++) {
            char c = s.charAt(we);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            maxFreqCharCount = Math.max(maxFreqCharCount, freq.get(c));

            // (we - ws + 1) - maxFreqCharCount - gives us number of chars to replace
            // and it should be <= k
            // otherwise the window is invalid
            while ((we - ws + 1) - maxFreqCharCount > k) {
                char startCh = s.charAt(ws);
                freq.put(startCh, freq.get(startCh) - 1);

                if (freq.get(startCh) == 0) freq.remove(startCh);

                // update maxFreqCharCount
                for (Map.Entry<Character, Integer> entry: freq.entrySet()) {
                    maxFreqCharCount = Math.max(maxFreqCharCount, entry.getValue());
                }

                ws += 1;
            }

            ans = Math.max(ans, we - ws + 1);
        }

        return ans;
    }
}
