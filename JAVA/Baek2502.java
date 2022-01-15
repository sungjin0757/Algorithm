package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baek2502 {

    int d,k;
    String[] dp;

    private int num(String s,String c){
        return s.length()-s.replace(c,"").length();
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        d=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        dp=new String[d+1];
        dp[1]="a";
        dp[2]="b";
        for(int i=3;i<=d;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        int a=num(dp[d],"a");
        int b=num(dp[d],"b");

        for(int i=1;i<=k;i++){
            boolean check=false;
            for(int j=1;j<=k;j++){
                if(a*i+b*j==k){
                    System.out.println(i);
                    System.out.println(j);
                    check=true;
                }else if(a*i+b*j>k){
                    break;
                }
            }
            if(check){
                break;
            }
        }
    }
}
