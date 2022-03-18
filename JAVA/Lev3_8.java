package programmers;
import java.util.*;
public class Lev3_8 {
    class Solution {
        int[][] dp;
        public int solution(int[][] triangle) {
            int answer = 0;
            dp=new int[triangle.length][];
            for(int i=0;i<triangle.length;i++){
                int l=triangle[i].length;
                dp[i]=new int[l];
                if(i==0){
                    dp[i][0]=triangle[i][0];
                    continue;
                }
                for(int j=0;j<l;j++){
                    if(j==0){
                        dp[i][j]=dp[i-1][j];
                    }else if(j==l-1){
                        dp[i][j]=dp[i-1][j-1];
                    }else{
                        dp[i][j]=Math.max(dp[i-1][j-1],dp[i-1][j]);
                    }
                    dp[i][j]+=triangle[i][j];
                }
            }

            return Arrays.stream(dp[triangle.length-1]).max().getAsInt();
        }
    }
}
