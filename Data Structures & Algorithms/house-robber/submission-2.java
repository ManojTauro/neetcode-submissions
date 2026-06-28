class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n + 1];

        Arrays.fill(memo, -1);

        // return solve(n, nums, memo);

        return tabulation(nums);
    }

    private int tabulation(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];

        dp[1] = nums[0];

        for (int i = 2; i <= n; i++) {
            int notPick = dp[i - 1];
            int pick = nums[i - 1] + dp[i - 2];

            dp[i] = Math.max(notPick, pick);
        }

        return dp[n];
    }

    private int solve(int i, int[] nums, int[] memo) {
        if (i == 0)
            return 0;

        if (i == 1)
            return nums[i - 1];

        if (memo[i] != -1)
            return memo[i];

        int notPick = solve(i - 1, nums, memo);
        int pick = nums[i - 1] + solve(i - 2, nums, memo);

        return memo[i] = Math.max(notPick, pick);
    }
}
