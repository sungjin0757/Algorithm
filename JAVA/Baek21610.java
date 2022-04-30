package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek21610 {
    int[] dx=new int[]{0,-1,-1,-1,0,1,1,1};
    int[] dy=new int[]{-1,-1,0,1,1,1,0,-1};
    int n,m,d,s;
    int[][] arr;
    boolean[][] check;
    Queue<int[]> cloudList =new LinkedList<>();

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        arr=new int[n+1][n+1];
        check=new boolean[n+1][n+1];
        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        cloudList.add(new int[]{n,1});
        cloudList.add(new int[]{n,2});
        cloudList.add(new int[]{n-1,1});
        cloudList.add(new int[]{n-1,2});

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            d=Integer.parseInt(st.nextToken())-1;
            s=Integer.parseInt(st.nextToken());
            clear();
            stage1();
            stage2To4();
            stage5();
        }

        printRes();
    }

    private void clear(){
        Arrays.stream(check).forEach(c->Arrays.fill(c,false));
    }

    private void stage1(){
        while(!cloudList.isEmpty()){
            int[] c = cloudList.poll();
            bfs(c[0],c[1]);
        }
    }

    private void bfs(int x,int y){
        int xx=x;
        int yy=y;
        for(int i=1;i<=s;i++){
            xx+=dx[d];
            yy+=dy[d];
            if (xx <= 0) {
                xx = n;
            } else if (xx >= n + 1) {
                xx = 1;
            }

            if (yy <= 0) {
                yy = n;
            } else if (yy >= n + 1) {
                yy = 1;
            }
        }
        check[xx][yy]=true;
    }

    private void stage2To4(){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(check[i][j]){
                    arr[i][j]++;
                    int cnt=0;
                    for(int k=1;k<=7;k+=2){
                        int xx=i+dx[k];
                        int yy=j+dy[k];
                        if(xx<1 || xx>n || yy<1 || yy>n){
                            continue;
                        }
                        if(arr[xx][yy]>=1){
                            cnt++;
                        }
                    }
                    arr[i][j]+=cnt;
                }
            }
        }
    }

    private void stage5(){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(check[i][j]){
                    continue;
                }
                if(arr[i][j]>=2){
                    cloudList.add(new int[]{i,j});
                    arr[i][j]-=2;
                }
            }
        }
    }

    private void printRes(){
        int res=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                res+=arr[i][j];
            }
        }
        System.out.println(res);
    }
}
