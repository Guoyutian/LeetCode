package heap.lc414;

import heap.lc378.Lc378;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Test414 {
    private static Lc414 lc414;

    @BeforeAll
    static void initLc414() {
        lc414 = new Lc414();
    }

    @Test
    void checkResult() {
        int[] s = {2, 2, 3, 1};
        int res = lc414.thirdMax(s);
        System.out.println(res);
    }
}
