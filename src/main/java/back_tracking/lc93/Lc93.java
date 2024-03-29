package back_tracking.lc93;

import java.util.ArrayList;
import java.util.List;

public class Lc93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        findValid(s, curr, result);
        return result;
    }

    private void findValid(String s, List<String> curr, List<String> result) {
        // Empty String can't be valid
        if (s.equals("")) {
            return;
        }
        // If we already have three valid IP numbers, the remaining string passed into the method should constitute
        // the 4th IP number. If it is valid, we add that set of 4 IP numbers to our valid IP address list
        if (curr.size() == 3) {
            if (checkValidNum(s)) {
                StringBuilder sb = new StringBuilder(curr.get(0));
                sb.append(".").append(curr.get(1)).append(".").append(curr.get(2)).append(".").append(s);
                result.add(sb.toString());
            }
            return;
        }
        // We can have IP address numbers of one, two, and three digits, so we try each of these options.
        // For example, if we have the string 123456, we can pick:
        // 1, and then find remaining valid IP numbers out of 23456, or
        // 12, and then find remaining valid IP numbers out of 3456, or
        // 123, and then find remaining valid IP numbers out of 456.
        //
        // The Math.min ensures we don't try to take a IP number greater than our remaining
        // IP string.
        for (int i = 1; i < Math.min(s.length(), 4); i++) {
            if (checkValidNum(s.substring(0, i))) {
                curr.add(s.substring(0, i));
                findValid(s.substring(i), curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }

    // Checks if a string is a valid IP number
    private boolean checkValidNum(String s) {
        if (s.length() > 3 || (s.length() > 1 && s.charAt(0) == '0')) {
            return false;
        }
        int num = Integer.parseInt(s);
        if (num < 0 || num > 255) {
            return false;
        }
        return true;
    }
}
