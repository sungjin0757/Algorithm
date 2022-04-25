package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek20057 {
    int n,x,y;
    int[] dx=new int[]{-1,1,0,0};
    int[] dy=new int[]{0,0,-1,1};
    int[][][] ratio=new int[][][]{{{0,0,5,0,0},{0,10,0,10,0},{2,7,0,7,2},{0,1,0,1,0},{0,0,0,0,0}},
            {{0,0,0,0,0},{0,1,0,1,0},{2,7,0,7,2},{0,10,0,10,0},{0,0,5,0,0}},
            {{0,0,2,0,0},{0,10,7,1,0},{5,0,0,0,0},{0,10,7,1,0},{0,0,2,0,0}},
            {{0,0,2,0,0},{0,1,7,10,0},{0,0,0,0,5},{0,1,7,10,0},{0,0,2,0,0}}};
    int res=0;
    int[][] sand;

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        sand=new int[n][n];
        x=n/2;
        y=n/2;

        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++){
                sand[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        process();

        System.out.println(res);
    }

    private void process(){
        for(int i=1;i<n;i++){
            if(i%2==1){
                move(i,2);
                move(i,1);
            }else{
                move(i,3);
                move(i,0);
            }
        }
        move(n-1,2);
    }

    private void move(int cnt,int dir){
        for(int i=0;i<cnt;i++){
            x+=dx[dir];
            y+=dy[dir];
            windSand(dir);
        }
    }

    private void windSand(int dir){
        if(sand[x][y]==0)
            return;
        int sandSize=sand[x][y];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                int r=ratio[dir][i][j];
                if(r==0){
                    continue;
                }
                int xx=x+i-2;
                int yy=y+j-2;
                int s=(int)((double)sand[x][y]*(r/100.0));
                if(xx<0 || xx>=n || yy<0 || yy>=n){
                    res+=s;
                }else {
                    sand[xx][yy] += s;
                }
                sandSize-=s;
            }
        }
        sand[x][y]=0;
        int xx=x;
        int yy=y;
        if(dir==0){
            xx-=1;
        }else if(dir==1){
            xx+=1;
        }else if(dir==2){
            yy-=1;
        }else if(dir==3){
            yy+=1;
        }
        if(0<=xx && xx<n && 0<=yy && yy<n){
            sand[xx][yy]+=sandSize;
        }else{
            res+=sandSize;
        }
    }
}
