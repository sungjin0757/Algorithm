package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1103 {

    int n,m;
    int[][] arr,dp;
    int[] dx=new int[]{-1,1,0,0};
    int[] dy=new int[]{0,0,-1,1};
    boolean check;
    boolean[][] visited;


    private int dfs(int x,int y){
        if( x>n || y>m || x<1 || y<1)
            return 0;
        if(arr[x][y]==-1)
            return 0;
        if(dp[x][y]!=0)
            return dp[x][y];
        if(check)
            return 0;

        visited[x][y]=true;

        for(int i=0;i<4;i++){
            int xx=x+dx[i]*arr[x][y];
            int yy=y+dy[i]*arr[x][y];
            if(1<=xx && xx<=n && 1<=yy && yy<=m){
                if(visited[xx][yy]){
                    check=true;
                    return 0;
                }
            }
            dp[x][y]=Math.max(dp[x][y],dfs(xx,yy)+1);
        }
        visited[x][y]=false;

        return dp[x][y];
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        arr=new int[n+1][m+1];
        dp=new int[n+1][m+1];
        visited=new boolean[n+1][m+1];

        for(int i=1;i<=n;i++){
            String[] temp=br.readLine().split("");

            for(int j=1;j<=m;j++){
                if(temp[j-1].equals("H")){
                    arr[i][j]=-1;
                    continue;
                }
                arr[i][j]=Integer.parseInt(temp[j-1]);
            }
        }

        int res=dfs(1,1);
        if(check){
            System.out.println(-1);
            return;
        }
        System.out.println(res);
    }
}
