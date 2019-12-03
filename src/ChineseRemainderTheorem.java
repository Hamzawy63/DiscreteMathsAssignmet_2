public class ChineseRemainderTheorem {

    private long[] remainders;

    /**
     * the arr is between 1 to 6 length and its element should be coprime to each other and belong to Zm
     */
    public ChineseRemainderTheorem(long ... remainders) {

        this.remainders = remainders;

    }

    public long add(long a, long b) { return solve(a,b,'+'); }
    public long multiply(long a, long b) { return solve(a,b,'*'); }

    private long solve(long a, long b, char c) {

        long[] A = new long[remainders.length],M= new long[remainders.length],Y = new long[remainders.length];
        long m=1,x=0;
        ExtendedEuclidean extendedEuclidean = new ExtendedEuclidean();;

        if (c=='*') for (int i = 0; i < remainders.length; i++) {

            A[i] = (a % remainders[i] * b % remainders[i]) % remainders[i];

        } else {
            for (int i = 0; i < remainders.length; i++) {

                A[i] = (a % remainders[i] + b % remainders[i]) % remainders[i];

            }
        }

        for (int i = 0; i < remainders.length; i++) {

            m *= remainders[i];

        }

        for (int i = 0; i < remainders.length; i++) {

            M[i] = m/remainders[i];
            Y[i] = extendedEuclidean.getMultiplicativeInverse(M[i],remainders[i]);

        }

        for (int i = 0; i < remainders.length; i++) {

            x = ( x + (M[i] * Y[i] * A[i]) % m) % m ;

        }

        return x % m;
    }

}
