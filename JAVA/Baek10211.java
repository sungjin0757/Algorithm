package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek10211 {

    int t;
    int[] res;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        t=Integer.parseInt(br.readLine());

        res=new int[t];

        for(int i=0;i<t;i++){
            int n=Integer.parseInt(br.readLine());
            int[] arr=new int[n+1];
            int[] dp=new int[n+1];

            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=n;j++){
                arr[j]=Integer.parseInt(st.nextToken());
            }

            dp[1]=arr[1];

            for(int j=2;j<=n;j++){
                dp[j]=Math.max(arr[j],dp[j-1]+arr[j]);
            }

            res[i]= Arrays.stream(dp,1,n+1).max().getAsInt();
        }

        for(int i=0;i<t;i++){
            System.out.println(res[i]);
        }
    }
}
