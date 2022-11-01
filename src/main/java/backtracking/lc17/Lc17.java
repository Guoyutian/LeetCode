package backtracking.lc17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc17 {
    //DFS
    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        String[] lettersMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(ans, new StringBuilder(), digits, lettersMap, 0);
        return ans;
    }

    public static void backtrack(List<String> res, StringBuilder sb, String digits, String[] lettersMap, int idx) {
        if (idx == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int number = digits.charAt(idx) - '0';
        String numStr = lettersMap[number - 2];
        for (int i = 0; i < numStr.length(); i++) {
            sb.append(numStr.charAt(i));
            backtrack(res, sb, digits, lettersMap, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    //BFS
    public static List<String> letterCombinations_bfs(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (char digit : digits.toCharArray()) {
            String curLetters = letters[digit - '2'];
            List<String> newRes = new ArrayList<>();

            for (String item : res) {
                for (char curDigit : curLetters.toCharArray()) {
                    newRes.add(item + curDigit);
                }
            }
            res = newRes;
        }
        return res;
    }

    //Queue
    public static List<String> letterCombinations_queue(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        int len = digits.length();
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Queue<String> queue = new LinkedList<>();
        int[] digitsArr = new int[len];
        for (int i = 0; i < len; i++) {
            digitsArr[i] = digits.charAt(i) - '0';
        }

        queue.offer("");
        for (int i = 0; i < len; i++) {
            String letter = letters[digitsArr[i] - 2];
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String temp = queue.poll();
                for (char ch : letter.toCharArray()) {
                    queue.offer(temp + ch);
                }
            }
        }

        return new ArrayList<>(queue);
    }
}
