package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baek14442 {

    int n,m,k;
    int[][] arr;
    int[] dx={-1,0,1,0};
    int[] dy={0,-1,0,1};
    List<Point> wall=new ArrayList<>();
    int[] wallTemp;
    boolean[] visitWallTemp;
    List<int[]> wallList=new ArrayList<>();
    boolean[][] visit;
    int bfsDist=10000000;

    public void bfs(){
        Queue<Point> dq=new LinkedList<>();
        dq.offer(new Point(0,0,1));

        while(!dq.isEmpty()){

            Point point = dq.poll();
            if(point.x==n-1 && point.y==m-1 ){
                bfsDist=Math.min(bfsDist, point.move);
            }

            for(int i=0;i<4;i++){
                int xx= point.x+dx[i];
                int yy= point.y+dy[i];

                if(0<=xx && xx<n && yy>=0 && yy<m && visit[xx][yy]==false && arr[xx][yy]==0){
                    dq.offer(new Point(xx,yy,1+ point.move));
                    visit[xx][yy]=true;
                }
            }
        }
    }

    public void solve() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        arr=new int[n][m];
        wallTemp=new int[k];
        visit=new boolean[n][m];

        for(int i=0;i<n;i++){
            String[] split = br.readLine().split("");
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(split[j]);
                if(arr[i][j]==1)
                    wall.add(new Point(i,j,0));
            }
        }
        visitWallTemp=new boolean[wall.size()];
        dfs(0);
        int minDist=1000000;


        for(int i=0;i<wallList.size();i++){
            int[] temp = wallList.get(i);
            for(int j=0;j<temp.length;j++){
                Point point = wall.get(temp[j]);
                arr[point.x][point.y]=0;
            }
            bfs();
            minDist=Math.min(minDist,bfsDist);
            bfsDist=10000000;
            visit=new boolean[n][m];
            for(int j=0;j<temp.length;j++){
                Point point = wall.get(temp[j]);
                arr[point.x][point.y]=1;
            }
        }

        if(minDist==1000000)
            System.out.println(-1);
        else{
            System.out.println(minDist);
        }

    }
    public void dfs(int x){
        if(x==k){
            wallList.add(wallTemp.clone());
        }

        else {
            for (int i = x; i < wall.size(); i++) {
                if (visitWallTemp[i] == false) {
                    wallTemp[x] = i;
                    visitWallTemp[i] = true;
                    dfs(x + 1);
                }
            }
        }
    }


    class Point{
        int x;
        int y;
        int move;

        public Point(int x,int y,int move){
            this.x=x;
            this.y=y;
            this.move=move;
        }
    }
}
