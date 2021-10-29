package dp;

import java.io.*;
import java.util.*;

public class Baek1463 {

    int n;
    int[] dp;

    private int dfs(int x){
        if(x==0 || x==1)
            return dp[x]=0;

        if(dp[x]==-1){
            if(x%6==0)
                dp[x]=Math.min(dfs(x/3),Math.min(dfs(x/2),dfs(x-1)))+1;
            else if(x%3==0)
                dp[x]=Math.min(dfs(x/3),dfs(x-1))+1;
            else if(x%2==0)
                dp[x]=Math.min(dfs(x/2),dfs(x-1))+1;
            else
                dp[x]=dfs(x-1)+1;
        }
        return dp[x];
    }
    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        dp=new int[n+1];

        Arrays.fill(dp,-1);

        System.out.println(dfs(n));

    }

}
