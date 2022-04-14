package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek11060 {
    int n;
    int[] arr,dp;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        arr=new int[n+1];
        dp=new int[n+1];

        for(int i=1;i<=n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp,1001);
        dp[1]=0;
        for(int i=1;i<=n;i++){
            int temp=arr[i];
            if(temp==0)
                continue;
            for(int j=i+1;j<=i+temp;j++){
                if(j>n)
                    break;
                dp[j]=Math.min(dp[i]+1,dp[j]);
            }
        }

        if(dp[n]==1001){
            System.out.println(-1);
            return;
        }
        System.out.println(dp[n]);
    }
}
