package sliding_window.lc187;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Test187 {
    private static Lc187 lc187;

    @BeforeAll
    static void initLc438(){
        lc187 = new Lc187();
    }

    @Test
    void checkResult(){
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> res = lc187.findRepeatedDnaSequences(s);
        System.out.println(res.toString());
    }
}
