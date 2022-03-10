package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baek19236 {

    int[][] arr=new int[4][4];
    int[] dx=new int[]{-1,-1,0,1,1,1,0,-1};
    int[] dy=new int[]{0,-1,-1,-1,0,1,1,1};
    List<int[]> fish=new ArrayList<>();
    int shark[]=new int[3];
    int res=0;

    private int dfs(int x,int y){
        int r=arr[x][y];
        int dir=shark[2];
        int xx=x;
        int yy=y;
        int[][] temp=new int[4][4];
        copy(temp,arr);
        arr[x][y]=0;
        fishMove();
        int max=0;
        for(int i=0;i<4;i++){
            xx+=dx[dir];
            yy+=dy[dir];
            if(!checkFishMove(xx,yy)) {
                continue;
            }
            shark[0]=xx;
            shark[1]=yy;
            shark[2]=fish.get(arr[xx][yy])[3];
            max=Math.max(max,dfs(xx,yy));
            shark[0]=x;
            shark[1]=y;
            shark[2]=dir;
        }
        copy(arr,temp);
        return max+arr[x][y];
    }

    private void copy(int[][] temp1,int[][] temp2){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                temp1[i][j]=temp2[i][j];
            }
        }
    }

    private void fishMove(){
        for(int i=1;i<=16;i++){
            int[] temp=fish.get(i);
            if(arr[temp[1]][temp[2]]==0)
                continue;
            int dir=temp[3];
            int xx=temp[1]+dx[dir];
            int yy=temp[2]+dy[dir];
            int check=0;
            while(!checkFishMove(xx,yy)){
                if(check>8)
                    break;
                dir=(dir+1)%8;
                check++;
                xx=temp[1]+dx[dir];
                yy=temp[2]+dy[dir];
            }
            if(check>8)
                continue;
            swap(temp,fish.get(arr[xx][yy]));
        }
    }

    private void swap(int[] fish1,int[] fish2){
        int[] temp1=new int[2];
        for(int i=1;i<3;i++){
            temp1[i-1]=fish1[i];
        }
        for(int i=1;i<3;i++){
            fish1[i]=fish2[i];
        }
        for(int i=1;i<3;i++){
            fish2[i]=temp1[i-1];
        }
        arr[fish1[1]][fish1[2]]=fish1[0];
        arr[fish2[1]][fish2[2]]=fish2[0];
    }

    private boolean checkFishMove(int x,int y){
        if(x<0 || x>3 || y<0 || y>3)
            return false;
        if(arr[x][y]==0 || (x==shark[0]&&y==shark[1]))
            return false;
        return true;
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        fish.add(new int[]{0,0,0,0});
        for(int i=0;i<4;i++){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<4;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                fish.add(new int[]{arr[i][j],i,j,Integer.parseInt(st.nextToken())-1});
            }
        }

        Collections.sort(fish,(o1,o2)->{
            return Integer.compare(o1[0],o2[0]);
        });

        shark[2]=fish.get(arr[0][0])[3];

        System.out.println(dfs(0,0));
    }
}
