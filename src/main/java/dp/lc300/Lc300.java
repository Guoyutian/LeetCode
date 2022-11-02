package dp.lc300;

import java.util.Arrays;

public class Lc300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1); // since every element forms a subsequence with itself of length 1

        for(int i = 1; i < nums.length; i++){ // for every element in the array (we skip zeroth element because there's nothing before it and dp[1] is already initialized to 1 for the same reason)
            for(int j = 0 ; j < i; j++){ // check if there is a previous element that's smaller
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]); //if found, add the output of the previous sub problem to this sub problem.
                }
            }
        }

        int max = 0;
        for(int i = 0 ; i < nums.length; i++){
            max = Math.max(max,dp[i]); // return the maximum subproblem output
        }
        return max;
    }
}
