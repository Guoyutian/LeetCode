package sliding_window.lc1358;

public class Lc1358 {
    public int numberOfSubstrings(String s) {
        int n = s.length(), ans=0,left=0,right=0;
        char[] str = s.toCharArray();
        int[] count = new int[3]; // stores count of a,b,c;
        while(right<n){
            count[str[right]-'a']++;
            while(left<right && count[0]>0 && count[1]>0 && count[2]>0){
                ans += n-right; //count the substrings
                count[str[left++]-'a']--; //move left boundry while decreasing the count
            }
            right++;
        }
        return ans;
    }
}
