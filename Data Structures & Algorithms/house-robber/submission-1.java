class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n + 1];

        Arrays.fill(memo, -1);

        return solve(n, nums, memo);
    }

    private int tabulation(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        return 0;
    }

    private int solve(int i, int[] nums, int[] memo) {
        if (i == 0) return 0;

        if (i == 1) return nums[i - 1];

        if (memo[i] != -1) return memo[i];

        int notPick = solve(i - 1, nums, memo);
        int pick = nums[i - 1] + solve(i - 2, nums, memo);

        return memo[i] = Math.max(notPick, pick);
    }
}
