class StockSpanner {
    record State(int i, int price){}

    Deque<State> st = new ArrayDeque<>();
    int index = -1;

    public StockSpanner() {
        
    }
    
    public int next(int price) {
        index += 1;

        while (!st.isEmpty() && price >= st.peek().price) 
            st.pop();

        int spanStart = st.isEmpty() ? -1 : st.peek().i;
        int span = index - spanStart;

        st.push(new State(index, price));

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */