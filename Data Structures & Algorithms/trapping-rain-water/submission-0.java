class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] suffixMax = new int[n];

        suffixMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], height[i]);
        }

        int prefixMax = height[0];
        int total = Math.min(prefixMax, suffixMax[0]) - height[0];
        for (int i = 1; i < n; i++) {
            prefixMax = Math.max(prefixMax, height[i]);
            total += Math.min(prefixMax, suffixMax[i]) - height[i];
        }

        return total;
    }
}
