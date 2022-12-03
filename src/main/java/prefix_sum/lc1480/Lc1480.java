package prefix_sum.lc1480;

public class Lc1480 {
    public int[] runningSum(int[] A) {
        for (int i = 1; i < A.length; ++i)
            A[i] += A[i - 1];
        return A;
    }
}
