package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek19237 {
    int n,m,k,res;
    int[][][] priority;
    int[] dx=new int[]{-1,1,0,0};
    int[] dy=new int[]{0,0,-1,1};
    List<Integer>[] shark;
    int[][] smell_k;
    int[][] smell_sharkNum;

    private boolean checkFinish(){
        for(int i=2;i<=m;i++){
            if(shark[i].get(0)!=-1){
                return false;
            }
        }
        return true;
    }
    private void killShark(){
        for(int i=1;i<m;i++){
            int x=shark[i].get(0);
            int y=shark[i].get(1);
            if(x==-1){
                continue;
            }
            for(int j=i+1;j<=m;j++){
                int xx=shark[j].get(0);
                int yy=shark[j].get(1);
                if(xx==-1){
                    continue;
                }
                if(x==xx && y==yy){
                    move(j,new int[]{-1,-1,-1});
                }
            }
        }
    }

    private void smell(){
        for(int i=1;i<=m;i++){
            int x=shark[i].get(0);
            int y=shark[i].get(1);
            if(x==-1){
                continue;
            }
            smell_k[x][y]=k;
            smell_sharkNum[x][y]=i;
        }
    }

    private void xSmell(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(smell_k[i][j]==0){
                    continue;
                }
                smell_k[i][j]--;
                if(smell_k[i][j]==0){
                    smell_sharkNum[i][j]=0;
                }
            }
        }
    }
    private void move(int num,int[] temp){
        shark[num].set(0,temp[0]);
        shark[num].set(1,temp[1]);
        shark[num].set(2,temp[2]);
    }

    private void process(){
        for(int i=1;i<=m;i++){
            int x=shark[i].get(0);
            int y=shark[i].get(1);
            int dir=shark[i].get(2);
            if(x==-1){
                continue;
            }
            int[] temp = p2(x, y, i,dir,0);
            if(temp[0]!=-1){
                move(i,temp);
                continue;
            }
            temp=p2(x,y,i,dir,i);
            if(temp[0]!=-1){
                move(i,temp);
                continue;
            }
        }
    }

    private int[] p2(int x,int y,int sh,int dir,int val){
        int[] temp=new int[]{-1,-1,-1};
        for(int i=0;i<4;i++){
            int xx=x+dx[priority[sh][dir][i]];
            int yy=y+dy[priority[sh][dir][i]];
            if(xx<0 || xx>=n || yy<0 || yy>=n){
                continue;
            }
            if(smell_sharkNum[xx][yy]==val){
                temp[0]=xx;
                temp[1]=yy;
                temp[2]=priority[sh][dir][i];
                return temp;
            }
        }
        return temp;
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        priority=new int[m+1][4][4];
        shark=new ArrayList[n+1];
        smell_sharkNum=new int[n][n];
        smell_k=new int[n][n];
        for(int i=1;i<=m;i++){
            shark[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++){
                String temp = st.nextToken();
                if(!temp.equals("0")){
                    int num = Integer.parseInt(temp);
                    shark[num].add(i);
                    shark[num].add(j);
                }
            }
        }
        st=new StringTokenizer(br.readLine()," ");
        for(int i=1;i<=m;i++){
            shark[i].add(Integer.parseInt(st.nextToken())-1);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<4;j++){
                st=new StringTokenizer(br.readLine()," ");
                for(int k=0;k<4;k++){
                    priority[i+1][j][k]=Integer.parseInt(st.nextToken())-1;
                }
            }
        }

        res=0;
        while(true){
            if(res==1001){
                System.out.println(-1);
                return;
            }

            if(checkFinish()){
                break;
            }
            smell();
            process();
            killShark();
            res++;
            xSmell();
        }
        System.out.println(res);
    }
}
