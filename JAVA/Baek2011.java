package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2011 {

    String c;
    long[] dp;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        c=br.readLine();

        if(c.length()==0) {
            System.out.println(0);
            return;
        }
        if(c.length()==1){
            if(c.equals("0")){
                System.out.println(0);
                return;
            }
            System.out.println(1);
            return;
        }if(c.charAt(0)=='0'){
            System.out.println(0);
            return;
        }
        dp=new long[c.length()+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=c.length();i++){
            int temp1=Integer.parseInt(String.valueOf(c.charAt(i-1)));
            int temp2=Integer.parseInt(String.valueOf(c.charAt(i-2)))*10+temp1;
            if(temp1==0 && temp2>26){
                System.out.println(0);
                return;
            }
            if(10<=temp2 && temp2<=26){
                dp[i]+=dp[i-2]%1000000;
            }
            if(temp1!=0)
                dp[i]+=dp[i-1]%1000000;
        }
        System.out.println(dp[c.length()]%1000000);
    }
}
