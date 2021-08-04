package dp;

import java.util.Scanner;

public class Baek10844 {

    static int n;
    static long[][] dp;

    static long dfs(int digit,int value){

        if(digit==1){
            if(value==0)
                return 0;
            return dp[digit][value];
        }

        if(dp[digit][value]==0)
            if(value==0)
                dp[digit][value]=dfs(digit-1,1);
            else if(value==9)
                dp[digit][value]=dfs(digit-1,8);
            else
                dp[digit][value]=dfs(digit-1,value+1)+dfs(digit-1,value-1);

        return dp[digit][value]%1000000000;

    }

    static public void solve() throws Exception{

        Scanner scanner=new Scanner(System.in);
        n = scanner.nextInt();
        long res=0L;

        dp=new long[n+1][10];
        for(int i=0;i<=9;i++)
            dp[1][i]=1;
        if(n==1)
            System.out.println(9);
        else{
            for(int i=0;i<=9;i++){
                res+=dfs(n,i);
            }
            System.out.println(res%1000000000);
        }


    }
}
