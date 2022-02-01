package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek2240 {

    int t,w;
    int[] arr;
    int[][] dp;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        t=Integer.parseInt(st.nextToken());
        w=Integer.parseInt(st.nextToken());

        arr=new int[t+1];
        dp=new int[t+1][w+1];

        for(int i=1;i<=t;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        for(int i=1;i<=t;i++){
            for(int j=0;j<=w;j++){
                if(j==0){
                    if(arr[i]==1)
                        dp[i][j]=dp[i-1][j]+1;
                    else
                        dp[i][j]=dp[i-1][j];
                    continue;
                }
                int temp=0;
                if(j%2==0)
                    temp=1;
                else if(j%2==1)
                    temp=2;

                if(temp==arr[i])
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]+1);
                else if(temp!=arr[i])
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        System.out.println(dp[t][w]);
    }
}
