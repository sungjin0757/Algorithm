package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek16236 {

    int n;
    int[][] arr,dp;
    int[] loc;
    int shark=2;
    int sec=0;
    Queue<int[]> fish=new LinkedList<>();
    boolean[][] check;
    boolean c=false;
    int[] dx=new int[]{-1,1,0,0};
    int[] dy=new int[]{0,0,-1,1};
    int fishTemp=0;

    private boolean finishCheck(){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(shark>arr[i][j] && 1<=arr[i][j] && arr[i][j]<=6)
                    return false;
            }
        }
        return true;
    }

    private void clear(){
        Arrays.stream(dp).forEach(d->{
            Arrays.fill(d,Integer.MAX_VALUE);
        });
        Arrays.stream(check).forEach(c->{
            Arrays.fill(c,false);
        });
    }

    private int bfs(int x,int y,int desX,int desY) {
        int min = Integer.MAX_VALUE;

        Queue<int[]> dq = new LinkedList<>();
        dq.offer(new int[]{x, y, 0});

        while (!dq.isEmpty()) {
            int[] poll = dq.poll();
            if (poll[0] == desX && poll[1] == desY) {
                min = Math.min(min, poll[2]);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int xx = poll[0] + dx[i];
                int yy = poll[1] + dy[i];
                if (0 < xx && xx <= n && 0 < yy && yy <= n) {
                    if (!check[xx][yy] && shark >= arr[xx][yy]) {
                        dq.offer(new int[]{xx, yy, poll[2] + 1});
                        check[xx][yy]=true;
                    }
                }
            }
        }
        return min;
    }

    private void save(){
        PriorityQueue<int[]> temp=new PriorityQueue<>((o1,o2)->{
            if(o1[2]==o2[2]){
                if(o1[0]==o2[0])
                    return Integer.compare(o1[1],o2[1]);
                return Integer.compare(o1[0],o2[0]);
            }
            return Integer.compare(o1[2],o2[2]);
        });

        while(!fish.isEmpty()){
            clear();
            int[] f=fish.poll();
            if(shark>arr[f[0]][f[1]]) {
                check[loc[0]][loc[1]]=true;
                temp.offer(new int[]{f[0], f[1], bfs(loc[0], loc[1], f[0], f[1])});
                check[loc[0]][loc[1]]=false;
            }
            else
                temp.offer(new int[]{f[0],f[1],Integer.MAX_VALUE});
        }

        int[] f=temp.poll();
        if(f[2]==Integer.MAX_VALUE){
            c=true;
            return;
        }
        fishTemp+=1;
        if(shark==fishTemp){
            shark+=1;
            fishTemp=0;
        }
        sec+=f[2];
        loc[0]=f[0];
        loc[1]=f[1];
        arr[f[0]][f[1]]=0;
        while(!temp.isEmpty()){
            f=temp.poll();
            fish.offer(new int[]{f[0],f[1]});
        }

    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        arr=new int[n+1][n+1];
        dp=new int[n+1][n+1];
        check=new boolean[n+1][n+1];

        for(int i=1;i<=n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(arr[i][j]==9){
                    loc=new int[]{i,j};
                    arr[i][j]=0;
                }
                if(1<=arr[i][j] && arr[i][j]<=6){
                    fish.offer(new int[]{i,j});
                }
            }
        }

        while(true){
            if(finishCheck() || c){
                break;
            }
            save();
        }
        System.out.println(sec);
    }
}
