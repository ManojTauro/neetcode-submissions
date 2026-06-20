class Solution {
    private Map<Integer, List<Integer>> adj = new HashMap<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        createAdj(numCourses, prerequisites);

        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int node: adj.get(i)) {
                indegree[node] += 1;
            }
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }
        
        List<Integer> temp = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();

            temp.add(node);
            numCourses -= 1;

            for (int adjNode: adj.get(node)) {
                indegree[adjNode] -= 1;

                if (indegree[adjNode] == 0)
                    q.offer(adjNode);
            }
        }

        if (numCourses != 0) return new int[]{};

        int[] ans = new int[temp.size()];

        int k = 0;
        for (int num: temp) ans[k++] = num;

        return ans;
    }

    private void createAdj(int numCourses, int[][] prereq) {
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] temp: prereq) {
            int u = temp[1];
            int v = temp[0];

            adj.get(u).add(v);
        }
    }
}
