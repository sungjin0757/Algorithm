package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek2169 {

    int n,m;
    int[][] arr;
    long[][][] dp;
    int[] dx=new int[]{1,0,0};
    int[] dy=new int[]{0,-1,1};
    boolean[][] check;

    private long dfs(int x,int y,int c){
        if(x==n && y==m)
            return dp[c][x][y]=arr[x][y];
        if(dp[c][x][y]!=-100000001){
            return dp[c][x][y];
        }
        check[x][y]=true;
        for(int i=0;i<3;i++){
            int xx=x+dx[i];
            int yy=y+dy[i];
            if(0<xx && xx<=n && 0<yy && yy<=m){
                if(!check[xx][yy]) {
                    dp[c][x][y] = Math.max(dp[c][x][y], dfs(xx, yy,i));
                }
            }
        }
        check[x][y]=false;
        return dp[c][x][y]+=arr[x][y];
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        arr=new int[n+1][m+1];
        dp=new long[3][n+1][m+1];
        check=new boolean[n+1][m+1];

        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<3;i++){
            for(int j=1;j<=n;j++)
                Arrays.fill(dp[i][j],-100000001);
        }

        System.out.println(dfs(1,1,0));

    }
}
