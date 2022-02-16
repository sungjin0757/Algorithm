package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek14916 {

    int n;
    int[] dp;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        dp=new int[n+1];
        dp[1]=0;

        for(int i=2;i<=n;i++){
            if(i==2 || i==5){
                dp[i]=1;
                continue;
            }
            if(dp[i-2]!=0)
                dp[i]=dp[i-2]+1;
            if(i>=5){
                if(dp[i-5]!=0)
                    dp[i]=Math.min(dp[i],dp[i-5]+1);
            }
        }
        if(dp[n]==0){
            System.out.println(-1);
            return;
        }
        System.out.println(dp[n]);
    }
}
