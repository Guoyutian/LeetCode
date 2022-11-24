package dp.lc139;

import java.util.List;

public class Lc139 {
    public boolean wordBreak(String s, List<String> dict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String str : dict) {
                if (str.length() <= i) {
                    if (f[i - str.length()]) {
                        if (s.substring(i - str.length(), i).equals(str)) {
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        return f[s.length()];
    }
}
