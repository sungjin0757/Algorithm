package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek9251 {

    char[] a;
    char[] b;
    int[][] dy;

    int dfs(int x,int y){

        if(x==-1 || y==-1)
            return 0;

        if(a[x]==b[y])
            dy[x][y]=dfs(x-1,y-1)+1;
        else{
            dy[x][y]=Math.max(dfs(x-1,y),dfs(x,y-1));
        }

        return dy[x][y];
    }

    public void solve() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        a=br.readLine().toCharArray();
        b=br.readLine().toCharArray();

        dy=new int[a.length][b.length];

        System.out.println(dfs(a.length-1,b.length-1));

    }
}
