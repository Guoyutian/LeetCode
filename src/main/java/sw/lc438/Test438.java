package sw.lc438;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Test438 {
    private static Lc438 lc438;

    @BeforeAll
    static void initLc438(){
        lc438 = new Lc438();
    }

    @Test
    void checkResult(){
        String s = "cbaebabacd", p = "abc";
        List<Integer> res = lc438.findAnagrams(s,p);
        System.out.println(res.toString());
    }
}
