package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1958 {

    String s1,s2,s3;
    int[][][] dp;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        s1=br.readLine();
        s2=br.readLine();
        s3=br.readLine();

        dp=new int[s1.length()+1][s2.length()+1][s3.length()+1];

        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                    for(int k=1;k<=s3.length();k++){
                        if(s2.charAt(j-1)==s3.charAt(k-1) && s1.charAt(i-1)==s2.charAt(j-1)){
                            dp[i][j][k]=dp[i-1][j-1][k-1]+1;
                        }else{
                            dp[i][j][k]=Math.max(dp[i][j][k-1],Math.max(dp[i][j-1][k],dp[i-1][j][k]));
                        }
                    }

            }
        }
        System.out.println(dp[s1.length()][s2.length()][s3.length()]);
    }
}
