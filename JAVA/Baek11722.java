package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek11722 {

    int n;
    int[] arr,dp;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        arr=new int[n];
        dp=new int[n];

        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0]=1;

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]<arr[j])
                    dp[i]=Math.max(dp[j],dp[i]);
            }
            dp[i]+=1;
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());

    }
}
