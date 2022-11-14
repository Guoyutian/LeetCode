package math.lc191;

public class Lc191 {
    public static int hammingWeight(int n) {
        int ones = 0;
        while (n != 0) {
            ones = ones + (n & 1);
            n = n >>> 1;
        }
        return ones;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (1 & n);
            n >>= 1;//you can also use n>>>=1
        }
        return count;
    }

    public int hammingWeight3(int n) {
        return Integer.bitCount(n);
    }
}
