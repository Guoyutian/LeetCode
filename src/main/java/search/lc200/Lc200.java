package search.lc200;

public class Lc200 {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int cnt = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == '1') {
                    DFS(grid, i, j, m, n);
                    cnt++;
                }
        return cnt;
    }

    private void DFS(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;
        grid[i][j] = '0';
        for (int[] dir : dirs){
            DFS(grid, i + dir[0], j + dir[1], m, n);
        }
    }
}
