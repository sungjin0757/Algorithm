package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek11062 {

    int t;
    int n;
    int card[];
    int[][][] dp;

    private int dfs(int turn,int start,int end){

        if (start > end) {
            return 0;
        }

        if(dp[turn][start][end]!=0)
            return dp[turn][start][end];

        if(turn==1)
            dp[turn][start][end]=Math.max(dfs(2,start+1,end)+card[start],dfs(2,start,end-1)+card[end]);
        else
            dp[turn][start][end]=Math.min(dfs(1,start+1,end),dfs(1,start,end-1));

        return dp[turn][start][end];
    }

    public void solve() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        t=Integer.parseInt(st.nextToken());

        for(int i=0;i<t;i++){
            st=new StringTokenizer(br.readLine());
            n=Integer.parseInt(st.nextToken());

            st=new StringTokenizer(br.readLine()," ");
            card=new int[n+1];
            dp=new int[3][n+1][n+1];

            for(int j=1;j<=n;j++){
                card[j]=Integer.parseInt(st.nextToken());
            }
            System.out.println(dfs(1,1,n));

        }
    }
}
