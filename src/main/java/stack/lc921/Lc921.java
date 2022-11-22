package stack.lc921;

import java.util.Stack;

public class Lc921 {
    public int minAddToMakeValid(String S) {
        int left = 0, right = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                right++;
            } else if (right > 0) {
                right--;
            } else {
                left++;
            }
        }
        return left + right;
    }

    public int minAddToMakeValid2(String S) {
        Stack<Character> stack = new Stack<Character>();
        int counter = 0;
        for (int i = 0; i < S.length(); i++) {
            char temp = S.charAt(i);
            if (temp == '(') {
                stack.push(temp);
            } else if (!stack.isEmpty()) {
                stack.pop();
            } else counter++;
        }

        while (!stack.isEmpty()) {
            counter++;
            stack.pop();
        }
        return counter;
    }
}
