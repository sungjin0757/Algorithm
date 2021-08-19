package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1937 {

    int n;
    int[][] arr;
    int[] dx={-1,0,1,0};
    int[] dy={0,1,0,-1};
    int[][] dp;


    private int dfs(int x,int y){

        if(dp[x][y]!=0)
            return dp[x][y];


        for(int i=0;i<4;i++){
            int xx=dx[i]+x;
            int yy=dy[i]+y;
            if(xx>=1 && xx<=n && yy>=1 && yy<=n){
                if(arr[xx][yy]>arr[x][y]) {
                    dp[x][y] = Math.max(dfs(xx, yy)+1,dp[x][y]);
                }
            }
        }

        return dp[x][y];
    }

    public void solve() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());

        dp=new int[n+1][n+1];
        arr=new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }


        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                dfs(i,j);
            }
        }

        int res=Integer.MIN_VALUE;

        for(int i=1;i<=n;i++){
            int temp= Arrays.stream(dp[i]).max().getAsInt();
            res=Math.max(res,temp);
        }

        System.out.println(res+1);


    }
}
