package quicksort;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Lc215Test {
    private static Lc215 lc215;

    @BeforeAll
    static void initD0127p3(){
        lc215 = new Lc215();
    }

    @Test
    void checkResult(){
        int k = 2;
        int[] nums = new int[]{3,2,1,5,6,4};
        int res = lc215.findKthLargest(nums,k);
        System.out.println(res);
    }
}
