package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek16194 {
    int n;
    int[] arr,dp;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        arr=new int[n+1];
        dp=new int[n+1];

        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1]=arr[1];

        for(int i=2;i<=n;i++){
            dp[i]=arr[i];
            for(int j=1;j<=(i)/2;j++){
                dp[i]=Math.min(dp[i],dp[j]+dp[i-j]);
            }
        }

        System.out.println(dp[n]);
    }
}
