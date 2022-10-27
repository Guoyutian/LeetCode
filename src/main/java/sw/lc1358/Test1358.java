package sw.lc1358;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sw.lc438.Lc438;

import java.util.List;

public class Test1358 {
    private static Lc1358 lc1358;

    @BeforeAll
    static void initLc438(){
        lc1358 = new Lc1358();
    }

    @Test
    void checkResult(){
        String s = "abcbacb";
        int res = lc1358.numberOfSubstrings(s);
        System.out.println(res);
    }
}