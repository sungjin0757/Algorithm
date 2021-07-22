package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek2146 {
    int [] dx=new int[]{-1,0,1,0};
    int [] dy=new int[]{0,-1,0,1};
    int dist=100000;
    boolean[][] visit;
    int[][] map;
    int landNum=2;

    public void bfsNum(int x, int y){

        Queue<Point> dq=new LinkedList<Point>();
        dq.offer(new Point(x,y,0));
        visit[x][y]=true;
        map[x][y]=landNum;
        while(!dq.isEmpty()){
            Point p = dq.poll();

            for(int i=0;i<4;i++){
                int xx=p.x+dx[i];
                int yy=p.y+dy[i];
                if(xx>0 && xx<map.length && yy>0 && yy<map.length && visit[xx][yy]==false && map[xx][yy]==1){
                    map[xx][yy]=landNum;
                    visit[xx][yy]=true;
                    dq.offer(new Point(xx,yy,0));
                }
            }
        }

    }

    public void bfs(int x,int y){
        int landNumTemp=map[x][y];
        Queue<Point> dq=new LinkedList<Point>();
        dq.offer(new Point(x,y,0));
        visit[x][y]=true;
        while(!dq.isEmpty()){
            Point p = dq.poll();

            for(int i=0;i<4;i++){
                int xx=p.x+dx[i];
                int yy=p.y+dy[i];
                if(xx>0 && xx<map.length && yy>0 && yy<map.length && visit[xx][yy]==false && map[xx][yy]==0){

                    visit[xx][yy]=true;

                    dq.offer(new Point(xx,yy,p.cal+1));
                }
                if(xx>0 && xx<map.length && yy>0 && yy<map.length && visit[xx][yy]==false && map[xx][yy]!=0 && map[xx][yy]!=landNumTemp){
                    dist=Math.min(dist,p.cal);
                }
            }
        }

    }
    public void solve() throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        map=new int[n+1][n+1];
        visit=new boolean[n+1][n+1];

        for(int i=1;i<=n;i++)
        {
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(map[i][j]==1){
                    bfsNum(i,j);
                    landNum++;
                }
            }
        }
        visit=new boolean[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(map[i][j]>1){
                    bfs(i,j);
                    visit=new boolean[n+1][n+1];
                }
            }
        }

        System.out.println(dist);

    }
    private class Point{
        int x;
        int y;
        int cal;

        public Point(int x,int y,int cal){
            this.x=x;
            this.y=y;
            this.cal=cal;
        }
    }
}
