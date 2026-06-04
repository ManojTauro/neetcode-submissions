class Solution {
    // Instead of sorting map values uisng PQ and getting top k we can flip the idea
    // Key insight is each number can appear certain times in the array, and maximum
    // possible is length of the array - when all elements are the same, and minimum
    // 1 when all elements are unique.

    // Therefore we can use a list(Bucket sort) whose index can be thought as frequency
    // that is possible and value will be elements that have that(ith) frequency.
    
    // Then we dont have to sort, we can iterate from max freq index (list.size() - 1)
    // and collect k elements

    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> buckets = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry: freq.entrySet()) {
            // entry.getValue() - index: freq of num (entry.getKey())
            buckets.get(entry.getValue()).add(entry.getKey());
        }

        int[] ans = new int[k];
        for (int i = buckets.size() - 1; i >= 0; i--) {
            List<Integer> bucket = buckets.get(i);

            for (int num: bucket) {
                if (k == 0) return ans;
                ans[--k] = num;
            }
        }

        return ans;
    }

    // count the numer of times a element occurs using a map
    // Use a PQ (min heap) to get top k elements
    public int[] topKFrequent_PQ(int[] nums, int k) {
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
