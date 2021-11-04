package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek2631 {

    int n;
    int[] children;

    public void solve() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        children=new int[n+1];

        for(int i=1;i<=n;i++){
            children[i]=Integer.parseInt(br.readLine());
        }

        int[] dp=new int[n+1];

        for(int i=1;i<=n;i++){
            dp[i]=1;
            for(int j=1;j<i;j++){
                if(children[i]>children[j]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
        }

        int max= Arrays.stream(dp).max().getAsInt();

        System.out.println(n-max);
    }
}
