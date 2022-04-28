package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Baek19238 {

    int n,m,fuel;
    int[][] arr,dp,dis;
    int[] driver=new int[2];
    int[] dx=new int[]{-1,1,0,0};
    int[] dy=new int[]{0,0,-1,1};
    boolean[][] check;
    Map<Integer,int[]> user=new HashMap<>();
    Map<Integer,int[]> dest=new HashMap<>();

    private void clear(){
        Arrays.stream(dp).forEach(d->Arrays.fill(d,10000));
    }

    private int dfs(int x,int y,int desX,int desY){
        if(x==desX && y==desY){
            return 0;
        }
        if(dp[x][y]!=10000){
            return dp[x][y];
        }
        for(int i=0;i<4;i++){
            int xx=x+dx[i];
            int yy=y+dy[i];
            if(xx<=0 || xx>n || yy<=0 || yy>n){
                continue;
            }
            if(arr[xx][yy]==1 || check[xx][yy]){
                continue;
            }
            check[xx][yy]=true;
            dp[x][y]=Math.min(dp[x][y],dfs(xx,yy,desX,desY));
            check[xx][yy]=false;
        }
        if(dp[x][y]==10000){
            return 10000;
        }
        return dp[x][y]+=1;
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        fuel=Integer.parseInt(st.nextToken());

        arr=new int[n+1][n+1];
        check=new boolean[n+1][n+1];
        dp=new int[n+1][n+1];
        dis=new int[m][m];

        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        st=new StringTokenizer(br.readLine()," ");
        driver[0]=Integer.parseInt(st.nextToken());
        driver[1]=Integer.parseInt(st.nextToken());

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken());
            int y1=Integer.parseInt(st.nextToken());
            int x2=Integer.parseInt(st.nextToken());
            int y2=Integer.parseInt(st.nextToken());

            user.put(i,new int[]{x1,y1});
            dest.put(i,new int[]{x2,y2});
            clear();
            check[x1][y1]=true;
            dis[i][i]=dfs(x1,y1,x2,y2);
            check[x1][y1]=false;
            for(int j=0;j<i;j++){
                if(i==j){
                    continue;
                }
                int[] userIdx = user.get(j);
                int[] destIdx = dest.get(j);
                clear();
                check[x1][y1]=true;
                dis[i][j]=dfs(x1,y1,destIdx[0],destIdx[1]);
                check[x1][y1]=false;
                clear();
                check[x2][y2]=true;
                dis[j][i]=dfs(x2,y2,userIdx[0],userIdx[1]);
                check[x2][y2]=false;
            }
        }

    }
}
