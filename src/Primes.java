import java.util.Random;

public class Primes {
    Boolean[] sieve = new Boolean[10000000];
    Random random = new Random();

    Primes() {
        /*
        initialize the array as all numbers are prime
         */
        for (int i = 0; i < sieve.length; i++) {
            sieve[i] = true;
        }
        /*
        Use the sieve of Eratosthenes we mark primes between 2 and 10000000
         */
        markPrimes();
    }

    /**
     *
     * @return a random prime  number between 2 and 10000000
     */

    public int generateRandomIntPrime() {
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
        sieve[0] = false;
        sieve[1] = false;


        for (long i = 2; i * i < 10000000; i++) {
            if (sieve[(int) i] == true) {
                for (long j = i * 2  ; j < 10000000; j += i) {
                    sieve[(int)j] = false;
                }
            }
        }

    }
}
