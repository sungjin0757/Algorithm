package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek1509 {

    String s;
    int[] dp;
    boolean[][] check;

    private void checkPalindrome(){
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                boolean flag=true;
                for(int k=i;k<=(i+j)/2;k++){
                    if(s.charAt(k)!=s.charAt(j-k+i)){
                        flag=false;
                        break;
                    }
                }
                if(flag)
                    check[i+1][j+1]=true;
            }
        }
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        s=br.readLine();
        dp=new int[s.length()+1];
        check=new boolean[s.length()+1][s.length()+1];

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1]=1;
        dp[0]=0;

        checkPalindrome();

        for(int i=2;i<=s.length();i++){
            for(int j=1;j<=i;j++){
                if(check[j][i]){
                    dp[i]=Math.min(dp[i],dp[j-1]+1);
                }
            }
        }

        System.out.println(dp[s.length()]);
    }
}
