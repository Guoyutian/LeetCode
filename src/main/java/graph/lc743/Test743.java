package graph.lc743;

import heap.lc378.Lc378;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Test743 {
    private static Lc743 lc743;

    @BeforeAll
    static void initLc438() {
        lc743 = new Lc743();
    }

    @Test
    void checkResult() {
        int[][] s = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int res = lc743.networkDelayTime(s, 4,2);
        System.out.println(res);
    }
}