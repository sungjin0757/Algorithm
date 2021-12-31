package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek7529 {

    int n,m;
    int[][] arr;
    long[] dp;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        arr=new int[n][2];

        for(int i=0;i<2;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++){
                arr[j][i]=Integer.parseInt(st.nextToken());
            }
        }
        dp=new long[10001];
        Arrays.fill(dp,Long.MIN_VALUE);

        dp[arr[0][1]]=arr[0][0];

        for(int i=1;i<n;i++){
            int time=arr[i][1];
            int mem=arr[i][0];

            for(int j=0;j<=10000-100;j++){
                if(dp[j]==Long.MIN_VALUE )
                    continue;
                int ttime=j+time;
                long mmem=dp[j]+mem;
                dp[ttime]=Math.max(dp[ttime],mmem);
            }
            dp[time]=Math.max(mem,dp[time]);
        }

        for(int i=0;i<=10000;i++){
            if(dp[i]>=m){
                System.out.println(i);
                break;
            }
        }
    }
}
