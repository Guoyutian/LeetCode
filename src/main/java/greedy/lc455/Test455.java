package greedy.lc455;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class Test455 {
    private static Lc455 lc455;

    @BeforeAll
    static void initLc455(){
        lc455 = new Lc455();
    }

    @Test
    void checkResult(){
        int k = 2;
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{1,1};
        int res = lc455.findContentChildren(g,s);
        System.out.println(res);
    }
}
