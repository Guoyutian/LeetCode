package matrix.lc73;

public class Lc73 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        boolean firstRowToSet = false, firstColToSet = false;
        int row = matrix.length, col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                firstColToSet = true;
                break;
            }
        }
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                firstRowToSet = true;
                break;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        if (firstColToSet) {
            for (int i = 0; i < row; i++) matrix[i][0] = 0;
        }
        if (firstRowToSet) {
            for (int j = 0; j < col; j++) matrix[0][j] = 0;
        }
    }
}
