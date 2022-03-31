package programmers;

public class Lev3_16 {
    class Solution {
        int MOD = 20170805;
        int[] dx=new int[]{1,0};
        int[] dy=new int[]{0,1};
        long[][] dp;
        int m,n;
        int[][] city;
        private long dfs(int x,int y,int dir){
            if(x==m-1 && y==n-1){
                return 1;
            }
            if(city[x][y]==2){
                int xx=x+dx[dir];
                int yy=y+dy[dir];
                if(xx<0 || xx>=m || yy<0 || yy>=n)
                    return 0;
                if( city[xx][yy]==1)
                    return 0;
            }
            if(dp[x][y]!=0)
                return dp[x][y];

            for(int i=0;i<2;i++){
                int xx=x+dx[i];
                int yy=y+dy[i];
                if(xx<0 || xx>=m || yy<0 || yy>=n)
                    continue;
                if(city[xx][yy]==1)
                    continue;
                if(city[x][y]==2 && (x!=0 || y!=0)){
                    if(i!=dir)
                        continue;
                }
                dp[x][y]=dp[x][y]%MOD+dfs(xx,yy,i)%MOD;
            }
            return dp[x][y];
        }
        public int solution(int m, int n, int[][] cityMap) {
            int answer = 0;
            this.city=cityMap;
            this.m=m;
            this.n=n;

            dp=new long[m][n];

            return (int)(dfs(0,0,-1)%MOD);
        }
    }
}
