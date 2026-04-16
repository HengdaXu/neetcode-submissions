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
        List<int[]> events = new ArrayList<>();
        for (Interval interval: intervals){
            events.add(new int[]{interval.start, 1});
            events.add(new int[]{interval.end, -1});
        }
        events.sort((a, b) -> ((a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]));

        int days = 0;
        int res = 0;
        for (int[] event: events){
            days += event[1];
            res = Math.max(days, res);
        }
        return res;
    }
}
