package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek9252 {

    String s1,s2;
    int[][] dp;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        s1=br.readLine();
        s2=br.readLine();

        dp=new int[s1.length()+1][s2.length()+1];
        int max=0;
        int[] maxIdx={0,0};

        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j-1],Math.max(dp[i-1][j],dp[i][j-1]));
                if(dp[i][j]>max){
                    max=dp[i][j];
                    maxIdx[0]=i;
                    maxIdx[1]=j;
                }
            }
        }
        System.out.println(max);
        int x=maxIdx[0];
        int y=maxIdx[1];
        StringBuilder sb=new StringBuilder();
        if(max!=0) {
            while (x>0 && y>0) {
                if(dp[x][y]==dp[x][y-1])
                    y--;
                else if(dp[x][y]==dp[x-1][y])
                    x--;
                else{
                    x--;
                    y--;
                    sb.insert(0,s1.charAt(x));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
