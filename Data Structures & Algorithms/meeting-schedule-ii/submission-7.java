/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        // active meetings end time
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int meetingRoomsReq = 0;

        Comparator<Interval> cmp = (i1, i2) -> {
            if (i1.start != i2.start)
                return Integer.compare(i1.start, i2.start);

            return Integer.compare(i1.end, i2.end);
        };

        Collections.sort(intervals, cmp);

        for (Interval interval: intervals) {
            while (!minHeap.isEmpty() && minHeap.peek() <= interval.start)
                minHeap.poll();

            minHeap.offer(interval.end);

            meetingRoomsReq = Math.max(meetingRoomsReq, minHeap.size());
        }

        return meetingRoomsReq;
    }
}
