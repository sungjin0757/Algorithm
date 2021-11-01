package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek17070 {

    int n;
    int[][] arr;
    int res;

    private void dfs(int x,int y,int direction){

        if(x==n && y==n){
            res+=1;
            return;
        }
        if(direction==0){
            if(y+1<=n && arr[x][y+1]==0)
                dfs(x,y+1,0);
        }
        else if(direction==1){
            if(x+1<=n && arr[x+1][y]==0)
                dfs(x+1,y,1);
        }
        else if(direction==2){
            if(y+1<=n && arr[x][y+1]==0)
                dfs(x,y+1,0);
            if(x+1<=n && arr[x+1][y]==0)
                dfs(x+1,y,1);
        }

        if(x+1<=n && arr[x+1][y]==0 && y+1<=n && arr[x][y+1]==0 &&arr[x+1][y+1]==0){
            dfs(x+1,y+1,2);
        }

    }

    public void solve() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        arr=new int[n+1][n+1];
        res=0;

        StringTokenizer st;

        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=n;j++)
                arr[i][j]=Integer.parseInt(st.nextToken());
        }


        dfs(1,2,0);

        System.out.println(res);
    }
}
