package back_tracking.lc306;

import java.util.ArrayList;
import java.util.List;

public class Lc306 {
    public boolean isAdditiveNumber(String num) {
        return isAdditiveNumberFrom(0, num, new ArrayList<>());
    }

    private boolean isAdditiveNumberFrom(int curIdx, String num, List<String> result) {
        if (curIdx == num.length() && result.size() >= 3) {
            return true;
        }
        for (int i = curIdx; i <= num.length() - 1; i++) {
            if (i != curIdx && num.charAt(curIdx) == '0') {
                break;
            }
            String curNum = num.substring(curIdx, i + 1);
            if (result.size() <= 1 || curNum.equals(String.valueOf(Long.parseLong(result.get(result.size() - 1)) + Long.parseLong(result.get(result.size() - 2))))) {
                result.add(curNum);
                if (isAdditiveNumberFrom(i + 1, num, result)) {
                    return true;
                }
                result.remove(result.size() - 1);
            }
        }
        return false;
    }
}
