class Solution {
    public String minWindow(String s, String t) {
        int ws = 0;
        Map<Character, Integer> mapOfT = new HashMap<>();
        Map<Character, Integer> mapOfS = new HashMap<>();
        String ans = "";
        int minLen = Integer.MAX_VALUE;

        for (char c: t.toCharArray()) {
            mapOfT.put(c, mapOfT.getOrDefault(c, 0) + 1);
        }

        for (int we = 0; we < s.length(); we++) {
            char c = s.charAt(we);
            mapOfS.put(c, mapOfS.getOrDefault(c, 0) + 1);

            while (isValidWindow(mapOfS, mapOfT)) {
                if (we - ws + 1 < minLen) {
                    minLen = we - ws + 1;
                    ans = s.substring(ws, we + 1);
                }

                char startChar = s.charAt(ws);
                mapOfS.put(startChar, mapOfS.get(startChar) - 1);

                if (mapOfS.get(startChar) == 0) mapOfS.remove(startChar);
                ws += 1;
            }
        }

        return ans;
    }

    private boolean isValidWindow(Map<Character, Integer> mapOfS, Map<Character, Integer> mapOfT) {
        for (Map.Entry<Character, Integer> entry: mapOfT.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();

            if (!mapOfS.containsKey(c)) return false;

            if (mapOfS.get(c) < count) return false;
        }

        return true;
    }
}
