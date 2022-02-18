package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek14500 {

    int n,m;
    int[][] arr;
    int[] dx=new int[]{-1,1,0,0};
    int[] dy=new int[]{0,0,-1,1};
    boolean[][] check;
    int max=0;

    private void dfs(int x,int y,int move,int score){
        if(move==4){
            max=Math.max(max,score);
            return;
        }
        for(int i=0;i<4;i++){
            int xx=x+dx[i];
            int yy=y+dy[i];
            if(1<=xx && xx<=n && 1<=yy && yy<=m){
                if(!check[xx][yy]){
                    check[xx][yy]=true;
                    dfs(xx,yy,move+1,score+arr[xx][yy]);
                    check[xx][yy]=false;
                }
            }
        }
    }
    private void ex(int x,int y){
        if(x+1<=n && y-1>=1 && x-1>=1)
            max=Math.max(max,arr[x][y]+arr[x+1][y-1]+arr[x][y-1]+arr[x-1][y-1]);
        if(x+1<=n && y+1<=m && x-1>=1)
            max=Math.max(max,arr[x][y]+arr[x+1][y+1]+arr[x][y+1]+arr[x-1][y+1]);
        if(x+1<=n && y+1<=m && 1<=y-1)
            max=Math.max(max,arr[x][y]+arr[x+1][y]+arr[x+1][y-1]+arr[x+1][y+1]);
        if(x+1<=n && y+1<=m && 1<=y-1)
            max=Math.max(max,arr[x][y]+arr[x+1][y]+arr[x][y-1]+arr[x][y+1]);
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        arr=new int[n+1][m+1];
        check=new boolean[n+1][m+1];

        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                check[i][j]=true;
                dfs(i,j,1,arr[i][j]);
                check[i][j]=false;
                ex(i,j);
            }
        }
        System.out.println(max);
    }

}
