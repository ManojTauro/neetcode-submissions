class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int index = 0;

        for (int i = 0; i < n; i++) {
            int cur = nums[i];

            if (!dq.isEmpty() && dq.peekFirst() == i - k)
                dq.pollFirst();

            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) 
                dq.pollLast();

            dq.offerLast(i);

            if (i >= k - 1) ans[index++] = nums[dq.peekFirst()];
        }

        return ans;
    }
}
