class Solution {
    List<List<int[]>> adj = new ArrayList<>();

    record State(int stops, int node, int price) {}

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        getAdj(flights, n);
        Deque<State> q = new ArrayDeque<>();
        int[] dis = new int[n];

        Arrays.fill(dis, Integer.MAX_VALUE);
        q.offer(new State(0, src, 0));
        dis[src] = 0;

        while (!q.isEmpty()) {
            State cur = q.poll();

            for (int[] neighbor: adj.get(cur.node)) {
                int newPrice = cur.price + neighbor[1];
                int neighborNode = neighbor[0];

                if (cur.stops > k) continue;

                if (newPrice > dis[neighborNode]) continue;

                dis[neighborNode] = newPrice;
                q.offer(
                    new State(cur.stops + 1, neighborNode, newPrice)
                );
            }
        }

        return dis[dst] != Integer.MAX_VALUE ? dis[dst] : -1;
    }

    private void getAdj(int[][] flights, int n) {
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] route: flights) {
            adj.get(route[0]).add(new int[]{route[1], route[2]});
        }
    }
}
