package sliding_window.lc395;

import java.util.Arrays;

public class Lc395 {
    public int longestSubstring(String s, int k) {
        int[] counts = new int[26];
        int max = 0;
        for (int u = 1; u <= 26; ++u) {
            Arrays.fill(counts, 0);
            int left = 0;
            int right = 0;
            int unique = 0;
            int kOrMore = 0;
            while (right < s.length()) {
                if (unique <= u) {
                    char c = s.charAt(right);
                    int idx = (int) c - (int) 'a';
                    counts[idx]++;
                    if (counts[idx] == 1) {
                        ++unique;
                    }
                    if (counts[idx] == k) {
                        ++kOrMore;
                    }
                    ++right;
                } else {
                    char o = s.charAt(left);
                    int idx = (int) o - (int) 'a';
                    counts[idx]--;
                    if (counts[idx] == 0) {
                        --unique;
                    }
                    if (counts[idx] == k - 1) {
                        --kOrMore;
                    }
                    ++left;
                }
                if (unique == u && kOrMore == unique) {
                    max = Math.max(max, right - left);
                }
            }
        }
        return max;
    }
}
