package dp;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek5557 {

    int n;
    int[] arr;
    long[][] dp;

    private long dfs(int x,int temp){

        if(temp<0 || temp>20)
            return 0;
        if(x==n-1){
            if(temp==arr[n]) {
                return 1;
            }
            return 0;
        }
        if(dp[x][temp]!=0)
            return dp[x][temp];

        dp[x][temp]+=dfs(x+1,temp+arr[x+1])+dfs(x+1,temp-arr[x+1]);

        return dp[x][temp];
    }
    public void solve() throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        arr=new int[n+1];

        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        dp=new long[n+1][21];

        System.out.println(dfs(1,arr[1]));

    }
}
