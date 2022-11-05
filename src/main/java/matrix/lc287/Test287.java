package matrix.lc287;

import matrix.lc645.Lc645;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class Test287 {
        private static Lc287 lc287;

        @BeforeAll
        static void initLc202(){
            lc287 = new Lc287();
        }

        @Test
        void checkResult(){
            int[] num = new int[]{1,3,4,2,2};
            int res = lc287.findDuplicate_mark(num);
            System.out.println(res);
        }
}
