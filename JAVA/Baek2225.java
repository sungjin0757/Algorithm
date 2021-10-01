package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2225 {

    int n,k;

    public void solve() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        int[][] dp=new int[k+1][n+1];

        for(int i=1;i<=k;i++){
            dp[i][1]=i;
        }

        for(int i=1;i<=n;i++){
            dp[1][i]=1;
        }

        for(int i=2;i<=k;i++){
            for(int j=2;j<=n;j++){
                dp[i][j]=(dp[i-1][j]+dp[i][j-1])%1000000000;
            }
        }

        System.out.println(dp[k][n]);
    }
}
