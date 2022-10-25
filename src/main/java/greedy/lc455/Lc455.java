package greedy.lc455;

import java.util.Arrays;

public class Lc455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int indexG = 0, indexS = 0, res = 0;
        while (indexG < g.length && indexS < s.length) {
            if (g[indexG] <= s[indexS]) {
                res++;
                indexG++;
                indexS++;
            } else {
                indexS++;
            }
        }
        return res;
    }
}