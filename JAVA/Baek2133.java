package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2133 {
    int n;
    int[] dp;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        if(n%2==1){
            System.out.println(0);
            return;
        }
        dp=new int[n+1];
        dp[0]=1;

        for(int i=2;i<=n;i+=2){
            for(int j=0;j<=i-4;j++)
                dp[i]+=dp[j]*2;
            dp[i]+=dp[i-2]*3;
        }
        System.out.println(dp[n]);
    }
}
