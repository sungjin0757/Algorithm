package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek2637 {

    int n,m;
    int[][] arr;
    int[] normal;
    int[] numCheck;
    boolean[] check;

    private void dfs(int x,int y,int z){

        int cnt=0;

        if(!check[y]){
            if(x!=n)
                normal[y]+=arr[x][y]*z;
            else
                normal[y]+=arr[x][y];
        }

        else {
            for (int i = 1; i <= n; i++) {
                if(cnt>=numCheck[x])
                    break;
                if (arr[y][i] != 0) {
                    if(x!=n)
                        dfs(y,i,z*arr[y][i]);
                    else
                        dfs(y,i,z);
                    cnt+=1;
                }
            }
        }
    }

    public void solve() throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        m=Integer.parseInt(st.nextToken());
        arr=new int[n+1][n+1];
        normal=new int[n+1];
        check=new boolean[n+1];
        numCheck=new int[n+1];

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine()," ");
            int temp1=Integer.parseInt(st.nextToken());
            int temp2=Integer.parseInt(st.nextToken());
            int temp3=Integer.parseInt(st.nextToken());
            arr[temp1][temp2]=temp3;
            check[temp1]=true;
            numCheck[temp1]+=1;
        }

        for(int i=1;i<=n;i++){
            if(arr[n][i]!=0) {
                dfs(n, i, arr[n][i]);
            }
        }

        for(int i=1;i<=n;i++){
            if(check[i])
                continue;
            System.out.println(i+" "+normal[i]);
        }
    }
}
