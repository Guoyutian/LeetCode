package sliding_window.lc187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Lc187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 10) return result;
        int start = 0;
        int end = 0;
        Map<String, Integer> map = new HashMap<>();

        while (end < s.length()) {
            if (end - start + 1 < 10) {
                end++;
            } else if (end - start + 1 == 10) {
                String st = s.substring(start, end+1);
                map.put(st, map.getOrDefault(st, 0)+1);
                if (map.get(st) == 2) {
                    result.add(st);
                }
                end++;
                start++;
            }
        }
        return result;
    }
}
