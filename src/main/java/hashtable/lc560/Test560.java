package hashtable.lc560;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Test560 {
    private static Lc560 lc560;

    @BeforeAll
    static void initLc202(){
        lc560 = new Lc560();
    }

    @Test
    void checkResult(){
        int k = 3;
        int[] nums = new int[] {1, 2, 0, 2, 1, 2, 1, 6};
        int res = lc560.subarraySum(nums, k);
        System.out.println(res);
    }
}

