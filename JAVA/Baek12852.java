package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek12852 {

    int n;
    int[] dp;

    private int dfs(int x){
        if(x==1)
            return dp[x]=1;
        if(dp[x]!=Integer.MAX_VALUE)
            return dp[x];
        int temp1=Integer.MAX_VALUE;
        int temp2=Integer.MAX_VALUE;
        if(x%3==0){
            temp1=dfs(x/3);
        }
        if(x%2==0){
            temp2=dfs(x/2);
        }
        dp[x]=Math.min(dfs(x-1),Math.min(temp1,temp2));
        return dp[x]+=1;
    }

    private void printDfs(int x){
        System.out.print(x+" ");
        if(x==1)
            return;
        int temp=Integer.MAX_VALUE;
        int idx=0;
        if(x%3==0){
            idx=x/3;
            temp=dp[x/3];
        }if(x%2==0){
            if(temp>dp[x/2]){
                idx=x/2;
                temp=dp[x/2];
            }
        }
        if(temp>dp[x-1]){
            idx=x-1;
            temp=dp[x-1];
        }
        printDfs(idx);
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);

        System.out.println(dfs(n)-1);
        printDfs(n);
    }
}
