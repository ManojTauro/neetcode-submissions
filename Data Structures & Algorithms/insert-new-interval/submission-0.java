class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        ArrayList<int[]> list = new ArrayList<>();

        int i = 0;

        // add all intervals which ends before the newInterval starts
        while (i < n && newInterval[0] > intervals[i][1]) {
            list.add(intervals[i]);
            i++;
        }

        // for overlapping case, we pick min of all overalapped intervals start
        /// and maximum of all overlapped intervals end
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

            i++;
        }

        list.add(new int[] {newInterval[0], newInterval[1]});

        while (i < n) {
            list.add(intervals[i]);
            i++;
        }

        return list.toArray(new int[list.size()][]);
    }
}
