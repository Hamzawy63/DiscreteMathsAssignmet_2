import java.util.concurrent.ThreadLocalRandom;

public class TestGeneratePrimes
{
    public static void main(String[] args) {

        //Test for generating primes

        Primes primes = new Primes();
        for (int i = 2; i <= 32; i++) {
            System.out.println("==============================================");
            System.out.printf("We now generate a prime number of %d  bits \n",i);
            System.out.printf("\tThe random prime number is %d\n",primes.generateLargePrime(i));
            System.out.printf("\t\t\t\tTotal iterations are %d\n",primes.totalIteration);
            System.out.println("==============================================");
        }



    }
}