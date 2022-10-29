package two_pointer.lc27;

/****
 Steps:
 copy element when nums[right] != val
 maintain another pointer last which will keep track of elements till now as a part of ans
 ****/

class Lc27 {
    public int removeElement(int[] nums, int val) {
        if(nums == null) return 0;
        int last = 0;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] != val){
                //copy element to last and increment last
                nums[last++] = nums[right];
            }
        }
        return last;
    }
}
