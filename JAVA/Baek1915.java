package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1915 {

    int n,m;
    int[][] dp;

    public void solve() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        dp=new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            String[] temp=br.readLine().split("");
            for(int j=1;j<=m;j++){
                dp[i][j]=Integer.parseInt(temp[j-1]);
            }
        }

        int res=0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++) {
                if(dp[i][j]==1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }

        System.out.println(res*res);

    }
}
