package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek15684 {

    int n,m,h;
    int[][] arr;
    boolean res=false;

    private boolean check(int[][] map){
        for(int i=1;i<=n;i++){
            int temp=i;
            for(int j=1;j<=h;j++){
                if(map[j][temp]==1)
                    temp+=1;
                else if(map[j][temp-1]==1)
                    temp-=1;
            }
            if(temp!=i)
                return false;
        }
        return true;
    }

    private void dfs(int x,int cnt,int size){
        if(res)
            return;
        if(cnt==size){
            if(check(arr)){
                res=true;
            }
            return;
        }
        int i=x;
        while(i<n*h){
            int row=(i-1)/n+1;
            int col=(i-1)%n+1;
            i++;
            if(col==n || arr[row][col]==1 || arr[row][col-1]==1 || arr[row][col+1]==1)
                continue;
            arr[row][col]=1;
            dfs(x+1,cnt+1,size);
            arr[row][col]=0;
        }
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        h=Integer.parseInt(st.nextToken());

        arr=new int[h+1][n+1];

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine()," ");
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            arr[a][b]=1;
        }
        for(int i=0;i<4;i++){
            dfs(1,0,i);
            if(res){
                System.out.println(i);
                break;
            }
        }
        if(!res)
            System.out.println(-1);
    }
}
