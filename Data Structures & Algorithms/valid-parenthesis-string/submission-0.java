class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> st1 = new ArrayDeque<>(); // '('
        Deque<Integer> st2 = new ArrayDeque<>(); // '*'

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                st1.push(i);
            } else if (c == '*') {
                st2.push(i);
            } else {
                if (!st1.isEmpty()) st1.pop();
                else if (!st2.isEmpty()) st2.pop();
                else return false; // '(' before any ')' or '*'
            }
        }

        while (!st1.isEmpty() && !st2.isEmpty() && st2.peek() > st1.peek()) {
            st1.pop();
            st2.pop();
        }

        return st1.isEmpty();
    }
}
