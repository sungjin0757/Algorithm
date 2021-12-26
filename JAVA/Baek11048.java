package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek11048 {

    int n,m;
    int[][] arr,dp;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        arr=new int[n+1][m+1];
        dp=new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dp[1][1]=arr[1][1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(i==1 && j==1)
                    continue;
                int x=i-1;
                int y=j-1;
                if(1<=x && x<=n){
                    dp[i][j]=Math.max(dp[x][j],dp[i][j]);
                }
                if(1<=y && y<=m){
                    dp[i][j]=Math.max(dp[i][y],dp[i][j]);
                }
                if(1<=x && x<=n && 1<=y && y<=m){
                    dp[i][j]=Math.max(dp[x][y],dp[i][j]);
                }
                dp[i][j]+=arr[i][j];
            }
        }

        System.out.println(dp[n][m]);
    }

}
