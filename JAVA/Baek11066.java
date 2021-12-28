package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek11066 {

    int t,k;
    int[] arr,res,sum;
    int[][] dp;

    private int dfs(int x,int y){
        if(x==y)
            return dp[x][y]=0;
        if(x+1==y)
            return dp[x][y]=arr[x]+arr[y];
        if(dp[x][y]!=Integer.MAX_VALUE)
            return dp[x][y];
        for(int i=x;i<y;i++){
            int left=dfs(x,i);
            int right=dfs(i+1,y);
            dp[x][y]=Math.min(dp[x][y],left+right);
        }
        return dp[x][y]+=sum[y]-sum[x-1];
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());
        res=new int[t];

        for(int i=0;i<t;i++){
            k=Integer.parseInt(br.readLine());
            arr=new int[k+1];
            dp=new int[k+1][k+1];
            sum=new int[k+1];

            StringTokenizer st=new StringTokenizer(br.readLine()," ");

            for(int j=1;j<=k;j++){
                Arrays.fill(dp[j],Integer.MAX_VALUE);
                arr[j]=Integer.parseInt(st.nextToken());
                sum[j]=sum[j-1]+arr[j];
            }

            System.out.println(dfs(1,k));
        }
    }
}
