package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1890 {

    int n;
    int[][] arr;
    Long[][] dp;

    private long dfs(int x,int y){
        if(x==n-1 && y==n-1)
            return 1;
        if(arr[x][y]==0)
            return 0;
        if(dp[x][y]!=null)
            return dp[x][y];
        dp[x][y]=0l;
        int xx=x+arr[x][y];
        int yy=y+arr[x][y];

        if(0<=xx && xx<n){
            dp[x][y]+=dfs(xx,y);
        }
        if(0<=yy && yy<n){
            dp[x][y]+=dfs(x,yy);
        }
        return dp[x][y];
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        arr=new int[n][n];
        dp=new Long[n][n];

        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(dfs(0,0));
    }

}
