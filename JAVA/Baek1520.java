package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1520 {

    int m,n;
    int[][] arr;
    int[] dx=new int[]{-1,0,1,0};
    int[] dy=new int[]{0,-1,0,1};
    int[][] dp;

    private int dfs(int x,int y){

        if(x==0 && y==0){
            return dp[0][0]=1;
        }

        if(dp[x][y]!=-1){
            return dp[x][y];
        }

        dp[x][y]=0;
        for(int i=0;i<4;i++){
            int xx=x+dx[i];
            int yy=y+dy[i];

            if (xx < 0 || yy < 0 || xx >= m || yy >= n) {
                continue;
            }

            if(arr[x][y]<arr[xx][yy]) {
                dp[x][y] += dfs(xx, yy);
            }
        }

        return dp[x][y];
    }

    public void solve() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());

        arr=new int[m][n];
        dp=new int[m][n];

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine()," ");

            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                dp[i][j]=-1;
            }
        }



        System.out.println(dfs(m-1,n-1));

    }

}
