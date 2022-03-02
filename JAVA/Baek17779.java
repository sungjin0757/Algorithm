package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek17779 {

    int n;
    int[][] arr;
    boolean[][] check;
    int[] dx=new int[]{1,1};
    int[] dy=new int[]{1,-1};
    int res=Integer.MAX_VALUE;

    private void dfs(int x,int y,int limit,int dir){
        check[x][y]=true;

        if(limit==0)
            return;

        dfs(x+dx[dir],y+dy[dir],limit-1,dir);
    }

    private void clear(){
        Arrays.stream(check).forEach(c->{
            Arrays.fill(c,false);
        });
    }

    private void s1(int x,int y){
        for(int d1=1;d1<=n;d1++){
            if(y-d1<1)
                continue;
            for(int d2=1;d2<=n;d2++){
                if(x+d1+d2>n || y+d2>n)
                    continue;
                s2(x,y,d1,d2);
                res=Math.min(s3(x,y,d1,d2),res);
            }
        }
    }

    private void s2(int x,int y,int d1,int d2){
        clear();
        dfs(x,y,d1,1);
        dfs(x,y,d2,0);
        dfs(x+d1,y-d1,d2,0);
        dfs(x+d2,y+d2,d1,1);
    }

    private int s3(int x,int y,int d1,int d2){
        List<Integer> t=new ArrayList<>();

        int temp=0;
        for(int i=x;i<=x+d1+d2;i++){
            if(i==x){
                temp+=arr[i][y];
                continue;
            }
            if(i==x+d1+d2){
                temp+=arr[i][y+d2-d1];
                continue;
            }
            for(int j=y-d1;j<=y+d2;j++){
                if(!check[i][j])
                    continue;
                temp+=arr[i][j];
                for(int k=j+1;k<=y+d2;k++){
                    temp+=arr[i][k];
                    if(check[i][k])
                        break;
                }
                break;
            }
        }
        t.add(temp);

        temp=f(1,1,x+d1-1,y,1);
        t.add(temp);

        temp=f(1,y+1,x+d2,n,2);
        t.add(temp);

        temp=f(x+d1,1,n,y-d1+d2-1,1);
        t.add(temp);

        temp=f(x+d2+1,y-d1+d2,n,n,2);
        t.add(temp);

        Collections.sort(t);

        return t.get(4)-t.get(0);
    }

    private int f(int x,int y,int xx,int yy,int dir){
        int temp=0;
        if(dir==2){
            for(int i=xx;i>=x;i--){
                for(int j=yy;j>=y;j--){
                    if(check[i][j])
                        break;
                    temp+=arr[i][j];
                }
            }
            return temp;
        }
        for(int i=x;i<=xx;i++){
            for(int j=y;j<=yy;j++){
                if(check[i][j])
                    break;
                temp+=arr[i][j];
            }
        }
        return temp;
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        arr=new int[n+1][n+1];
        check=new boolean[n+1][n+1];

        for(int i=1;i<=n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                s1(i,j);
            }
        }

        System.out.println(res);
    }
}
