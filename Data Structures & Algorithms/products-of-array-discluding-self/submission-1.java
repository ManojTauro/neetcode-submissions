class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;

        // calculate left products
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // calculate right product, at the same
        // time calculate result as well
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = right * ans[i];
            right *= nums[i];
        }

        return ans;
    }

    // O(n) TC
    // O(n) SC
    public int[] productExceptSelf_v1(int[] nums) {
        // Naive approach is 
        // calculate total product, and then devide total product
        // by each element, but this breaks when there is 0

        // So the better approach is -
        // key insight is that for each index the answer is
        // product of left elements multiplied by 
        // product of right elements

        int n = nums.length;
        int[] left = new int[n];
        left[0] = 1;

        int[] right = new int[n];
        right[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;
    }
}  
