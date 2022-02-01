package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek10835 {

    int n;
    int[] left,right;
    int[][] dp;

    private int dfs(int l,int r){
        if(l==n+1 || r==n+1)
            return 0;
        if(dp[l][r]!=-1)
            return dp[l][r];
        dp[l][r]=Math.max(dp[l][r],dfs(l+1,r+1));
        dp[l][r]=Math.max(dp[l][r],dfs(l+1,r));
        if(left[l]>right[r]){
            dp[l][r]=Math.max(dp[l][r],dfs(l,r+1)+right[r]);
        }
        return dp[l][r];
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        left=new int[n+1];
        right=new int[n+1];
        dp=new int[n+1][n+1];

        for(int i=0;i<2;i++){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=n;j++){
                if(i==0){
                    left[j]=Integer.parseInt(st.nextToken());
                }else if(i!=0){
                    right[j]=Integer.parseInt(st.nextToken());
                }
            }
        }

        for(int i=1;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(dfs(1,1));
    }
}
