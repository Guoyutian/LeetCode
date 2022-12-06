package bit_manipulation.lc89;

import java.util.ArrayList;
import java.util.List;

public class Lc89 {
    public List<Integer> grayCode(int n) {
        List<Integer> rs = new ArrayList<Integer>();
        rs.add(0);
        for (int i = 0; i < n; i++) {
            int size = rs.size();
            for (int k = size - 1; k >= 0; k--)
                rs.add(rs.get(k) | 1 << i);
        }
        return rs;
    }
}
