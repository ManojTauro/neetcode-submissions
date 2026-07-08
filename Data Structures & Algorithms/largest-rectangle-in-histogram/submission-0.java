class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nse = nse(heights);
        int[] pse = pse(heights);

        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;

            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }

    private int[] nse(int[] arr) {
        int n = arr.length;

        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        Arrays.fill(ans, n);

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();

            if (!st.isEmpty()) ans[i] = st.peek();

            st.push(i);
        }

        return ans;
    }

    private int[] pse(int[] arr) {
        int n = arr.length;

        int[] ans = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();

            if (!st.isEmpty()) ans[i] = st.peek();

            st.push(i);
        }

        return ans;
    }
}
