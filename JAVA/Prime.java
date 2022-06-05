package simulation;

import java.util.Arrays;

public class Prime {

    static final int n=347583;

    private static boolean isPrime(int x){
        boolean check=true;

        for(int i=2;i<=(int)Math.sqrt(x);i++){
            if(x%i==0) {
                check = false;
                break;
            }
        }

        return check;
    }

    public static void main(String[] args){

        boolean[] check=new boolean[n];

        for(int i=2;i<=n-1;i++){
            if(n%i==0 && !check[i]){
                if(isPrime(i) && isPrime(n/i)){
                    check[i]=true;
                    check[n/i]=true;
                    System.out.println("p="+i+", q="+n/i);
                }
            }
        }
    }
}
