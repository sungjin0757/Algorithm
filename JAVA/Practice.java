package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice{

    int n;
    int[] arr,dp;

    private int dfs(int x){

        if(x==0)
            return 0;

        dfs(x-1);

        for(int i=x-1;i>0;i--){
            if(arr[x]>arr[i]){
                dp[x]=Math.max(dp[i],dp[x]);
            }
        }

        dp[x]+=arr[x];

        return dp[x];
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());

        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        arr=new int[n+1];
        for(int i=1;i<n+1;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        arr[0]=Integer.MIN_VALUE;
        dp=new int[n+1];
        dfs(n);

        for (int i : dp) {
            System.out.println(i);
        }
    }
}
