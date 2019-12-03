public class ExtendedEuclidean {


    public void extendedEuclidean(long a , long b){
        Pair res  = getBezoutCoeff(a ,b );
        long x = res.a;
        long y = res.b;
        long gcd = gcd(a,b);
        System.out.printf("Greatest common divisor of %d and %d is %d  \n",a,b,gcd);
        System.out.printf("Bezout coefficients are  %d and %d\n",x ,y );
        System.out.printf("%d = %d * %d + %d * %d\n", gcd , a, x , b, y);
    }

    // we could use extended euclidean to get the gcd but we are here trying to avoid overflow :)
    private long gcd(long a,long b)
    {
        if(b == 0){
            return a;
        }else
            return gcd(b,a%b);

    }

    private  Pair getBezoutCoeff(long a , long b ){
        if(b == 0)
        {
            return new Pair(1,0);
        }
        Pair getCoefficients = getBezoutCoeff(b , a%b );
        long x2 = getCoefficients.a;
        long y2 = getCoefficients.b;
        long x1 = y2;
        long y1 = x2 - a/b * y2 ;
        return new Pair(x1 , y1);



    }

    private class Pair{
        long a ;
        long b ;

        public Pair(long a, long b) {
            this.a = a;
            this.b = b;
        }
    }


}
