package sort.lc986;

import java.util.ArrayList;
import java.util.List;

public class Lc986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList();
        for (int i = 0, j = 0; i < A.length && j < B.length; ) {
            int start = Math.max(A[i][0], B[j][0]);
            int end = Math.min(A[i][1], B[j][1]);
            if (start <= end) res.add(new int[]{start, end});
            if (A[i][1] < B[j][1]) ++i;
            else ++j;
        }
        return res.toArray(new int[0][]);
    }
}
