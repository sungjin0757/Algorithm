package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baek15989 {

    public void solve() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        List<Integer> res=new ArrayList<>();


        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int temp=Integer.parseInt(st.nextToken());
            int[] dp=new int[10001];
            dp[0]=1;

            for(int j=1;j<=3;j++){
                for(int k=1;k<=temp;k++)
                {
                    if(k-j>=0)
                        dp[k]+=dp[k-j];
                }
            }
            res.add(dp[temp]);
        }

        for (Integer re : res) {
            System.out.println(re);
        }
    }
}
