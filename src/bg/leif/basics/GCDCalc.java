package bg.leif.basics;

/**
 * Created by leif on 15/03/15.
 *
 * A class that calculates the greatest common divisor of two integers
 *
 * interesting link regarding RSA keys: http://www.loyalty.org/~schoen/rsa/
 */
public class GCDCalc {

    private int m,n;

    public GCDCalc(int m, int n){
        this.m = m;
        this.n = n;
    }

    public int caclulateGCD(){

        int gcd = -1;

        while(this.m != 0){
            switchNumbers();
            gcd = m % n;
            this.m = gcd;
        }
        return this.n;
    }

    /**
     * method switches values of integers
     */
    private void switchNumbers(){
        if(this.m < this.n){
            int tmp = this.m;
            this.m = this.n;
            this.n = tmp;
        }
    }
    /**
     *
     * passing primitives as method parameters won't switch them!
     * pass-by-value for primitives
     * using this overloaded method will result in endless loop
     */
    private void switchNumbers(int m, int n){
        if(m < n){
            int tmp = m;
            m = n;
            n = tmp;
        }
    }
}
