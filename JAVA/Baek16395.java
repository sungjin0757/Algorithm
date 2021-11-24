package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Baek16395 {

    int n,k;
    BigInteger[] dp;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        if(k==1){
            System.out.println(1);
        }else if(k==n){
            System.out.println(1);
        }else if(n==1 || n==2){
            System.out.println(1);
        }else if(k!=1 && n!=1 && n!=2){
            dp=new BigInteger[n];
            dp[0]=BigInteger.valueOf(0);
            dp[1]=BigInteger.valueOf(1);
            for(int i=2;i<n;i++){
                dp[i]=dp[i-1].multiply(BigInteger.valueOf(i));
            }
            System.out.println(dp[n-1].divide(dp[k-1].multiply(dp[n-k])));
        }
    }
}
