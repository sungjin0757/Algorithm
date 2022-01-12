package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1562 {

    int n;
    long[][][] dp;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        dp=new long[n+1][10][1<<10];

        for(int i=1;i<=9;i++){
            dp[1][i][1<<i]=1;
        }

        for(int i=2;i<=n;i++){
            for(int j=0;j<=9;j++){
                for(int k=0;k<(1<<10);k++){
                    if(j==0){
                        dp[i][j][k|1<<0]=(dp[i][0][k|1<<0]+dp[i-1][1][k]) % 1000000000;
                    }else if(j==9){
                        dp[i][j][k|1<<9]=(dp[i][9][k|1<<9]+dp[i-1][8][k])% 1000000000;
                    }else{
                        dp[i][j][k|1<<j]=(dp[i-1][j-1][k]+dp[i-1][j+1][k]+dp[i][j][k|1<<j])% 1000000000;
                    }
                }
            }
        }

        long sum=0;
        for(int i=0;i<=9;i++){
            sum=(sum+dp[n][i][(1<<10)-1])% 1000000000;
        }
        System.out.println(sum);
    }
}
