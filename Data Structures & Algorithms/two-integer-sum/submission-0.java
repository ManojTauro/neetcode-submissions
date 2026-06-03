class Solution {
    public int[] twoSum(int[] nums, int target) {
        // we can store element -> index in a hashmap
        // scan the array and see if target - num is in the map
        // if yes then return the index from the map and cur index
        // else add cur element to the map and keep moving

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];

            if (map.containsKey(rem)) 
                return new int[]{map.get(rem), i};

            map.put(nums[i], i);
        }

        return null;
    }
}
