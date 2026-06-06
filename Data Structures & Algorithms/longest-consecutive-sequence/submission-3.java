class Solution {
    public int longestConsecutive(int[] nums) {
        // Key idea is to for each element 'num'
        // check if 'num - 1' is present in the array
        // if yes, then do not start sequence from that number
        // because it will be a part of a sequence where
        // there is no 'num - 1' for a given 'num'

        Set<Integer> set = new HashSet<>();
        
        for (int num: nums) set.add(num);

        int n = nums.length;
        int i = 0;
        int longest = 0;

        while (i < n) {
            if (set.contains(nums[i] - 1)) {
                i += 1;
                continue;
            }

            int count = 1;
            int next = nums[i] + 1;
            while (set.contains(next)) {
                next += 1;
                count += 1;
            }

            i += 1;
            longest = Math.max(count, longest);
        }

        return longest;
    }
}
