class Solution {
    // sort the array
    // fix the 1st index
    // then apply logic of Two Sum 2 on rest of the array
    // skip duplicates along the way

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;

            int first = nums[i];

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int total = first + nums[left] + nums[right];

                if (total == 0) {
                    ans.add(Arrays.asList(first, nums[left], nums[right]));
                    
                    while (left < right && nums[left] == nums[left + 1]) 
                        left += 1;

                    while (left < right && nums[right] == nums[right - 1])
                        right -= 1;

                    right -= 1;
                    left += 1;
                }

                else if (total > 0) right -= 1;
                else left += 1;
            }
        }

        return ans;
    }
}
