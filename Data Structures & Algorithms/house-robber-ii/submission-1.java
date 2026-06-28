class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        if (n == 1) return nums[0];

        int case1 = tabulation(nums, 0, n - 2);
        int case2 = tabulation(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    private int tabulation(int[] nums, int start, int end) {
        int n = end - start + 1;
        int[] dp = new int[n + 1];

        dp[1] = nums[start];

        for (int i = 2; i <= n; i++) {
            int notPick = dp[i - 1];
            int pick = nums[start + i - 1] + dp[i - 2];

            dp[i] = Math.max(notPick, pick);
        }

        return dp[n];
    }
}
