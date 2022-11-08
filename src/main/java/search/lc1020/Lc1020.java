package search.lc1020;

public class Lc1020 {
    public int numEnclaves(int[][] A) {
        int count = 0;

        //Go through each boundary cell and dfs for all directions setting all 1's in path to 0's
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (i == 0 || i == A.length - 1 || j == 0 || j == A[0].length - 1) {
                    recurse(A, i, j);
                }
            }
        }

        //after replacing 1's which can lead to boundary if 1's left then increment count
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    void recurse(int[][] A, int i, int j) {
        //if you find 0 in the path or reach another boundary then return
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length || A[i][j] == 0) {
            return;
        }
        A[i][j] = 0;
        //search all directions for 1's
        recurse(A, i - 1, j);
        recurse(A, i + 1, j);
        recurse(A, i, j - 1);
        recurse(A, i, j + 1);
    }
}
