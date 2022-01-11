package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek2491 {

    int n;
    int[] arr;
    int[][] dp;

    public void solve() throws IOException{
        BufferedReader  br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        arr=new int[n+1];
        dp=new int[2][n+1];
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        dp[0][1]=1;
        dp[1][1]=1;
        for(int i=2;i<=n;i++){
            if(arr[i-1]>=arr[i]){
                dp[0][i]=dp[0][i-1];
            }
            if(arr[i-1]<=arr[i]){
                dp[1][i]=dp[1][i-1];
            }
            dp[0][i]+=1;
            dp[1][i]+=1;
        }

        System.out.println(Math.max(Arrays.stream(dp[0]).max().getAsInt(),Arrays.stream(dp[1]).max().getAsInt()));
    }
}
