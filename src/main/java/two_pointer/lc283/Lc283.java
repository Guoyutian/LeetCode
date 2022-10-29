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

    public void moveZeroes2(int[] nums) {
        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if(nums[r] != 0){
                swap(nums, l, r);
                l++;
            }
            r++;
        }
    }

    public void swap(int[] nums, int a, int b){
        if(a == b){
            return;
        }
        nums[a] ^= nums[b];
        nums[b] ^= nums[a];
        nums[a] ^= nums[b];
    }
}
