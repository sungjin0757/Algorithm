package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baek14051 {

    int n;
    int[][] arr;
    int[] dp;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        StringTokenizer st;
        arr=new int[n+1][2];

        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine()," ");
            arr[i][0]=Integer.parseInt(st.nextToken());
            arr[i][1]=Integer.parseInt(st.nextToken());
        }

        dp=new int[n+2];

        for(int i=n;i>0;i--){
            if(arr[i][0]+i>n+1)
                continue;
            int max=0;
            for(int j=i+arr[i][0];j<=n;j++){
                max=Math.max(max,dp[j]);
            }
            dp[i]=Math.max(max,dp[i+arr[i][0]])+arr[i][1];

        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
