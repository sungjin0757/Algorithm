package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14499 {

    int n,m,x,y,k;
    int[][] arr;
    int[] dice=new int[6];
    int[][] loc=new int[][]{{0,1,2,3,4,5},
            {1,5,2,3,0,4},{2,1,5,0,4,3},{3,1,0,5,4,2},{4,0,2,3,5,1},
            {5,4,2,3,1,0}};
    int[] dx=new int[]{0,0,-1,1};
    int[] dy=new int[]{1,-1,0,0};

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        x=Integer.parseInt(st.nextToken());
        y=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        arr=new int[n][m];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        st=new StringTokenizer(br.readLine()," ");

        int[] location={x,y};

        int head=0;

        for(int i=0;i<k;i++){
            int temp=Integer.parseInt(st.nextToken());
            temp-=1;

            int xx=location[0]+dx[temp];
            int yy=location[1]+dy[temp];
            if(0<=xx && xx<n && 0<=yy && yy<m){
//                System.out.println(dice[head]);
                location[0]=xx;
                location[1]=yy;

                if(temp==0){
                    head=loc[head][3];
                }else if(temp==1){
                    head=loc[head][2];
                }else if(temp==2){
                    head=loc[head][4];
                }else if(temp==3){
                    head=loc[head][1];
                }

                if(arr[xx][yy]==0){
                    arr[xx][yy]=dice[loc[head][5]];
                }else if(arr[xx][yy]!=0){
                    dice[loc[head][5]]=arr[xx][yy];
                    arr[xx][yy]=0;
                }
                System.out.println(dice[head]);

            }

        }
    }
}
