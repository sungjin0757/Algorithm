package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek10164 {

    int n,m,k;
    long[][] dp;

    private long dfs(int x,int y,int n,int m){
        if(x==n && y==m)
            return 1;
        if(dp[x][y]!=0)
            return dp[x][y];

        int xx=x+1;
        int yy=y+1;
        if(1<=xx && xx<=n)
            dp[x][y]+=dfs(xx,y,n,m);
        if(1<=yy && yy<=m)
            dp[x][y]+=dfs(x,yy,n,m);
        return dp[x][y];
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        dp=new long[n+1][m+1];

        if(k==0){
            dfs(1,1,n,m);
            System.out.println(dp[1][1]);
        }
        else if(n==1 || m==1){
            System.out.println(1);
        }
        else {
            long temp2=dfs(1,1,(k-1)/m+1,(k-1)%m+1);
            dp=new long[n+1][m+1];
            long temp=dfs((k-1)/m+1,(k-1)%m+1,n,m);
            System.out.println(temp*temp2);
        }
    }
}
