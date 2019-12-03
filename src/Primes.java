import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class Primes {
    Boolean[] sieve = new Boolean[10000000];
    static long totalIteration = 0; // We use this variable for calculating an estimate on number of calculations when generating a random prime numbers

    FastExponentiation fastExponentiation = new FastExponentiation();

    Primes() {
        markPrimes();
    }

    /**
     * @return a random prime  number between 2 and 10000000
     */

    public int generateRandomIntPrime() {
        Random random = new Random();
        int target = 0;
        while (!sieve[target]) {
            target = random.nextInt(10000000);
        }
        return target;
    }

    /*
    Generate the sieve of eratothenis algorithm to mark the primes in the array
     */
    private void markPrimes() {
        for (int i = 0; i < sieve.length; i++) {
            sieve[i] = true;
        }
        sieve[0] = false;
        sieve[1] = false;


        for (long i = 2; i * i < 10000000; i++) {
            if (sieve[(int) i] == true) {
                for (long j = i * 2; j < 10000000; j += i) {
                    sieve[(int) j] = false;
                }
            }
        }

    }

    public long generateLargePrime(long numberOfBits) {
        totalIteration = 0;
        numberOfBits = Math.max(2, numberOfBits);
        numberOfBits = Math.min(32, numberOfBits);
        long min = fastExponentiation.recursive(2,numberOfBits - 1,Long.MAX_VALUE);
        long max = fastExponentiation.recursive(2,numberOfBits ,Long.MAX_VALUE) - 1;
        long randomNum = ThreadLocalRandom.current().nextLong(min, max);
        while (!isPrime(randomNum, 5)) {
            randomNum = ThreadLocalRandom.current().nextLong(min, max);
//            if(new BigInteger(String.valueOf(randomNum)).isProbablePrime(5) == true){
//                System.out.println("Error detected");
//            }
        }
        return randomNum;
    }

    boolean miillerTest(long d, long n) {

        // Pick a random number in [2..n-2]
        // Corner cases make sure that n > 4
        long a = 2 + (long) (Math.random() % (n - 4));

        // Compute a^d % n
        long x = fastExponentiation.recursive(a, d, n);

        if (x == 1 || x == n - 1)
            return true;

        // Keep squaring x while one of the
        // following doesn't happen
        // (i) d does not reach n-1
        // (ii) (x^2) % n is not 1
        // (iii) (x^2) % n is not n-1
        while (d != n - 1) {
            x = fastExponentiation.recursive(a, d, n);
            d *= 2;
            totalIteration++;

            if (x == 1)
                return false;
            if (x == n - 1)
                return true;
        }

        // Return composite
        return false;
    }

    // It returns false if n is composite
    // and returns true if n is probably
    // prime. k is an input parameter that
    // determines accuracy level. Higher
    // value of k indicates more accuracy.
    boolean isPrime(long n, int k) {

        // Corner cases
        if (n <= 1 || n == 4)
            return false;
        if (n <= 3)
            return true;

        // Find r such that n = 2^d * r + 1
        // for some r >= 1
        long d = n - 1;

        while (d % 2 == 0) {
            totalIteration++;
            d /= 2;
        }

        // Iterate given nber of 'k' times
        for (int i = 0; i < k; i++) {
            totalIteration++;
            if (!miillerTest(d, n))
                return false;
        }
        return true;
    }
}
