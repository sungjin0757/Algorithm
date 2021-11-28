package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2193_dfs {

    int n;
    int res=0;

    private void dfs(int digit,int x){

        if(digit==1){
            res+=1;
        }else if(digit!=1){
            dfs(digit-1,0);
            if(x!=1)
                dfs(digit-1,1);
        }
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        dfs(n,0);
        dfs(n,1);
        System.out.println(res);
    }
}
