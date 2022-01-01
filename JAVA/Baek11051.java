package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Baek11051 {
    int n,k;
    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        BigInteger[] dp=new BigInteger[n+1];
        dp[0]=BigInteger.ONE;
        dp[1]=BigInteger.valueOf(1);

        for(int i=2;i<=n;i++){
            dp[i]=(BigInteger.valueOf(i).multiply(dp[i-1]));
        }

        System.out.println(dp[n].divide(dp[k].multiply(dp[n-k])).remainder(BigInteger.valueOf(10007)).intValue());
    }
}
