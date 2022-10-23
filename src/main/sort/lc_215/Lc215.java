package quicksort;

import java.util.Random;

class Lc215 {

    Random rand=new Random();
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums,k,0,nums.length-1);
    }
    private int quickSort(int[] nums,int k,int left,int right){
        int index=rand.nextInt(right-left+1)+left;
        int flag=nums[index];
        nums[index]=nums[left];
        int i=left,j=right;
        while (i<j){
            while (i<j&&nums[j]<=flag) j--;
            nums[i]=nums[j];
            while (i<j&&nums[i]>=flag) i++;
            nums[j]=nums[i];
        }
        nums[i]=flag;
        if (i==k-1) return nums[i];
        else if (i<k-1) return quickSort(nums,k,i+1,right);
        else return quickSort(nums,k,left,i-1);
    }
}