package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek17404 {
    int n;
    int[][] arr;
    int[][] dp;

    public void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1][3];
        dp = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        int res=Integer.MAX_VALUE;

        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++){
                if(i==j)
                    dp[1][j]=arr[1][j];
                else if(i!=j)
                    dp[1][j]=10000000;
            }
            for (int j = 2; j <= n; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + arr[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + arr[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + arr[j][2];
            }
            for(int j=0;j<3;j++){
                if(i!=j)
                    res=Math.min(res,dp[n][j]);
            }
        }

        System.out.println(res);
    }
}
