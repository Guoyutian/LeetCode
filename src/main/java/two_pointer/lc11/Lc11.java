package two_pointer.lc11;

public class Lc11 {
    public int maxArea(int[] height) {
        //two pointer,area value
        int left = 0, right = height.length - 1, result = 0, temp = 0;
        //while thery did,t meet,just update the smaller pointer
        while (left < right) {
            temp = result;
            //count the current rectangle area
            if (height[left] < height[right]) {
                temp = height[left] * (right - left);
                left++;
            } else {
                temp = height[right] * (right - left);
                right--;
            }
            //update the larger rectangle area
            if (temp > result) {
                result = temp;
            }
        }
        return result;
    }
}
