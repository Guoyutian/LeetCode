package search.lc547;

import java.util.LinkedList;
import java.util.Queue;

public class Lc547 {
    //DFS
    public int findCircleNum_DFS(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    //BFS
    public int findCircleNum_BFS(int[][] M) {
        int count = 0;
        for (int i = 0; i < M.length; i++)
            if (M[i][i] == 1) {
                count++;
                bfs(i, M);
            }
        return count;
    }

    public void bfs(int student, int[][] M) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(student);
        while (queue.size() > 0) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int j = queue.poll();
                M[j][j] = 2; // marks as visited
                for (int k = 0; k < M[0].length; k++)
                    if (M[j][k] == 1 && M[k][k] == 1) queue.add(k);
            }
        }
    }
}
