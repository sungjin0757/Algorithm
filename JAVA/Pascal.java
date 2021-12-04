package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pascal {

    int n;
    int[] dp;
    int res=0;

    private void dfs(int x,int sum){
        if(sum==n){
            res+=1;
            return;
        }
        if(sum>n){
            return;
        }
        if(x>n){
            return;
        }
        if(sum+x>n){
            return;
        }
        dfs(x+1,sum);
        dfs(x+1,sum+x);
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        dfs(1,0);

        System.out.println(res);
    }
}
