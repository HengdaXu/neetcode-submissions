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
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a, b) -> (a.start - b.start));
        
        int prevEnd = -1;
        for (Interval interval: intervals){
            if (prevEnd == -1){
                prevEnd = interval.end;
                continue;
            }

            if (interval.start >= prevEnd){
                prevEnd = interval.end;
            }else{
                return false;
            }
        }
        return true;
    }
}
