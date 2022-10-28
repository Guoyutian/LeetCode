package binary_search.lc540;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Test540 {

    private static Lc540 lc540;

    @BeforeAll
    static void initLc215(){
        lc540 = new Lc540();
    }

    @Test
    void checkResult(){
        int k = 5;
        int[] nums = new int[] {1, 1, 2, 2, 3, 3, 4, 5, 5};
        int res = lc540.singleNonDuplicate(nums);
        System.out.println(res);
    }
}