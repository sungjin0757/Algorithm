package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2579 {

    int n;
    int[] arr;
    int[][] dp;

    private int dfs(int x,int check){
        if(x==0)
            return 0;
        if(x==1)
            return arr[x];
        if(dp[x][check]!=0)
            return dp[x][check];

        if(check==0){
            dp[x][check]=Math.max(dfs(x-1,1),dp[x][check]);
        }
        dp[x][check]=Math.max(dp[x][check],dfs(x-2,0));
        dp[x][check]+=arr[x];
        return dp[x][check];
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        dp=new int[n+1][2];
        arr=new int[n+1];

        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        System.out.println(dfs(n,0));
    }
}
