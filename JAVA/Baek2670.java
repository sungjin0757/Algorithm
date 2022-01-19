package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek2670 {

    int n;
    double[] arr,dp;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        arr=new double[n+1];

        for(int i=1;i<=n;i++){
            arr[i]=Double.parseDouble(br.readLine());
        }

        dp=new double[n+1];
        dp[1]=arr[1];

        for(int i=2;i<=n;i++){
            dp[i]=Math.max(dp[i-1]*arr[i],arr[i]);
        }

        System.out.println(String.format("%.3f",Arrays.stream(dp).max().getAsDouble()));
    }
}
