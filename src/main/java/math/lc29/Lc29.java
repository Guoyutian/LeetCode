package math.lc29;

public class Lc29 {
    public int divide(int dividend, int divisor) {
        // Corner cases
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        long ldividend = (long) dividend; // To avoid integer overflow in calculations after
        if (ldividend < 0) ldividend = -ldividend;
        long ldivisor = (long) divisor; // To avoid integer overflow in calculations after
        if (ldivisor < 0) ldivisor = -ldivisor;

        // sum = ldivisor * lquotient
        long lquotient = 1, sum = ldivisor;
        while (sum < ldividend) {
            lquotient++;
            sum += ldivisor;
        }

        if (sum > ldividend) lquotient--;
        boolean isPositive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);

        return isPositive ? (int) lquotient : -(int) lquotient;
    }

    public int divide2(int dividend, int divisor) {

        long ldividend = (long) dividend, ldivisor = (long) divisor;

        boolean signNegative = false;
        if (ldividend < 0) {
            signNegative = !signNegative;
            ldividend = -ldividend;
        }
        if (ldivisor < 0) {
            signNegative = !signNegative;
            ldivisor = -ldivisor;
        }

        long result = divideRecur(ldividend, ldivisor);

        if (result > Integer.MAX_VALUE && !signNegative) {
            result = Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            result = Integer.MIN_VALUE;
        }

        return signNegative ? (int) -result : (int) result;
    }

    private long divideRecur(long dividend, long divisor) {

        if (dividend < divisor) return 0;

        long sum = divisor, quotient = 1;
        while (sum + sum < dividend) {
            sum += sum;
            quotient += quotient;
        }

        return quotient + divideRecur(dividend - sum, divisor);
    }
}
