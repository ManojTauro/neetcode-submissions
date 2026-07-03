class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length;
        int[] nge = nextGreaterElements(t);
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (nge[i] == -1) continue;

            ans[i] = nge[i] - i;
        }

        return ans;
    }

    private int[] nextGreaterElements(int[] t) {
        int n = t.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && t[i] >= t[st.peek()]) {
                st.pop();
            }

            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }

            st.push(i);
        }

        return ans;
    }
}
