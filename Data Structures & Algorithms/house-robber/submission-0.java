class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];

        Arrays.fill(memo, -1);

        return solve(n - 1, nums, memo);
    }

    private int solve(int i, int[] nums, int[] memo) {
        if (i < 0) return 0;

        if (i == 0) return nums[i];

        if (memo[i] != -1) return memo[i];

        int notPick = solve(i - 1, nums, memo);
        int pick = nums[i] + solve(i - 2, nums, memo);

        return memo[i] = Math.max(notPick, pick);
    }
}
