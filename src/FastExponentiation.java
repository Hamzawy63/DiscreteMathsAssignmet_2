public class FastExponentiation {

    public long naive1(long num , long exp, long mod ){
     long res = 1;
     for(int i = 1 ; i <= exp ; i++){
         res *= num;
     }
     res = res % mod;
     return res;

    }

    public long naive2(long num , long exp , long mod ){
        long res = 1;

        for (int i = 1; i<=exp ; i++) {
            res  =  num * res % mod ;
        }
        return res;

    }
    public long recursive(long num , long exp , long mod ){

        if(exp == 0) {
            return 1;
        }else if(exp%2 == 0) {
            long res = recursive(num , exp/2 , mod ) ;
            return (res * res)%mod  ;

        }else {
            return (num%mod) * recursive(num, exp-1 , mod) %mod;

        }

    }

    public long iterative(long num, long exp, long mod) {

        long res = 1;
        while (exp!=0) {

            if (exp % 2 == 1) {

                res = res * num % mod;

            }

            exp /= 2;
            num = num * num % mod;

        }
        return res;
    }

}
