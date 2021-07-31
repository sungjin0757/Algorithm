package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1743 {

    int n,m,k;
    int[][] arr;
    int[] dx={-1,0,1,0};
    int[] dy={0,-1,0,1};
    int cnt=0;
    int res=0;

    public void DFS(int x,int y){
        arr[x][y]=0;

        for(int i=0;i<4;i++){
            int xx=dx[i]+x;
            int yy=dy[i]+y;
            if(xx>=1 && xx<=n && yy>=1 && yy<=m && arr[xx][yy]==1){
                cnt+=1;
                DFS(xx,yy);
            }
        }
    }

    public void solve() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        arr=new int[n+1][m+1];

        for(int i=0;i<k;i++){
            st=new StringTokenizer(br.readLine()," ");
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            arr[a][b]=1;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(arr[i][j]==1) {
                    cnt = 1;
                    DFS(i, j);
                    res = Math.max(cnt, res);
                }
            }
        }

        System.out.println(res);
    }
}
