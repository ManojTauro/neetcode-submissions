class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // for each string count char freq in an array
        // then convert freq array into a string representation 
        // which can be used as a key in a hashmap
        // so for example act and cat will have same string representation
        // Then use a hashmap to store anagrams per key
        // for example when you process "act" - it will get you a key
        // but then when you process "cat" - it will also get yout the same key
        // if the key is already exists then add it to list(value of the map key)

        Map<String, List<String>> anagrams = new HashMap<>();
        for (String str: strs) {
            int[] freq = getFreq(str);
            String key = getKey(freq);

            anagrams.computeIfAbsent(key, k -> new ArrayList()).add(str);
        }

        return new ArrayList<>(anagrams.values());
    }

    private String getKey(int[] freq) {
        StringBuilder key = new StringBuilder();
        for (int num: freq) {
            key.append(num).append(",");
        }

        return key.toString();
    }

    private int[] getFreq(String str) {
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch - 'a']++;
        }

        return freq;
    }
}
