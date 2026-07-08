class Solution {
    public int[][] merge(int[][] intervals) {
        Comparator<int[]> cmp = (i1, i2) -> {
            if (i1[0] != i2[0])
                return Integer.compare(i1[0], i2[0]);

            return Integer.compare(i1[1], i2[1]);
        };

        Arrays.sort(intervals, cmp);

        int[] base = intervals[0];

        List<int[]> temp = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] cur = intervals[i];
        
            if (base[1] >= cur[0]) {
                // overlapping
                base[1] = Math.max(base[1], cur[1]);
            } else {
                temp.add(base);
                base = cur;
            }
        }

        temp.add(base);
        
        int[][] ans = new int[temp.size()][2];

        int k = 0;
        for (int[] t: temp) ans[k++] = t;

        return ans;
    }
}
