package bit_manipulation.lc371;

public class Lc371 {
    // Iterative
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }

        return a;
    }

    // Iterative
    public int getSubtract(int a, int b) {
        while (b != 0) {
            int borrow = (~a) & b;
            a = a ^ b;
            b = borrow << 1;
        }

        return a;
    }

    // Recursive
    public int getSum_rec(int a, int b) {
        return (b == 0) ? a : getSum_rec(a ^ b, (a & b) << 1);
    }

    // Recursive
    public int getSubtract_rec(int a, int b) {
        return (b == 0) ? a : getSubtract_rec(a ^ b, (~a & b) << 1);
    }

    // Get negative number
    public int negate(int x) {
        return ~x + 1;
    }
}
