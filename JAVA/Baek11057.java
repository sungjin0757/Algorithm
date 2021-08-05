package dp;

import java.util.Scanner;

public class Baek11057 {

    int n;
    int[][] dp;

    public int dfs(int digit,int value){

        if(digit==1)
            return dp[digit][value];

        if(dp[digit][value]==0) {
            for (int i = 0; i < 10; i++) {
                if (value >= i) {
                    dp[digit][value]+=dfs(digit - 1, i);
                }
            }
        }

        return dp[digit][value]%10007;
    }

    public void solve(){
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();

        dp=new int[n+1][10];

        for(int i=0;i<10;i++){
            dp[1][i]=1;
        }
        int res=0;

        for(int i=0;i<10;i++){
            res+=dfs(n,i);
        }

        if(n==1){
            System.out.println(10);
        }else{
        System.out.println(res%10007);}
    }
}
