package dp;

import java.util.*;
import java.io.*;

public class Baek11053 {

    int n;
    int[] arr,dp;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        arr=new int[n];
        dp=new int[n];

        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        dp[0]=1;

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]);
                }
            }
            dp[i]+=1;
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
