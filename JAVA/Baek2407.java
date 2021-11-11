package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Baek2407 {

    int n,m;
    BigInteger[] dp;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        dp=new BigInteger[n+1];
        dp[0]=BigInteger.ONE;
        for(int i=1;i<=n;i++){
            dp[i]=dp[i-1].multiply(BigInteger.valueOf(i));
        }

        System.out.println(dp[n].divide(dp[n-m].multiply(dp[m])));
    }
}
