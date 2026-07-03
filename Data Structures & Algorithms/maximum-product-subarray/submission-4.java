class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prefixProduct = 1;
        int suffixProduct = 1;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            prefixProduct *= nums[i];
            suffixProduct *= nums[n - i - 1];

            ans = Math.max(ans, Math.max(prefixProduct, suffixProduct));

            if (prefixProduct == 0) prefixProduct = 1;
            if (suffixProduct == 0) suffixProduct = 1;
        }

        return ans;
    }
}
