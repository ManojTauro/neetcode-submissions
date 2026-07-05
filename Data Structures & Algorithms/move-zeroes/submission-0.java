class Solution {
    public void moveZeroes(int[] nums) {
        int nextZeroPos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            
            int temp = nums[nextZeroPos];
            nums[nextZeroPos] = nums[i];
            nextZeroPos += 1;
            nums[i] = temp;
        }
    }
}