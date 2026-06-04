class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (e1, e2) -> Integer.compare(e1[1], e2[1])
        );

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.offer(new int[] {entry.getKey(), entry.getValue()});

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];
        while (!pq.isEmpty()) {
            ans[--k] = pq.poll()[0];
        }

        return ans;
    }
}
