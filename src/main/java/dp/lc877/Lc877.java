package dp.lc877;

public class Lc877 {
    public boolean stoneGame(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }

        int[][] dp = new int[nums.length][nums.length];

        // dp initialization
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = nums[i];
        }

        // filling dp table
        for (int len = 2; len <= nums.length; len++) {
            for (int i = 0; i < nums.length; i++) {
                int j = i + len - 1;
                if (j >= nums.length) {
                    continue;
                }
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][nums.length - 1] > 0;
    }
}
