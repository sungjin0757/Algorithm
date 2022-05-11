package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek11052 {

    int n;
    int[] arr,dp;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        arr=dp=new int[n+1];

        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        dp[1]=arr[1];

        for(int i=2;i<=n;i++){
            dp[i]=arr[i];
            for(int j=1;j<i;j++){
                dp[i]=Math.max(dp[i],dp[j]+arr[i-j]);
            }
        }
        System.out.println(dp[n]);
    }
}
