package programmers;

public class Lev3_18 {
    class Solution {
        int[] dx=new int[]{0,1};
        int[] dy=new int[]{1,0};
        long[][] dp;
        public int solution(int m, int n, int[][] puddles) {
            dp=new long[n+1][m+1];
            for(int[] p : puddles){
                dp[p[1]][p[0]]=-1;
            }
            dp[1][1]=1;
            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    if(dp[i][j]==-1){
                        continue;
                    }
                    for(int k=0;k<2;k++){
                        int xx=i+dx[k];
                        int yy=j+dy[k];
                        if(xx<=0 || xx>n || yy<=0 || yy>m){
                            continue;
                        }
                        if(dp[xx][yy]==-1){
                            continue;
                        }
                        dp[xx][yy]+=(dp[i][j]%1000000007);
                    }
                }
            }

            return (int)dp[n][m]%1000000007;
        }
    }
}
