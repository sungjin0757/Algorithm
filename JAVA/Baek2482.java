package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2482 {

    int n,k;
    int[][] dp;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        k=Integer.parseInt(br.readLine());

        dp=new int[n+1][n+1];

        for(int i=1;i<=n;i++) {
            dp[i][1] = i;
            dp[i][0]=1;
        }

        for(int i=3;i<=n;i++){
            for(int j=2;j<=(i+1)/2;j++){
                dp[i][j]=(dp[i-2][j-1]%1000000003+dp[i-1][j]%1000000003)%1000000003;
            }
        }

        System.out.println((dp[n-3][k-1]%1000000003+dp[n-1][k]%1000000003)%1000000003);

    }
}
