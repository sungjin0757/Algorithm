package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1932 {

    int n;
    int[][] arr;
    boolean[][] check;
    int max=0;

    private void dfs(int x,int y,int move){

        if(x==n){
            max=Math.max(max,move);
        }

        else {
            if(!check[x+1][y]) {
                check[x + 1][y] = true;
                dfs(x + 1, y, move + arr[x + 1][y]);
                check[x + 1][y] = false;
            }

            if(!check[x+1][y+1]) {
                check[x + 1][y + 1] = true;
                dfs(x + 1, y + 1, move + arr[x + 1][y + 1]);
                check[x + 1][y + 1] = false;
            }
        }
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        arr=new int[n+1][n+1];

        StringTokenizer st;

        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine()," ");

            for(int j=0;j<i;j++){
                arr[i][j+1]=Integer.parseInt(st.nextToken());
            }
        }

        check=new boolean[n+1][n+1];

        dfs(1,1,arr[1][1]);

        System.out.println(max);

    }

}
