package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baek12865 {

    int n,k;
    int[][] dp;

    public void solve() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        dp=new int[n+1][k+1];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine()," ");
            int w=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            for(int j=1;j<=k;j++){
                dp[i+1][j]=j<w ? dp[i][j]:Math.max(dp[i][j],v+dp[i][j-w]);
            }
        }


        System.out.println(dp[n][k]);
    }
}
