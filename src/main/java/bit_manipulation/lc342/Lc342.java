package bit_manipulation.lc342;

public class Lc342 {

    public boolean isPowerOfFour(int n) {
        if (n > 1) while (n % 4 == 0) n /= 4;
        return n == 1;
    }

    public boolean isPowerOfFour_bit(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0x55555555) == num);
        //0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the odd position
    }
}
