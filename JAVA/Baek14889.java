package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek14889 {

    int n;
    int[][] arr;
    Map<String,Integer> map=new HashMap<>();
    int[] temp;
    int res=Integer.MAX_VALUE;
    boolean[] check;

    private int sum(int[] t){
        int sum=0;
        for(int i=0;i<n/2;i++){
            for(int j=i+1;j<n/2;j++){
                sum+=arr[t[i]][t[j]]+arr[t[j]][t[i]];
            }
        }
        return sum;
    }

    private void dfs(int x,int y){
        if(x==n/2){

            int[] t=new int[n/2];
            int tt=0;
            for(int i=1;i<=n;i++){
                if(!check[i]){
                    t[tt]=i;
                    tt++;
                }
            }
            res=Math.min(Math.abs(sum(temp)-sum(t)),res);
            return;
        }

        for(int i=y+1;i<=n;i++){
            if(!check[i]){
                temp[x]=i;
                check[i]=true;
                dfs(x+1,i);
                check[i]=false;
            }
        }
    }

    public void solve() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());

        StringTokenizer st;
        arr=new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine()," ");

            for(int j=1;j<=n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        check=new boolean[n+1];
        temp=new int[n/2];
        dfs(0,0);
        System.out.println(res);
    }
}
