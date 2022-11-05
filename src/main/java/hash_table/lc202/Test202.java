package hash_table.lc202;



import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Test202 {
    private static Lc202 lc202;

    @BeforeAll
    static void initLc202(){
        lc202 = new Lc202();
    }

    @Test
    void checkResult(){
        int k = 55;
        boolean res = lc202.isHappy(k);
        System.out.println(res);
    }
}
