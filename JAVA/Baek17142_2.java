package simulation;
import java.io.*;
import java.util.*;

public class Baek17142_2 {
    int n,m;
    int[][] arr,temp;
    boolean[][] check;
    int[] dx=new int[]{-1,1,0,0};
    int[] dy=new int[]{0,0,-1,1};
    int[] idx;
    List<int[]> virus=new ArrayList<>();
    Queue<int[]> v;
    int res=Integer.MAX_VALUE;

    private void clear(){
        Arrays.stream(check).forEach(c->{
            Arrays.fill(c,false);
        });
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                temp[i][j]=arr[i][j];
            }
        }
        v=new LinkedList<>();
    }

    private void dfs(int x,int y){
        if(x==m){
            clear();
            for(int i=0;i<m;i++){
                int[] t=virus.get(idx[i]);
                v.offer(new int[]{t[0],t[1]});
                temp[t[0]][t[1]]=3;
                check[t[0]][t[1]]=true;
            }
            dfs2(0,v);
            return;
        }

        for(int i=y;i< virus.size();i++){
            idx[x]=i;
            dfs(x+1,i+1);
        }
    }

    private boolean ch(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(temp[i][j]==0) {
                    return false;
                }
            }
        }
        return true;
    }

    private void dfs2(int t,Queue<int[]> d){
        if(ch()){
            res=Math.min(t,res);
            return;
        }
        if(d.isEmpty()){
            return;
        }
        if(t>=res)
            return;

        Queue<int[]> dq=new LinkedList<>();
        while(!d.isEmpty()){
            int[] vv=d.poll();
            for(int i=0;i<4;i++){
                int xx=vv[0]+dx[i];
                int yy=vv[1]+dy[i];
                if(0<=xx && xx<n && 0<=yy && yy<n){
                    if(!check[xx][yy] && temp[xx][yy]!=1){
                        check[xx][yy]=true;
                        temp[xx][yy]=3;
                        dq.offer(new int[]{xx,yy});
                    }
                }
            }
        }
        dfs2(t+1,dq);
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        arr=new int[n][n];
        check=new boolean[n][n];
        temp=new int[n][n];
        idx=new int[m];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                if(arr[i][j]==2){
                    virus.add(new int[]{i,j});
                }
            }
        }
        dfs(0,0);
        if(res==Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(res);
    }
}
