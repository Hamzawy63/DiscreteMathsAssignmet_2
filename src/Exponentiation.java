public class Exponentiation {
    public long naive1(long a , long b, long mod ){
     long res = 1;
     for(int i = 1 ; i <= b ; i++){
         res *=a;
     }
     res = res %mod;
     return res;

    }

    public long naive2(long a , long b , long mod ){
        long res = 1;

        for (int i = 1; i<=b ; i++) {
            res  =  res * res % mod ;
        }
        return res;

    }
    public long fastExponentiation(long a , long b , long mod ){

        if(b == 0 ){
            return 1;
        }else if(b%2 == 0)
        {
            long res = fastExponentiation(a , b/2 , mod ) ;
            return (res%mod  * (res%mod))%mod  ;

        }else {
            return (a%mod) * (fastExponentiation(a, b-1 , mod)%mod)%mod;

        }

    }

}
