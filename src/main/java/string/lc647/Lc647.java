package string.lc647;

public class Lc647 {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            count += extractPalindrome(s,i,i);   //To check the palindrome of odd length palindromic sub-string
            count += extractPalindrome(s,i,i + 1);   //To check the palindrome of even length palindromic sub-string
        }
        return count;
    }
    public int extractPalindrome(String s, int left, int right){
        int count = 0;
        while(left >=0 && right < s.length() && (s.charAt(left) == s.charAt(right))){//Check for the palindrome string
            left--;  //To trace string in left direction
            right++; //To trace string in right direction
            count++; //Increment the count if palindromin substring found
        }
        return count;
    }
}
