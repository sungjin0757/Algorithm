package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1149 {

    int n;
    int[][] arr,dp;

    private int dfs(int x,int pre){
        if(x==1){
            return dp[x][pre]=arr[x][pre];
        }
        if(dp[x][pre]!=10000000)
            return dp[x][pre];
        for(int i=0;i<3;i++){
            if(i!=pre){
                dp[x][pre]=Math.min(dfs(x-1,i),dp[x][pre]);
            }
        }
        dp[x][pre]+=arr[x][pre];
        return dp[x][pre];
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        StringTokenizer st;

        arr=new int[n+1][3];
        dp=new int[n+1][3];

        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<3;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp[i],10000000);
        }

        System.out.println(Math.min(dfs(n,0),Math.min(dfs(n,1),dfs(n,2))));
    }
}
