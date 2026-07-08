class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Comparator<int[]> cmp = (i1, i2) -> {
            return Integer.compare(i1[1], i2[1]);
        };

        int n = intervals.length;

        Arrays.sort(intervals, cmp);

        int count = 1;

        int end = intervals[0][1];

        for (int i = 1; i < n; i++) {
            int[] cur = intervals[i];

            if (cur[0] >= end) {
                count += 1;
                end = cur[1];
            }
        }

        return n - count;
    }
}
