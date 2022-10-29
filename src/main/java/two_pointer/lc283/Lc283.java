package two_pointer.lc283;

public class Lc283 {
    public void moveZeroes(int[] nums) {
        int lo = 0;
        for (int hi = 0; hi < nums.length; ++hi) {
            int tmp  = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = tmp;
            if (nums[lo] != 0) ++lo;
        }
    }
}
