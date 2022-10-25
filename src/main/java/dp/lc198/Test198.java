package dp.lc198;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Test198 {

    private static Lc198 lc198;

    @BeforeAll
    static void initLc215(){
        lc198 = new Lc198();
    }

    @Test
    void checkResult(){
        int k = 5;
        int[] nums = new int[] {1,2,3,1};
        int res = lc198.rob(nums);
        System.out.println(res);
    }
}
