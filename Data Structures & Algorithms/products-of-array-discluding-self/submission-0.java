class Solution {
    public int[] productExceptSelf(int[] nums) {
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

        System.out.println(Arrays.toString(left));

        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        System.out.println(Arrays.toString(right));

        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;
    }
}  
