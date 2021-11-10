package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Baek2151 {

    int n;

    char[][] arr;

    public void solve() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        arr=new char[n+1][n+1];

        Point ans=new Point();
        Point start=new Point();

        for(int i=1;i<=n;i++){
            String[] temp=br.readLine().split("");
            for(int j=1;j<=n;j++){
                arr[i][j]=temp[j-1].charAt(0);
                if(arr[i][j]=='#'){
                    if(ans.x==0){
                        ans=new Point(i,j,0);
                    }
                    else{
                        start=new Point(i,j,0);
                    }
                }
            }
        }

        Queue<Point> dq=new LinkedList<>();
        dq.offer(start);
        int res=Integer.MAX_VALUE;
        boolean[][] check=new boolean[n+1][n+1];
        check[start.x][start.y]=true;

        boolean upDown;
        int[] dx;
        int[] dy;
        if(start.x-ans.x>0) {
            dx=new int[]{-1,-1};
            dy=new int[]{-1,1};
        }
        else {
            dx=new int[]{1,1};
            dy=new int[]{-1,1};
        }

        while(!dq.isEmpty()){

            Point temp=dq.poll();

            if(temp.x==ans.x && temp.y==ans.y){
                check[temp.x][temp.y]=false;
                res=Math.min(res,temp.move-1);
            }
            else {

                int i = 1;
                while (true) {
                    if (i == n) {
                        break;
                    }
                    for (int j = 0; j < 2; j++) {
                        int xx = dx[j] * i + temp.x;
                        int yy = dy[j] * i + temp.y;

                        if (0 <= xx && xx < n && 0 <= yy && yy < n) {
                            if ((arr[xx][yy] == '!' || arr[xx][yy]=='#') && !check[xx][yy]) {
                                check[xx][yy]=true;
                                dq.offer(new Point(xx, yy, temp.move + 1));
                            }
                        }
                    }
                    i++;
                }
            }
        }
        System.out.println(res);
    }

    class Point{
        int x;
        int y;
        int move;

        public Point(){

        }

        public Point(int x,int y,int move){
            this.x=x;
            this.y=y;
            this.move=move;
        }
    }
}
