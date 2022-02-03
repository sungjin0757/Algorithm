package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1328 {

    int n,l,r;
    long[][][] dp;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        l=Integer.parseInt(st.nextToken());
        r=Integer.parseInt(st.nextToken());

        dp=new long[n+1][l+1][r+1];

        dp[1][1][1]=1;

        for(int i=2;i<=n;i++){
            for(int j=1;j<=l;j++){
                for(int k=1;k<=r;k++){
                    dp[i][j][k]=(dp[i-1][j][k]*(i-2)+dp[i-1][j-1][k]+dp[i-1][j][k-1])%1000000007;
                }
            }
        }
        System.out.println(dp[n][l][r]);
    }
}
