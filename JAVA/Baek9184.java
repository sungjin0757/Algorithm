package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek9184 {

    int a,b,c;
    long[][][] dp;

    private long w(int a,int b,int c){
        if(a<=0 || b<=0 || c<=0)
            return 1;
        else if(dp[a][b][c]!=0)
            return dp[a][b][c];
        else if(a>20 || b>20 || c>20)
            return dp[a][b][c]=w(20,20,20);
        else if(a<b && b<c)
            return dp[a][b][c]=w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
        else
            return dp[a][b][c]=w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        dp=new long[51][51][51];
        while(true){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            c=Integer.parseInt(st.nextToken());

            if(a==-1 && b==-1 && c==-1)
                break;
            printRes(a,b,c,w(a,b,c));
        }
    }

    private void printRes(int x,int y,int z,long r){
        System.out.println("w("+x+", "+y+", "+z+") = "+r);
    }
}
