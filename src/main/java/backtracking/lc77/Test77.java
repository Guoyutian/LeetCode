package backtracking.lc77;

import binary_search.lc69.Lc69;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Test77 {
        private static Lc77 lc77;

        @BeforeAll
        static void initLc215(){
            lc77 = new Lc77();
        }

        @Test
        void checkResult(){
            int n = 4, k = 2;
            List res = lc77.combine(n,k);
            System.out.println(res);
        }
    }

