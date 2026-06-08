class Solution {
    public int climbStairs(int n) {
        // at each step we have 2 options
        // take 1 step or 2 step
        // since this is counting problem
        // answer at each step will be addition of 2 steps
        
        // base case - start from the top and then reach to 0
        // when we reach 0 then return 1, if we reach < 0 then return -1

        // int[] memo = new int[n + 1];
        // Arrays.fill(memo, -1);

        // return solve(n, memo);

        return tabulation(n);
    }

    // tablulation - bottom up
    private int tabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int oneStep = dp[i - 1];
            int twoStep = 0;

            if (i > 1) {
                twoStep = dp[i - 2];
            }

            dp[i] = oneStep + twoStep;
        }

        return dp[n];
    }

    // top down
    private int solve(int n, int[] memo) {
        if (n == 0) return 1;

        if (n < 0) return 0;

        if (memo[n] != -1) return memo[n];

        int oneStep = solve(n - 1, memo);
        int twoStep = solve(n - 2, memo);

        return memo[n] = oneStep + twoStep;
    }
}
