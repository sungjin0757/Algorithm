package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baek15988 {

    public void solve() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int t=Integer.parseInt(st.nextToken());
        long[] dp=new long[1000001];
        List<Long> res=new ArrayList<>();

        dp[1]=1;
        dp[2]=2;
        dp[3]=4;

        for(int i=1;i<=t;i++){
            st=new StringTokenizer(br.readLine());
            int temp=Integer.parseInt(st.nextToken());

            for(int j=4;j<=temp;j++){
                if(dp[j]==0)
                    dp[j]=(dp[j-2]+dp[j-1]+dp[j-3])%1000000009;
            }
            res.add(dp[temp]%1000000009);
        }

        for (Long result : res) {
            System.out.println(result);
        }
    }
}
