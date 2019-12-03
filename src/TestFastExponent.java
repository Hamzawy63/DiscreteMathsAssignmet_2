public class TestFastExponent {


    public static void main(String[] args) {
        FastExponentiation fastExponentiation = new FastExponentiation();
        // Naive 1 overflow
        System.out.println(fastExponentiation.naive2(1000 , 1000 , 1000*1000 + 9));

    }

}
