package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek9084 {

    int t;
    int n;
    int m;
    int[] arr;
    int[] dp;

    private int dfs(int x,int temp){

        if(x==0)
            return 1;
        else if(x<0)
            return 0;

        if(x==m) {
            for (int i = 1; i < temp; i++) {
                if (x - i  >= 0)
                    dp[x - i] += dfs(x - i - temp, temp) ;
            }
        }

        dp[x]+=dfs(x-temp,temp);

        return dp[x];
    }


    public void solve() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(br.readLine());

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<t;i++){
            n=Integer.parseInt(br.readLine());
            arr=new int[n+1];
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=n;j++){
                arr[j]=Integer.parseInt(st.nextToken());
            }
            m=Integer.parseInt(br.readLine());
            dp=new int[m+1];
            for(int j=1;j<=n;j++) {
                dfs(m, arr[j]);
            }

            sb.append(dp[m]+"\n");

        }

        System.out.println(sb);
    }
}
