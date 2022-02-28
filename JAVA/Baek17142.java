package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek17142 {

    int n,m;
    int[][] arr;
    boolean[][] check;
    int[] dx=new int[]{-1,1,0,0};
    int[] dy=new int[]{0,0,-1,1};
    int[] idx;
    List<int[]> virus=new ArrayList<>();
    Queue<int[]> v;
    int res=Integer.MAX_VALUE;
    int empty=0;

    private void clear(){
        Arrays.stream(check).forEach(c->{
            Arrays.fill(c,false);
        });
        v=new LinkedList<>();
    }

    private void dfs(int x,int y){
        if(x==m){
            clear();
            for(int i=0;i<m;i++){
                int[] t=virus.get(idx[i]);
                v.offer(new int[]{t[0],t[1],0});
                check[t[0]][t[1]]=true;
            }
            bfs(empty);
            return;
        }

        for(int i=y;i< virus.size();i++){
            idx[x]=i;
            dfs(x+1,i+1);
        }
    }

    private void bfs(int t){
        while(!v.isEmpty()){
            int[] vv=v.poll();
            for(int i=0;i<4;i++){
                int xx=vv[0]+dx[i];
                int yy=vv[1]+dy[i];
                if(0<=xx && xx<n && 0<=yy && yy<n){
                    if(!check[xx][yy] && arr[xx][yy]!=1){
                        if(arr[xx][yy]==0)
                            t--;
                        if(t==0){
                            res=Math.min(res,vv[2]+1);
                            return;
                        }
                        check[xx][yy]=true;
                        v.offer(new int[]{xx,yy,vv[2]+1});
                    }
                }
            }
        }
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        arr=new int[n][n];
        check=new boolean[n][n];
        idx=new int[m];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(arr[i][j]==2){
                    virus.add(new int[]{i,j});
                }else if(arr[i][j]==0)
                    empty++;
            }
        }
        if(empty==0){
            System.out.println(0);
            return;
        }
        dfs(0,0);
        if(res==Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(res);
    }
}
