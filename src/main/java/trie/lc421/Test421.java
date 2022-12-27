package trie.lc421;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import trie.lc421.Lc421;

public class Test421 {
    private static Lc421 lc421;

    @BeforeAll
    static void initLc438(){
        lc421 = new Lc421();
    }

    @Test
    void checkResult(){
        int[] s = {3,10,5,25,2,8};
        int res = lc421.findMaximumXOR(s);
        System.out.println(res);
    }
}