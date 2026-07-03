class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] suffix = new int[n];
        int product = 1;

        for (int i = n - 1; i >= 0; i--) {
            product *= nums[i];
            suffix[i] = product;

            if (product == 0) product = 1;
        }

        product = 1;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            product *= nums[i];
            ans = Math.max(ans, Math.max(product, suffix[i]));

            if (product == 0) product = 1;
        }

        return ans;
    }
}
