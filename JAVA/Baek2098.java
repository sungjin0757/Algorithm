package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek2098 {

    int n;
    int[][] arr;
    int[][] dp;
    int inf=16000000;

    private int dfs(int present,int visit){

        if(visit==(1<<n)-1){
            if(arr[present][1]==0)
                return inf;
            return arr[present][1];
        }

        if(dp[present][visit]!=inf)
            return dp[present][visit];

        for(int i=1;i<=n;i++){
            if((visit&(1<<(i-1)))==0 && arr[present][i]!=0)
                dp[present][visit]=Math.min(dp[present][visit],dfs(i,visit|(1<<(i-1)))+arr[present][i]);
        }

        return dp[present][visit];
    }

    public void solve() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        StringTokenizer st;

        arr=new int[n+1][n+1];
        dp=new int[n+1][(1<<n)-1];

        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<=n;i++){
            Arrays.fill(dp[i],inf);
        }

        System.out.println(dfs(1,1));
    }
}
