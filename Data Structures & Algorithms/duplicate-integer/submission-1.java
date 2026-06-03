class Solution {
    public boolean hasDuplicate(int[] nums) {
        // use hashmap to count the freq
        // while adding check if that element is present before
        // if yes then return

        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (set.contains(num)) return true;

            set.add(num);
        }

        return false;
    }
}