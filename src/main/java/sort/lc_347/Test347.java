package sort.lc_347;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Test347 {
    private static Lc347 lc347;

    @BeforeAll
    static void initLc347(){
        lc347 = new Lc347();
    }

    @Test
    void checkResult(){
        int k = 2;
        int[] nums = new int[]{1,1,1,2,2,3};
        int[] res = lc347.topKFrequent(nums,k);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}