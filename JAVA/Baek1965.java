package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1965 {

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

        for(int i=1;i<=n;i++){
            for(int j=1;j<i;j++){
                if(arr[i]>arr[j])
                    dp[i]=Math.max(dp[i],dp[j]);
            }
            dp[i]+=1;
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
