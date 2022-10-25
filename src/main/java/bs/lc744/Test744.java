package bs.lc744;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Test744 {

    private static Lc744 lc744;

    @BeforeAll
    static void initLc215(){
        lc744 = new Lc744();
    }

    @Test
    void checkResult(){
        int k = 5;
        char[] chars = new char[] {'a','c','g','r','y'};
        char res = lc744.nextGreatestLetter(chars,'d');
        System.out.println(res);
    }
}
