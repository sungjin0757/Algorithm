package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2156 {

    int n;
    int[] arr,temp;
    int[][] dp;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        arr=new int[n+1];
        dp=new int[n+1][2];
        temp=new int[n+1];

        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }
        int max=temp[1]=arr[1];
        dp[1][0]=dp[1][1]=arr[1];

        for(int i=2;i<=n;i++){
            dp[i][0]=dp[i-1][1]+arr[i];
            dp[i][1]=temp[i-2]+arr[i];
            temp[i]=Math.max(dp[i][0],Math.max(dp[i][1],temp[i-1]));
            max=Math.max(dp[i][0],Math.max(max,dp[i][1]));
        }

        System.out.println(max);
    }
}
