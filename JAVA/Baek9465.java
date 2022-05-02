package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek9465 {

    int t,n;
    int[][] arr;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());

        List<Integer> res=new ArrayList<>();
        for(int i=0;i<t;i++){
            n=Integer.parseInt(br.readLine());
            arr= new int[2][n+1];
            int[][] dp= new int[2][n+1];
            for(int j=0;j<2;j++){
                StringTokenizer st=new StringTokenizer(br.readLine()," ");
                for(int k=1;k<=n;k++)
                    arr[j][k]=Integer.parseInt(st.nextToken());
            }
            dp[0][1]=arr[0][1];
            dp[1][1]=arr[1][1];
            for(int j=2;j<=n;j++){
                dp[0][j]=Math.max(dp[1][j-1],dp[1][j-2])+arr[0][j];
                dp[1][j]=Math.max(dp[0][j-1],dp[0][j-2])+arr[1][j];
            }
            res.add(Math.max(dp[0][n],dp[1][n]));
        }
        for(int i=0;i<t;i++){
            System.out.println(res.get(i));
        }
    }
}
