package prefix_sum.lc1109;

public class Lc1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        for (int[] booking : bookings) {
            int i = booking[0]-1;
            int j = booking[1];
            int seats = booking[2];
            ans[i] += seats;
            if (j != n)
                ans[j] -= seats;
        }

        int count = 0;
        for (int i = 0; i < ans.length; i++) {
            ans[i] += count;
            count = ans[i];
        }
        return ans;
    }
}
