import java.util.concurrent.ThreadLocalRandom;

public class ExtendedEuclideanTest {
    public static void main(String[] args) {
        ExtendedEuclidean extendedEuclidean = new ExtendedEuclidean();
        for (int i = 0; i <15 ; i++) {
            long a = ThreadLocalRandom.current().nextInt(1 , 10000);
            long b = ThreadLocalRandom.current().nextInt(1,10000);
            extendedEuclidean.extendedEuclidean(a , b);
            System.out.println("====================================");
        }

    }
}
