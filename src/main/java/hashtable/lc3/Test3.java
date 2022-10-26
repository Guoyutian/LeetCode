package hashtable.lc3;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Test3 {
    private static Lc3 lc3;

    @BeforeAll
    static void initLc202(){
        lc3 = new Lc3();
    }

    @Test
    void checkResult(){
        String k = "pwwkew";
        int res = lc3.lengthOfLongestSubstring(k);
        System.out.println(res);
    }
}
