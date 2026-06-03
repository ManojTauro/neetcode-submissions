class Solution {
    public boolean isAnagram(String s, String t) {
        // store a freq of each char of s in a HashMap
        // iterate over String t, and reduce freq in s for each char
        // that is found in string t
        // after traversing t, if freq of all char becomes 0 in the map
        // then return true
        // return false

        Map<Character, Integer> freq = new HashMap<>();
        for (char c: s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (char c: t.toCharArray()) {
            if (!freq.containsKey(c)) return false;

            freq.put(c, freq.get(c) - 1);

            if (freq.get(c) == 0) freq.remove(c);
        }

        return freq.size() == 0;
    }
}
