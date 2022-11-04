package matrix.lc485;

public class Lc485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            // Keep count of max and count variable
            // count variable is current itteration of 1's
            if (nums[i] == 1) {
                count++;
                result = Math.max(count, result);
            }
            else count = 0;
        }

        return result;
    }
}
