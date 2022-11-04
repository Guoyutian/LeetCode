package matrix.lc283;

public class Lc283 {
    //0,1,0,3,12
    public void moveZeroes(int[] nums){
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0) nums[index++] = nums[i];
        }
        while(index < nums.length){
            nums[index++]=0;
        }
    }
}
