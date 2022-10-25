package bs.lc69;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Test69 {

    private static Lc69 lc69;

    @BeforeAll
    static void initLc215(){
        lc69 = new Lc69();
    }

    @Test
    void checkResult(){
        int k = 2147395599;
        long res = lc69.mySqrt(k);
        Assertions.assertEquals(46339,res);
    }
}
