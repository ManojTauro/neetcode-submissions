class Solution {
    public boolean hasDuplicate(int[] nums) {
        // use hashmap to count the freq
        // while adding check if that element is present before
        // if yes then return

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num: nums) {
            if (freq.containsKey(num)) return true;

            freq.put(num, 1);
        }

        return false;
    }
}