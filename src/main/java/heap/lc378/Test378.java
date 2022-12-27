package heap.lc378;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sliding_window.lc1358.Lc1358;

public class Test378 {
    private static Lc378 lc378;

    @BeforeAll
    static void initLc438() {
        lc378 = new Lc378();
    }

    @Test
    void checkResult() {
        int[][] s = {{1, 10, 9}, {5, 11, 13}, {12, 13, 15}};
        int res = lc378.kthSmallest(s, 2);
        System.out.println(res);
    }
}
