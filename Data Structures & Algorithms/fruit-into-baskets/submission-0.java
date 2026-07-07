class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> map = new HashMap<>();
        int ws = 0;
        int maxFruits = 0;

        for (int we = 0; we < n; we++) {
            int type = fruits[we];
            map.put(type, map.getOrDefault(type, 0) + 1);

            while (map.size() > 2) {
                int left = fruits[ws];

                map.put(left, map.get(left) - 1);

                if (map.get(left) == 0) map.remove(left);

                ws += 1;
            }

            maxFruits = Math.max(maxFruits, we - ws + 1);
        }

        return maxFruits;
    }
}