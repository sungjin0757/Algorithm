package programmers;

public class Lev3_14 {
    class Solution {
        long[] dp;
        public int solution(int n) {
            int answer = 0;
            dp=new long[n+1];
            dp[1]=1;
            dp[0]=1;
            for(int i=2;i<=n;i++){
                dp[i]=dp[i-1]%1000000007+dp[i-2]%1000000007;
            }
            return (int)dp[n]%1000000007;
        }
    }
}
