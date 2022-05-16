package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek11055 {

    int n;
    int[] arr,dp;

    private int dfs(int x){
        if(dp[x]!=0)
            return dp[x];
        dfs(x-1);

        for(int i=0;i<x;i++){
            if(arr[i]<arr[x])
                dp[x]=Math.max(dfs(i),dp[x]);
        }

        dp[x]+=arr[x];
        return dp[x];
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        arr=new int[n];
        dp=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        dp[0]=arr[0];
        dfs(n-1);


        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
