package math.lc204;

public class Lc204 {
    public int countPrimes(int n) {
        // isMultipleOfPrime[i] store whether num i is dividable by a prime num < i
        boolean[] isMultipleOfPrime = new boolean[n];
        // count of prime nums so far
        int count = 0;
        for (int i = 2; i < n; i++) {     // start from 2
            if (!isMultipleOfPrime[i]) {  // if i not dividable by a previous num, it's a prime
                count++;                  // count toward total num of primes seen so far
                for (int j = i; j < n; j = j + i) // mark all multiples of i as non-prime
                    isMultipleOfPrime[j] = true;
            }
        }
        return count;
    }
}
