import java.util.*;

class Solution {
    public long minimumTime(int[] time, int totalTrips) {

        long start = 1;
        long end = (long) Arrays.stream(time).min().getAsInt() * totalTrips;
        long ans = end;

        while (start <= end) {

            long mid = start + (end - start) / 2;

            if (canComplete(time, totalTrips, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public boolean canComplete(int[] time, int totalTrips, long mid) {

        long trips = 0;

        for (int each : time) {
            trips += mid / each;

            if (trips >= totalTrips)
                return true;
        }

        return false;
    }
}
