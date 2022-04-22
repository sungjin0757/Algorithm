package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek23290 {
    int m,s;
    int[] fishDx =new int[]{0,-1,-1,-1,0,1,1,1};
    int[] fishDy =new int[]{-1,-1,0,1,1,1,0,-1};
    int[] sharkDx=new int[]{-1,0,1,0};
    int[] sharkDy=new int[]{0,-1,0,1};
    int[] shark=new int[2];
    int[][] smell=new int[5][5];
    int[][] fishCnt=new int[5][5];
    Queue<int[]> copyFish=new LinkedList<>();
    List<Fish> fishList=new ArrayList<>();
    List<int[]> sharkMoveIdx=new ArrayList<>();
    boolean[][] check=new boolean[100][100];
    int[] temp=new int[3];

    private void dfs(int x,int ix,int iy){
        if(x==3){
            sharkMoveIdx.add(temp.clone());
            return;
        }

        for(int i=0;i<4;i++){
            temp[x]=i;
            int xx=ix+sharkDx[i];
            int yy=iy+sharkDy[i];
            if(check[xx][yy]){
                continue;
            }
            check[xx][yy]=true;
            dfs(x+1,xx,yy);
            check[xx][yy]=false;
        }
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        m=Integer.parseInt(st.nextToken());
        s=Integer.parseInt(st.nextToken());

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine()," ");
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int dir=Integer.parseInt(st.nextToken())-1;
            fishList.add(new Fish(x,
                    y,dir));
            fishCnt[x][y]++;
        }

        st=new StringTokenizer(br.readLine(), " ");
        shark[0]=Integer.parseInt(st.nextToken());
        shark[1]=Integer.parseInt(st.nextToken());
        check[50][50]=true;
        dfs(0,50,50);

        for(int i=0;i<s;i++){
            process1();
            process2();
            process3();
            process4();
            process5();
        }
        System.out.println(fishList.size());
    }

    private void process1(){
        for(int i=0;i<fishList.size();i++){
            Fish fish = fishList.get(i);
            copyFish.add(new int[]{fish.x,fish.y,fish.dir});
        }
    }

    private void process2(){
        for(int i=0;i<fishList.size();i++){
            Fish fish = fishList.get(i);
            int x=fish.x;
            int y=fish.y;
            for(int j=0;j<8;j++){
                int dir=fish.dir-j;
                if(dir<0){
                    dir+=8;
                }
                int xx=x+ fishDx[dir];
                int yy=y+ fishDy[dir];
                if(0>=xx || xx>4 || 0>=yy || yy>4){
                    continue;
                }
                if(smell[xx][yy]!=0){
                    continue;
                }
                fish.x=xx;
                fish.y=yy;
                fish.dir=dir;
                fishCnt[x][y]--;
                fishCnt[xx][yy]++;
                break;
            }
        }
    }

    private void process3(){
        PriorityQueue<int[]> dq=new PriorityQueue<>((o1,o2)->{
            if(o1[5]==o2[5]) {
                if (o1[0] == o2[0]) {
                    if (o1[1] == o2[1]) {
                        return Integer.compare(o1[2], o2[2]);
                    }
                    return Integer.compare(o1[1], o2[1]);
                }
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(-o1[5],-o2[5]);
        });
        for(int i=0;i<sharkMoveIdx.size();i++){
            int[] sharkMove = sharkMoveIdx.get(i);
            int xx=shark[0]+sharkDx[sharkMove[0]];
            int yy=shark[1]+sharkDy[sharkMove[0]];
            int xxx=xx+sharkDx[sharkMove[1]];
            int yyy=yy+sharkDy[sharkMove[1]];
            int xxxx=xxx+sharkDx[sharkMove[2]];
            int yyyy=yyy+sharkDy[sharkMove[2]];
            if(xx<=0 || xx>4 || yy<=0 || yy>4 || xxx<=0 || xxx>4 || yyy<=0 || yyy>4 || xxxx<=0 || xxxx>4 || yyyy<=0 || yyyy>4){
                continue;
            }
            int temp=fishCnt[xx][yy]+fishCnt[xxx][yyy]+fishCnt[xxxx][yyyy];
            dq.offer(new int[]{sharkMove[0],sharkMove[1],sharkMove[2],xxxx,yyyy,temp});
        }
        int[] sharkPoll = dq.poll();
        int xx=shark[0]+sharkDx[sharkPoll[0]];
        int yy=shark[1]+sharkDy[sharkPoll[0]];
        int xxx=xx+sharkDx[sharkPoll[1]];
        int yyy=yy+sharkDy[sharkPoll[1]];
        int xxxx=xxx+sharkDx[sharkPoll[2]];
        int yyyy=yyy+sharkDy[sharkPoll[2]];
        shark[0]=sharkPoll[3];
        shark[1]=sharkPoll[4];
        if(fishCnt[xx][yy]>0){
            smell[xx][yy]=2;
            for(int i=0;i<fishCnt[xx][yy];i++){
                fishList.remove(new Fish(xx,yy,0));
            }
            fishCnt[xx][yy]=0;
        }
        if(fishCnt[xxx][yyy]>0){
            smell[xxx][yyy]=2;
            for(int i=0;i<fishCnt[xxx][yyy];i++){
                fishList.remove(new Fish(xxx,yyy,0));
            }
            fishCnt[xxx][yyy]=0;
        }
        if(fishCnt[xxxx][yyyy]>0){
            smell[xxxx][yyyy]=2;
            for(int i=0;i<fishCnt[xxxx][yyyy];i++){
                fishList.remove(new Fish(xxxx,yyyy,0));
            }
            fishCnt[xxxx][yyyy]=0;
        }
    }

    private void process4(){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(smell[i][j]>0){
                    smell[i][j]--;
                }
            }
        }
    }

    private void process5(){
        while (!copyFish.isEmpty()){
            int[] poll = copyFish.poll();
            fishList.add(new Fish(poll[0],poll[1],poll[2]));
            fishCnt[poll[0]][poll[1]]++;
        }
    }

    class Fish{
        int x;
        int y;
        int dir;

        @Override
        public boolean equals(Object o) {
            Fish compareFish = (Fish) o;

            return x==compareFish.x && y==compareFish.y;
        }

        public Fish(int x, int y, int dir){
            this.x=x;
            this.y=y;
            this.dir=dir;
        }
    }

}
