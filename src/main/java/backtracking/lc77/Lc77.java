package backtracking.lc77;

import java.util.ArrayList;
import java.util.List;

public class Lc77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        comb(n, k,1, new ArrayList<Integer>(), result);
        return result;
    }

    private void comb(int n, int k, int index, List<Integer> curr, List<List<Integer>> result){
        if(curr.size() == k){
            result.add(new ArrayList<Integer>(curr));
            return;
        }
        for(int i = index; i <= n; ++i){
            curr.add(i);
            comb(n, k,i + 1, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}

