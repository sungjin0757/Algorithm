package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Baek2688 {

    int t;
    List<Integer> test=new ArrayList<>();
    long[][] dp;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());

        int max=0;

        for(int i=0;i<t;i++){
            int temp = Integer.parseInt(br.readLine());
            test.add(temp);
            max=Math.max(max,temp);
        }

        dp=new long[max+1][10];

        for(int i=0;i<=9;i++){
            dp[1][i]=1;
        }

        for(int i=2;i<=max;i++){
            for(int j=0;j<=9;j++){
                for(int k=j;k<=9;k++){
                    dp[i][j]+=dp[i-1][k];
                }
            }
        }


        for(int i=0;i<test.size();i++){
            System.out.println(Arrays.stream(dp[test.get(i)]).sum());
        }

    }
}
