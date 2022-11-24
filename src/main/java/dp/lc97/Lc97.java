package dp.lc97;

public class Lc97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 + n2 != s3.length()) return false;
        boolean dp[][] = new boolean[n1 + 1][n2 + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n2; j++) {//initializing 0th row
            if (s2.charAt(j - 1) == s3.charAt(j - 1)) dp[0][j] = dp[0][j - 1];
        }
        for (int i = 1; i <= n1; i++) {//initializing 0th column
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) dp[i][0] = dp[i - 1][0];
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {//the length of s3 is n1+n2, since the string is 0 indexed we check at i+j-1
                if (s3.charAt(i + j - 1) == s1.charAt(i - 1)) dp[i][j] = dp[i - 1][j];
                if (s3.charAt(i + j - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i][j] || dp[i][j - 1];
                //In some cases the character from s3 matches both s1 and s2, therefore we consider the value thats true
            }
        }
        return dp[n1][n2];
    }
}
