package matrix.lc645;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Test645 {
    private static Lc645 lc645;

    @BeforeAll
    static void initLc202(){
        lc645 = new Lc645();
    }

    @Test
    void checkResult(){
        int[] num = new int[]{1, 2, 2, 4};
        int[] res = lc645.findErrorNums(num);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}

