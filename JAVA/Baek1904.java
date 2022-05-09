package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1904 {
    int n;
    long[] dp;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        dp=new long[n+1];
        dp[1]=dp[0]=1;

        for(int i=2;i<=n;i++){
            dp[i]=dp[i-2]%15746+dp[i-1]%15746;
        }

        System.out.println(dp[n]%15746);
    }
}
