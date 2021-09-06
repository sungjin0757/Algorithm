package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1600 {

    int k;
    int w,h;
    int[][] arr;
    int[] dx=new int[]{-1,1,0,0};
    int[] dy=new int[]{0,0,1,-1};
    int[] hox=new int[]{-2,-1,1,2,-2,-1,1,2};
    int[] hoy=new int[]{1,2,2,1,-1,-2,-2,-1};

    public void solve() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        k=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        h=Integer.parseInt(st.nextToken());
        w=Integer.parseInt(st.nextToken());

        arr=new int[w][h];

        for(int i=0;i<w;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<h;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int res=Integer.MAX_VALUE;
        boolean[][][] pathCheck=new boolean[w][h][k+1];

        Queue<Point> dq=new LinkedList<>();
        dq.offer(new Point(0,0,0,0));

        while(!dq.isEmpty()){
            Point temp=dq.poll();

            if(temp.x==w-1 && temp.y==h-1){
                System.out.println(temp.move);
                return;
            }

            else {
                for (int i = 0; i < 4; i++) {
                    int xx = dx[i] + temp.x;
                    int yy = dy[i] + temp.y;

                    if (0 <= xx && xx < w && 0 <= yy && yy < h) {
                        if (arr[xx][yy] == 1 || pathCheck[xx][yy][temp.check])
                            continue;
                        dq.offer(new Point(xx, yy, temp.move + 1, temp.check));
                        pathCheck[xx][yy][temp.check] = true;
                    }
                }

                if (temp.check<k) {
                    for (int i = 0; i < 8; i++) {
                        int xx = hox[i] + temp.x;
                        int yy = hoy[i] + temp.y;

                        if (0 <= xx && xx < w && 0 <= yy && yy < h) {
                            if (pathCheck[xx][yy][temp.check+1] || arr[xx][yy] == 1)
                                continue;
                            dq.offer(new Point(xx, yy, temp.move + 1, temp.check+1));
                            pathCheck[xx][yy][temp.check+1] = true;
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }

    class Point{
        int x;
        int y;
        int move;
        int check;

        public Point(int x,int y,int move,int check){
            this.x=x;
            this.y=y;
            this.move=move;
            this.check=check;
        }
    }
}
