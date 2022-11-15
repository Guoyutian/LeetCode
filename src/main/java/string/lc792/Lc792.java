package string.lc792;

import java.util.ArrayList;
import java.util.HashMap;

public class Lc792 {
    /*
     * So, the main tricky point in this question is to find the indexs of the Strings in w, the characters of w must be in s with the same count of character as well as indexes need to be proper
     * for example (two pointer approach): w : "abc" and s : "aaabbbc" -> this is true.
     *               w : "abc" and s : "aaaacbb" -> this is false, because we fill find out the character b at index after index of c, and we can't go back to match 'c'.
     *
     * The brute force approach is looping over s and every String in w :- > TC : O(5*10^4 * 5000 * 50) -> O(125 * 10^8) -> TLE
     * So, to map the characters from s -> t, we can use a hashMap, and to map the indexes, we can use a arraylist of indexed for specific characters. eg : HashMap<Character, ArrayList<Integer>>
     * now, whenever we find a character, we know that the next character index should be greater than current one. So, we can simply search the index of next largest index, of the character.
     * If we are able to find that, then the subsequence will exist, else not.
     *
     * this approach is (HashMap + Binary Search), in worst case we have 26 == O(1) characters : TC : O(5000*50*log(50))
     * */

    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        HashMap<Character, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                hashMap.get(s.charAt(i)).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(s.charAt(i), list);
            }
        }

        for (String w : words) {
            if (isSubseq(w, hashMap, s)) count++;
        }
        return count;
    }

    public boolean isSubseq(String w, HashMap<Character, ArrayList<Integer>> hashMap, String s) {
        int low = -1;
        for (int i = 0; i < w.length(); i++) {
            if (hashMap.containsKey(w.charAt(i))) {
                if (low == -1) {
                    low = hashMap.get(w.charAt(i)).get(0);
                } else {
                    low = getIndex(hashMap.get(w.charAt(i)), low);
                    if (low == -1) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private int getIndex(ArrayList<Integer> list, int low) {
        int s = 0;
        int e = list.size() - 1;
        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (list.get(mid) > low) {
                ans = list.get(mid);
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return ans;
    }
}
