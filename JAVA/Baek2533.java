package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek2533 {

    int n;
    List<Integer>[] arr;
    int[][] dp;

    private void dfs(int cur,int parent){
        dp[cur][0]=0;
        dp[cur][1]=1;

        for(int next:arr[cur]){
            if(next!=parent){
                dfs(next,cur);
                dp[cur][0]+=dp[next][1];
                dp[cur][1]+=Math.min(dp[next][0],dp[next][1]);
            }
        }
    }

    public void solve() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());
        arr=new ArrayList[n+1];
        dp=new int[n+1][2];

        for(int i=0;i<=n;i++){
            arr[i]=new ArrayList<>();
        }

        for(int i=0;i<n-1;i++){
            st=new StringTokenizer(br.readLine()," ");
            int temp1=Integer.parseInt(st.nextToken());
            int temp2=Integer.parseInt(st.nextToken());

            arr[temp1].add(temp2);
            arr[temp2].add(temp1);
        }

        dfs(1,-1);

        System.out.println(Math.min(dp[1][0],dp[1][1]));
    }
}
