package dp.lc_70;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class Test70 {
    private static Lc70 lc70;

    @BeforeAll
    static void initLc215(){
        lc70 = new Lc70();
    }

    @Test
    void checkResult(){
        int k = 5;
        int res = lc70.climbStairs(k);
        System.out.println(res);
    }
}
