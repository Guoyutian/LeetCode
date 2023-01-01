package graph.lc797;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Lc797 {
    //DFS
    public List<List<Integer>> allPathsSourceTargetByDfs(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        dfs(graph, ans, temp, 0);
        return ans;
    }

    public void dfs(int[][] graph, List<List<Integer>> ans, List<Integer> temp, int start) {
        if (start == graph.length - 1) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i : graph[start]) {
            temp.add(i);
            dfs(graph, ans, temp, i);
            temp.remove(temp.size() - 1);
        }

    }

    //BFS
    public List<List<Integer>> allPathsSourceTargetByBfs(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> currList = new ArrayList<>();
        currList.add(0);
        q.add(currList);
        while (!q.isEmpty()) {
            currList = q.poll();
            int v = currList.get(currList.size() - 1);
            if (v == graph.length - 1) {
                ans.add(currList);
                continue;
            }
            for (int i : graph[v]) {
                List<Integer> temp = new ArrayList<>(currList);
                temp.add(i);
                q.add(temp);
            }
        }
        return ans;
    }
}
