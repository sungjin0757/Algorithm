package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1912 {
    int n;
    long[] arr,dp;

    private long dfs(int x){
        if(x==0)
            return dp[x]=arr[x];
        dp[x]=Math.max(arr[x],dfs(x-1)+arr[x]);
        return dp[x];
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        arr=new long[n];
        dp=new long[n];

        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        dfs(n-1);
        System.out.println(Math.max(Arrays.stream(dp).max().getAsLong(),Arrays.stream(arr).max().getAsLong()));
    }
}
