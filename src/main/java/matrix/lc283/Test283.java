package matrix.lc283;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Test283 {
    private static Lc283 lc283;

    @BeforeAll
    static void initLc438(){
        lc283 = new Lc283();
    }

    @Test
    void checkResult(){
        int[] nums = new int[]{0,1,0,3,12} ;
        lc283.moveZeroes(nums);
        System.out.println(nums.toString());
    }
}
