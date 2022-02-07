package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baek16234 {

    int n,l,r;
    int[][] arr;
    boolean[][] check;
    List<int[]>[] temp;
    int[] dx=new int[]{-1,1,0,0};
    int[] dy=new int[]{0,0,-1,1};
    int res=0;

    private void dfs(int x,int y,int idx){

        temp[idx].add(new int[]{x,y});

        for(int i=0;i<4;i++){
            int xx=x+dx[i];
            int yy=y+dy[i];
            if(0<=xx && xx<n && 0<=yy && yy<n){
                int c=Math.abs(arr[x][y]-arr[xx][yy]);
                if(!check[xx][yy] && l<=c && c<=r){
                    check[xx][yy]=true;
                    dfs(xx,yy,idx);
                }
            }
        }
    }

    private void clear(){
        for(int i=0;i<n;i++){
            Arrays.fill(check[i],false);
        }
    }

    private boolean ch(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(check[i][j])
                    return false;
            }
        }
        return true;
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        l=Integer.parseInt(st.nextToken());
        r=Integer.parseInt(st.nextToken());

        arr=new int[n][n];
        check=new boolean[n][n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            clear();
            temp=new ArrayList[n*n];
            int idx=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(!check[i][j]){
                        temp[idx]=new ArrayList<>();
                        check[i][j]=true;
                        dfs(i,j,idx);
                        check[i][j]=false;
                        idx++;
                    }
                }
            }
            for(int i=0;i<idx;i++){
                List<int[]> t=temp[i];
                if(t.size()!=1){
                    int sum=0;
                    for(int[] j : t){
                        sum+=arr[j[0]][j[1]];
                    }
                    for(int[] j : t){
                        arr[j[0]][j[1]]=sum/t.size();
                    }
                }
            }

            if(ch())
                break;
            else
                res++;
        }
        System.out.println(res);
    }
}
