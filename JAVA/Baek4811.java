package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek4811 {

    int n;
    long[] dp;

    private void sol(int n){
        if(dp[n]==0) {
            for (int i = 4; i <= n; i++) {
                if(dp[i]!=0)
                    continue;
                long temp=0;
                for(int j=0;j<i;j++){
                    temp+=dp[j]*dp[i-j-1];
                }
                dp[i]=temp;
            }
        }
        System.out.println(dp[n]);
    }

    public void solve() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        dp=new long[31];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        dp[3]=5;

        while(true){
            n=Integer.parseInt(br.readLine());

            if(n==0)
                break;

            sol(n);
        }
    }
}
