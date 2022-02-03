package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek14502 {

    int n,m;
    int[][] arr;
    int max=0;
    List<int[]> idx=new ArrayList<>();
    int[] dx=new int[]{-1,1,0,0};
    int[] dy=new int[]{0,0,-1,1};
    boolean[][] check;

    private void dfs(int x,int y){
        for(int i=0;i<4;i++){
            int xx=dx[i]+x;
            int yy=dy[i]+y;
            if(1<=xx && xx<=n && 1<=yy && yy<=m){
                if(!check[xx][yy] && arr[xx][yy]==0){
                    arr[xx][yy]=2;
                    check[xx][yy]=true;
                    dfs(xx,yy);
                    check[xx][yy]=false;
                }
            }
        }
    }

    private void num(){
        int count=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(arr[i][j]==0)
                    count++;
            }
        }
        max=Math.max(max,count);
    }

    private void clear(){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(arr[i][j]==2)
                    arr[i][j]=0;
            }
        }
        for(int i=0;i<idx.size();i++){
            int[] d = idx.get(i);
            arr[d[0]][d[1]]=2;
        }
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
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j]= temp;
                if(temp==2)
                    idx.add(new int[]{i,j});
            }
        }

        for(int i=1;i<=n*m-2;i++){
            int r1=((i-1)/m)+1;
            int c1=((i-1)%m)+1;
            if(arr[r1][c1]==0) {
                for (int j = i + 1; j <= n * m - 1; j++) {
                    int r2 = ((j - 1) / m) + 1;
                    int c2 = ((j - 1) % m) + 1;

                    if(arr[r2][c2]==0) {
                        for (int k = j + 1; k <= n * m; k++) {
                            int r3 = ((k - 1) / m) + 1;
                            int c3 = ((k - 1) % m) + 1;
                            if (arr[r3][c3] == 0) {
                                arr[r1][c1] = 1;
                                arr[r2][c2] = 1;
                                arr[r3][c3] = 1;
                                for (int t = 0; t < idx.size(); t++) {
                                    int[] d = idx.get(t);
                                    check[d[0]][d[1]] = true;
                                    dfs(d[0], d[1]);
                                    check[d[0]][d[1]] = false;

                                }
                                num();
                                clear();
                                arr[r1][c1]=0;
                                arr[r2][c2]=0;
                                arr[r3][c3]=0;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }
}
