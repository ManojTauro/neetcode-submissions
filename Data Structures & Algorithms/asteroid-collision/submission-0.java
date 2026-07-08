class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st = new ArrayDeque<>();

        for (int ast: asteroids) {
            if (ast > 0) {
                st.push(ast);
                continue;
            }

            boolean survived = true;
            int absVal = Math.abs(ast);
            while (!st.isEmpty() && st.peek() > 0) {
                if (absVal == st.peek()) {
                    st.pop();
                    survived = false;
                    break;
                } else if (absVal < st.peek()) {
                    survived = false;
                    break;
                } else {
                    st.pop();
                }
            }

            if (survived) {
                st.push(ast);
            }
        }

        int[] ans = new int[st.size()];
        int k = st.size() - 1;

        while (!st.isEmpty()) {
            ans[k--] = st.pop();
        }

        return ans;
    }
}