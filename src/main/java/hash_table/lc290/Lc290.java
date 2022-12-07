package hash_table.lc290;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lc290 {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        Map<Character, String> dict = new HashMap();
        Set<String> set = new HashSet();

        for (int i = 0; i < words.length; ++i) {
            char c = pattern.charAt(i);
            if (!dict.containsKey(c)) {
                if (!set.add(words[i])) {
                    return false;
                }
                dict.put(c, words[i]);
            } else if (!dict.get(c).equals(words[i])) {
                return false;
            }
        }

        return true;
    }
}
